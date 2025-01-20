package br.com.acerta.service;

import br.com.acerta.dto.DisciplinaDto;
import br.com.acerta.model.Disciplina;
import br.com.acerta.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public Disciplina criarDisciplina(DisciplinaDto disciplinaDto) {
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(disciplinaDto.getNome());
        return disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> listarDisciplinas() {
        return disciplinaRepository.findAll();
    }

    public Disciplina editarDisciplina(Long id, DisciplinaDto disciplinaDto) {
        Disciplina disciplina = disciplinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));
        disciplina.setNome(disciplinaDto.getNome());
        return disciplinaRepository.save(disciplina);
    }

    public void excluirDisciplina(Long id) {
        disciplinaRepository.deleteById(id);
    }

    public Disciplina buscarDisciplinaPorId(Long id) {
        return disciplinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));
    }
}
