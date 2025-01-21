package br.com.acerta.controller;

import br.com.acerta.dto.UsuarioDisciplinaDto;  // Se você estiver usando DTOs
import br.com.acerta.model.UsuarioDisciplina;
import br.com.acerta.service.UsuarioDisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios-disciplinas")
public class UsuariosController {

    @Autowired
    private UsuarioDisciplinaService usuarioDisciplinaService;

    // Método para cadastrar um novo registro de usuario-disciplina
    @PostMapping
    public ResponseEntity<UsuarioDisciplina> cadastrar(@RequestBody UsuarioDisciplinaDto usuarioDisciplinaDto) {
        UsuarioDisciplina usuarioDisciplina = usuarioDisciplinaService.criarUsuarioDisciplina(usuarioDisciplinaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDisciplina);
    }

    // Método para listar todos os registros de usuario-disciplina
    @GetMapping
    public ResponseEntity<List<UsuarioDisciplina>> listar() {
        List<UsuarioDisciplina> lista = usuarioDisciplinaService.listarUsuariosDisciplinas();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    // Método para atualizar um registro de usuario-disciplina existente
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDisciplina> atualizar(@PathVariable Long id, @RequestBody UsuarioDisciplinaDto usuarioDisciplinaDto) {
        UsuarioDisciplina usuarioDisciplina = usuarioDisciplinaService.editarUsuarioDisciplina(id, usuarioDisciplinaDto);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioDisciplina);
    }

    // Método para remover um registro de usuario-disciplina
    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable Long id) {
        usuarioDisciplinaService.excluirUsuarioDisciplina(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // Método para buscar um registro de usuario-disciplina pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDisciplina> buscarPorId(@PathVariable Long id) {
        UsuarioDisciplina usuarioDisciplina = usuarioDisciplinaService.buscarUsuarioDisciplinaPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioDisciplina);
    }
}
