package br.com.acerta.controller;

import br.com.acerta.dto.UsuarioDisciplinaDto;
import br.com.acerta.model.UsuarioDisciplina;
import br.com.acerta.service.UsuarioDisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios-disciplinas")
public class UsuarioDisciplinaController {

    @Autowired
    private UsuarioDisciplinaService usuarioDisciplinaService;

    @PostMapping
    public ResponseEntity<UsuarioDisciplina> cadastrar(@RequestBody UsuarioDisciplinaDto usuarioDisciplinaDto) {
        UsuarioDisciplina usuarioDisciplina = usuarioDisciplinaService.criarUsuarioDisciplina(usuarioDisciplinaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDisciplina);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDisciplina>> listar() {
        List<UsuarioDisciplina> lista = usuarioDisciplinaService.listarUsuariosDisciplinas();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDisciplina> atualizar(@PathVariable Long id, 
                                                       @RequestBody UsuarioDisciplinaDto usuarioDisciplinaDto) {
        UsuarioDisciplina usuarioDisciplina = usuarioDisciplinaService.editarUsuarioDisciplina(id, usuarioDisciplinaDto);
        if (usuarioDisciplina == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioDisciplina);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable Long id) {
        usuarioDisciplinaService.excluirUsuarioDisciplina(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDisciplina> buscarPorId(@PathVariable Long id) {
        UsuarioDisciplina usuarioDisciplina = usuarioDisciplinaService.buscarUsuarioDisciplinaPorId(id);
        if (usuarioDisciplina == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioDisciplina);
    }
}
