package br.com.acerta.controller;

import br.com.acerta.dto.UsuarioDisciplinaDto;
import br.com.acerta.model.Disciplina;
import br.com.acerta.model.UsuarioDisciplina;
import br.com.acerta.model.Usuarios;
import br.com.acerta.repository.DisciplinaRepository;
import br.com.acerta.repository.UsuariosRepository;
import br.com.acerta.service.UsuarioDisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios-disciplinas")
public class UsuarioDisciplinaController {

    @Autowired
    private UsuarioDisciplinaService usuarioDisciplinaService;

    @PostMapping
    public ResponseEntity<UsuarioDisciplinaDto> cadastrar(@RequestBody UsuarioDisciplinaDto usuarioDisciplinaDto) {
        UsuarioDisciplinaDto usuarioDisciplina = usuarioDisciplinaService.criarUsuarioDisciplina(usuarioDisciplinaDto);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioDisciplina);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDisciplinaDto>> listar() {
        List<UsuarioDisciplinaDto> lista = usuarioDisciplinaService.listarUsuariosDisciplinas();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDisciplinaDto> atualizar(@PathVariable Long id,
                                                          @RequestBody UsuarioDisciplinaDto usuarioDisciplinaDto) {
        UsuarioDisciplinaDto usuarioDisciplina = usuarioDisciplinaService.editarUsuarioDisciplina(id, usuarioDisciplinaDto);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioDisciplina);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable Long id) {
        usuarioDisciplinaService.excluirUsuarioDisciplina(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<UsuarioDisciplinaDto>> listarDisciplinas(@PathVariable Long id) {
        List<UsuarioDisciplinaDto> lista = usuarioDisciplinaService.listarDisciplinasUsuario(id);
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

}