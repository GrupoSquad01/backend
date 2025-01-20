package br.com.acerta.controller;

import br.com.acerta.dto.DisciplinaUsuarioDto;
import br.com.acerta.model.DisciplinaUsuario;
import br.com.acerta.service.DisciplinaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas-usuarios")
public class DisciplinaUsuarioController {
    @Autowired
    private DisciplinaUsuarioService disciplinaUsuarioService;

    @PostMapping
    public ResponseEntity<DisciplinaUsuario> associar(@RequestBody DisciplinaUsuarioDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaUsuarioService.associarDisciplinaUsuario(dto));
    }

    @GetMapping
    public ResponseEntity<List<DisciplinaUsuario>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaUsuarioService.listarDisciplinasUsuarios());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplinaUsuario> atualizar(@PathVariable Long id, @RequestBody DisciplinaUsuarioDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaUsuarioService.editarDisciplinaUsuario(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        disciplinaUsuarioService.excluirDisciplinaUsuario(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaUsuario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaUsuarioService.buscarDisciplinaUsuarioPorId(id));
    }
}
