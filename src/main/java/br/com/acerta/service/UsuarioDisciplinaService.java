package br.com.acerta.service;

import br.com.acerta.dto.UsuarioDisciplinaDto;
import br.com.acerta.model.UsuarioDisciplina;
import br.com.acerta.repository.UsuarioDisciplinaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioDisciplinaService {

    @Autowired
    UsuarioDisciplinaRepository usuarioDisciplinaRepository;

    public UsuarioDisciplina criarUsuarioDisciplina(UsuarioDisciplinaDto usuarioDisciplinaDto) {
        var usuarioDisciplina = new UsuarioDisciplina();
        BeanUtils.copyProperties(usuarioDisciplinaDto, usuarioDisciplina);
        return usuarioDisciplinaRepository.save(usuarioDisciplina);
    }

    public List<UsuarioDisciplina> listarUsuariosDisciplinas() {
        return usuarioDisciplinaRepository.findAll();
    }

    public UsuarioDisciplina editarUsuarioDisciplina(Long id, UsuarioDisciplinaDto usuarioDisciplinaDto) {
        Optional<UsuarioDisciplina> usuarioDisciplina = usuarioDisciplinaRepository.findById(id);

        if (usuarioDisciplina.isEmpty()) {
            return null;
        }

        BeanUtils.copyProperties(usuarioDisciplinaDto, usuarioDisciplina.get());
        return usuarioDisciplinaRepository.save(usuarioDisciplina.get());
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
}
