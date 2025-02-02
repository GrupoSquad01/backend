package br.com.acerta.controller;

import br.com.acerta.dto.UsuariosDto;
import br.com.acerta.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    private UsuariosService usuariosService;

    @PostMapping
    public ResponseEntity<UsuariosDto> cadastrar(@RequestBody UsuariosDto usuariosDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuariosService.criarUsuario(usuariosDto));
    }

    @GetMapping
    public ResponseEntity<List<UsuariosDto>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(usuariosService.listarUsuarios());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuariosDto> atualizar(@PathVariable Long id, @RequestBody UsuariosDto usuariosDto) {
        return ResponseEntity.status(HttpStatus.OK).body(usuariosService.editarUsuario(id, usuariosDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable Long id) {
        usuariosService.excluirUsuario(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuariosDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(usuariosService.buscarUsuarioPorId(id));
    }
}
