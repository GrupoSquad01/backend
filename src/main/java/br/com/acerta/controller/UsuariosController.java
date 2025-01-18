package br.com.acerta.controller;

import br.com.acerta.dto.UsuariosDto;
import br.com.acerta.model.Usuarios;
import br.com.acerta.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    private UsuariosService usuariosService;

    @PostMapping
    public ResponseEntity<Usuarios> cadastrar(@RequestBody UsuariosDto usuariosDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuariosService.criarUsuario(usuariosDto));
    }

    @GetMapping
    public ResponseEntity<List<Usuarios>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(usuariosService.listarUsuarios());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> atualizar(@PathVariable Long id, @RequestBody UsuariosDto usuariosDto) {
        return ResponseEntity.status(HttpStatus.OK).body(usuariosService.editarUsuario(id, usuariosDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable Long id) {
        usuariosService.excluirUsuario(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(usuariosService.buscarUsuarioPorId(id));
    }
}
