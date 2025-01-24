package br.com.acerta.service;

import br.com.acerta.dto.DisciplinaDto;
import br.com.acerta.model.Disciplina;
import br.com.acerta.repository.DisciplinaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public DisciplinaDto criarDisciplina(DisciplinaDto disciplinaDto) {
        var disciplina = new Disciplina();

        BeanUtils.copyProperties(disciplinaDto, disciplina);
        disciplinaRepository.saveAndFlush(disciplina);

        disciplinaDto.setId(disciplina.getId());

        return disciplinaDto;
    }

    public List<DisciplinaDto> listarDisciplinas() {
        List<Disciplina> disciplinas = disciplinaRepository.findAll();
        List<DisciplinaDto> disciplinasDto = new ArrayList<>();

        for (Disciplina disciplina : disciplinas) {
            DisciplinaDto disciplinaDto = new DisciplinaDto();
            BeanUtils.copyProperties(disciplina, disciplinaDto);
            disciplinasDto.add(disciplinaDto);
        }

        return disciplinasDto;
    }

    public DisciplinaDto editarDisciplina(Long id, DisciplinaDto disciplinaDto) {
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);

        if (disciplina.isEmpty()) {
            throw new ServiceException("Disciplina não encontrada");
        }

        Disciplina disciplinaEdit = disciplina.get();

        if (disciplinaDto.getNome() != null)
            disciplinaEdit.setNome(disciplinaDto.getNome());
        else
            disciplinaDto.setNome(disciplinaEdit.getNome());

        disciplinaRepository.save(disciplinaEdit);

        BeanUtils.copyProperties(disciplinaEdit, disciplinaDto);

        return disciplinaDto;
    }

    public void excluirDisciplina(Long id) {
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
        if (disciplina.isEmpty()) {
            throw new ServiceException("Disciplina não encontrada");
        }

        disciplinaRepository.deleteById(id);
    }

    public DisciplinaDto buscarDisciplinaPorId(Long id) {
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
        if (disciplina.isEmpty()) {
            throw new ServiceException("Disciplina não encontada");
        }
        DisciplinaDto disciplinaDto = new DisciplinaDto();
        BeanUtils.copyProperties(disciplina.get(), disciplinaDto);

        return disciplinaDto;
    }
}
