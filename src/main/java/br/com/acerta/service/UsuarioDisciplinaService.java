package br.com.acerta.service;

import br.com.acerta.dto.UsuarioDisciplinaDto;
import br.com.acerta.model.Disciplina;
import br.com.acerta.model.UsuarioDisciplina;
import br.com.acerta.model.Usuarios;
import br.com.acerta.repository.DisciplinaRepository;
import br.com.acerta.repository.UsuarioDisciplinaRepository;
import br.com.acerta.repository.UsuariosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public UsuarioDisciplinaDto criarUsuarioDisciplina(UsuarioDisciplinaDto usuarioDisciplinaDto) {
        if (usuarioDisciplinaDto.getUsuariosDto() == null || usuarioDisciplinaDto.getDisciplinaDto() == null) {
            throw new IllegalArgumentException("Usuário e Disciplina são obrigatórios para criar o vínculo.");
        }

        Usuarios userEntity = usuariosRepository.findById(usuarioDisciplinaDto.getUsuariosDto())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + usuarioDisciplinaDto.getUsuariosDto()));

        Disciplina disciplinaEntity = disciplinaRepository.findById(usuarioDisciplinaDto.getDisciplinaDto())
                .orElseThrow(() -> new EntityNotFoundException("Disciplina não encontrada com ID: " + usuarioDisciplinaDto.getDisciplinaDto()));

        UsuarioDisciplina usuarioDisciplina = new UsuarioDisciplina(
                userEntity,
                disciplinaEntity,
                usuarioDisciplinaDto.getRespostasCertas() != null ? usuarioDisciplinaDto.getRespostasCertas() : 0
        );

        usuarioDisciplina = usuarioDisciplinaRepository.save(usuarioDisciplina);

        return converterParaDto(usuarioDisciplina);
    }

    public List<UsuarioDisciplinaDto> listarUsuariosDisciplinas() {
        // Busca todas as entidades e converte para DTOs
        return usuarioDisciplinaRepository.findAll()
                .stream()
                .map(this::converterParaDto) // Converte cada entidade para DTO
                .toList(); // Retorna uma lista de DTOs
    }

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

    public void excluirUsuarioDisciplina(Long id) {
        Optional<UsuarioDisciplina> usuarioDisciplina = usuarioDisciplinaRepository.findById(id);
        if (usuarioDisciplina.isEmpty()) {
            return;
        }

        usuarioDisciplinaRepository.deleteById(id);
    }

    public UsuarioDisciplina buscarUsuarioDisciplinaPorId(Long id) {
        Optional<UsuarioDisciplina> usuarioDisciplina = usuarioDisciplinaRepository.findById(id);
        if (usuarioDisciplina.isEmpty()) {
            return null;
        }
        return usuarioDisciplina.get();
    }

    private UsuarioDisciplinaDto converterParaDto(UsuarioDisciplina usuarioDisciplina) {
        UsuarioDisciplinaDto dto = new UsuarioDisciplinaDto();
        dto.setId(usuarioDisciplina.getId());

        if (usuarioDisciplina.getDisciplina() != null) {
            dto.setDisciplinaDto(usuarioDisciplina.getDisciplina().getId());
        }

        if (usuarioDisciplina.getUsuario() != null) {
            dto.setUsuariosDto(usuarioDisciplina.getUsuario().getId());
        }

        dto.setRespostasCertas(
                usuarioDisciplina.getRespostasCertas() != null ? usuarioDisciplina.getRespostasCertas() : 0
        );

        return dto;
    }
}