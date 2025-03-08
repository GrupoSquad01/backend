package br.com.acerta.service;

import br.com.acerta.dto.DisciplinaDto;
import br.com.acerta.dto.UsuarioDisciplinaDto;
import br.com.acerta.dto.UsuariosDto;
import br.com.acerta.model.Disciplina;
import br.com.acerta.model.UsuarioDisciplina;
import br.com.acerta.model.Usuarios;
import br.com.acerta.repository.DisciplinaRepository;
import br.com.acerta.repository.UsuarioDisciplinaRepository;
import br.com.acerta.repository.UsuariosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioDisciplinaService {

    @Autowired
    private UsuarioDisciplinaRepository usuarioDisciplinaRepository;
    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    //criar nova relacao
    public UsuarioDisciplinaDto criarUsuarioDisciplina(UsuarioDisciplinaDto usuarioDisciplinaDto) {
        //validacoes
        if (usuarioDisciplinaDto.getUsuariosDto() == null || usuarioDisciplinaDto.getDisciplinaDto() == null) {
            throw new IllegalArgumentException("Usuário e Disciplina são obrigatórios para criar o vínculo.");
        }

        Usuarios userEntity = usuariosRepository.findById(usuarioDisciplinaDto.getUsuariosDto())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Usuário não encontrado com ID: " + usuarioDisciplinaDto.getUsuariosDto()
                ));


        Disciplina disciplinaEntity = disciplinaRepository.findById(usuarioDisciplinaDto.getDisciplinaDto())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Disciplina não encontrada com ID: " + usuarioDisciplinaDto.getDisciplinaDto()
                ));

        validaRelacaoExistente(userEntity, disciplinaEntity);
        //conversão de tipo de entidade e salvamento no banco
        UsuarioDisciplina usuarioDisciplina = new UsuarioDisciplina(
                userEntity,
                disciplinaEntity,
                usuarioDisciplinaDto.getRespostasCertas() != null ? usuarioDisciplinaDto.getRespostasCertas() : 0
        );

        usuarioDisciplina = usuarioDisciplinaRepository.save(usuarioDisciplina);

        return converterParaDto(usuarioDisciplina);
    }

    //listar todas relacoes
    public List<UsuarioDisciplinaDto> listarUsuariosDisciplinas() {
        return usuarioDisciplinaRepository.findAll().stream().map(this::converterParaDto).toList();
    }

    //listar todas disciplinas de um usuario
    public List<UsuarioDisciplinaDto> listarDisciplinasUsuario(Long usuario) {
        Usuarios userEntity = usuariosRepository.findById(usuario)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + usuario));

        return usuarioDisciplinaRepository.findByUsuario(userEntity).stream().map(this::converterParaDto).toList();
    }

    //editarUsuariosDisciplina(respostas certas)
    public UsuarioDisciplinaDto editarUsuarioDisciplina(Long id, UsuarioDisciplinaDto usuarioDisciplinaDto) {
        Optional<UsuarioDisciplina> usuarioDisciplina = usuarioDisciplinaRepository.findById(id);

        if (usuarioDisciplina.isEmpty()) {
            return null;
        }

        UsuarioDisciplina usuarioDisciplinaEntity = usuarioDisciplina.get();

        usuarioDisciplinaEntity.setRespostasCertas(usuarioDisciplinaDto.getRespostasCertas());

        usuarioDisciplinaRepository.save(usuarioDisciplinaEntity);
        return converterParaDto(usuarioDisciplina.get());
    }

    //excluir usuariosDisciplinas
    public void excluirUsuarioDisciplina(Long id) {
        Optional<UsuarioDisciplina> usuarioDisciplina = usuarioDisciplinaRepository.findById(id);
        if (usuarioDisciplina.isEmpty()) {
            return;
        }

        usuarioDisciplinaRepository.deleteById(id);
    }


    //    Métodos de apoio
    public UsuarioDisciplinaDto converterParaDto(UsuarioDisciplina usuarioDisciplina) {
        if (usuarioDisciplina == null) {
            return null;
        }

        UsuariosDto usuariosDto = new UsuariosDto();
        usuariosDto.setId(usuarioDisciplina.getUsuario().getId());
        usuariosDto.setNome(usuarioDisciplina.getUsuario().getNome());
        usuariosDto.setEmail(usuarioDisciplina.getUsuario().getEmail());
        // Adicione outros campos relevantes de Usuarios, se houver.

        DisciplinaDto disciplinaDto = new DisciplinaDto();
        disciplinaDto.setId(usuarioDisciplina.getDisciplina().getId());
        disciplinaDto.setNome(usuarioDisciplina.getDisciplina().getNome());
        // Adicione outros campos relevantes de Disciplina, se houver.

        UsuarioDisciplinaDto dto = new UsuarioDisciplinaDto();
        dto.setId(usuarioDisciplina.getId());
        dto.setUsuariosDto(usuariosDto.getId());
        dto.setDisciplinaDto(disciplinaDto.getId());
        dto.setRespostasCertas(usuarioDisciplina.getRespostasCertas());

        return dto;
    }


    private void validaRelacaoExistente(Usuarios user, Disciplina disciplina) {
        Optional<List<UsuarioDisciplina>> relacaoFound = usuarioDisciplinaRepository.findByRelacao(user, disciplina);
        if(relacaoFound.isPresent())
            throw new ServiceException("Já existe essa relação de usuário/disciplina!" );
    }
}