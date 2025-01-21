package br.com.acerta.service;

import br.com.acerta.dto.DisciplinaDto;
import br.com.acerta.model.Disciplina;
import br.com.acerta.repository.DisciplinaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    public Disciplina criarDisciplina(DisciplinaDto disciplinaDto) {
        var disciplina = new Disciplina();
        BeanUtils.copyProperties(disciplinaDto, disciplina);
        return disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> listarDisciplinas() {
        return disciplinaRepository.findAll();
    }

    public Disciplina editarDisciplina(Long id, DisciplinaDto disciplinaDto) {
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);

        if (disciplina.isEmpty()) {
            return null;
        }

        BeanUtils.copyProperties(disciplinaDto, disciplina.get());
        return disciplinaRepository.save(disciplina.get());
    }

    public void excluirDisciplina(Long id) {
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
        if (disciplina.isEmpty()) {
            return;
        }

        disciplinaRepository.deleteById(id);
    }

    public Disciplina buscarDisciplinaPorId(Long id) {
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
        if (disciplina.isEmpty()) {
            return null;
        }
        return disciplina.get();
    }
}
