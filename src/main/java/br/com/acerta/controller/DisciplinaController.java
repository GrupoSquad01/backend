package br.com.acerta.controller;

import br.com.acerta.dto.DisciplinaDto;
import br.com.acerta.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {
    @Autowired
    private DisciplinaService disciplinaService;

    @PostMapping
    public ResponseEntity<DisciplinaDto> cadastrar(@RequestBody DisciplinaDto disciplinaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaService.criarDisciplina(disciplinaDto));
    }

    @GetMapping
    public ResponseEntity<List<DisciplinaDto>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.listarDisciplinas());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplinaDto> atualizar(@PathVariable Long id, @RequestBody DisciplinaDto disciplinaDto) {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.editarDisciplina(id, disciplinaDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        disciplinaService.excluirDisciplina(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.buscarDisciplinaPorId(id));
    }
}
