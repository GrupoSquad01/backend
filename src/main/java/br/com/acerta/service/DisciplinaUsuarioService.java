package br.com.acerta.service;

import br.com.acerta.dto.DisciplinaUsuarioDto;
import br.com.acerta.model.DisciplinaUsuario;
import br.com.acerta.repository.DisciplinaUsuarioRepository;
import br.com.acerta.repository.DisciplinaRepository;
import br.com.acerta.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaUsuarioService {
    @Autowired
    private DisciplinaUsuarioRepository disciplinaUsuarioRepository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;
    @Autowired
    private UsuariosRepository usuariosRepository;

    public DisciplinaUsuario associarDisciplinaUsuario(DisciplinaUsuarioDto dto) {
        DisciplinaUsuario disciplinaUsuario = new DisciplinaUsuario();
        disciplinaUsuario.setUsuario(usuariosRepository.findById(dto.getUsuarioId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado")));
        disciplinaUsuario.setDisciplina(disciplinaRepository.findById(dto.getDisciplinaId()).orElseThrow(() -> new RuntimeException("Disciplina não encontrada")));
        disciplinaUsuario.setProgresso(dto.getProgresso());
        return disciplinaUsuarioRepository.save(disciplinaUsuario);
    }

    public List<DisciplinaUsuario> listarDisciplinasUsuarios() {
        return disciplinaUsuarioRepository.findAll();
    }

    public DisciplinaUsuario editarDisciplinaUsuario(Long id, DisciplinaUsuarioDto dto) {
        DisciplinaUsuario disciplinaUsuario = disciplinaUsuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DisciplinaUsuario não encontrada"));
        disciplinaUsuario.setProgresso(dto.getProgresso());
        return disciplinaUsuarioRepository.save(disciplinaUsuario);
    }

    public void excluirDisciplinaUsuario(Long id) {
        disciplinaUsuarioRepository.deleteById(id);
    }

    public DisciplinaUsuario buscarDisciplinaUsuarioPorId(Long id) {
        return disciplinaUsuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DisciplinaUsuario não encontrada"));
    }
}
