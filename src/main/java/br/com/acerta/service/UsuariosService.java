package br.com.acerta.service;

import br.com.acerta.dto.UsuariosDto;
import br.com.acerta.model.Usuarios;
import br.com.acerta.repository.UsuariosRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {
   @Autowired
    UsuariosRepository usuariosRepository;

    public Usuarios criarUsuario(UsuariosDto usuariosDto) {
        var usuario = new Usuarios();
        BeanUtils.copyProperties(usuariosDto, usuario);
        return usuariosRepository.save(usuario);
    }

    public List<Usuarios> listarUsuarios() {
        return usuariosRepository.findAll();
    }

    public Usuarios editarUsuario(Long id, UsuariosDto usuariosDto) {
        Optional<Usuarios> usuario = usuariosRepository.findById(id);

        if (usuario.isEmpty()) {
            return null;
        }

        BeanUtils.copyProperties(usuariosDto, usuario.get());
        return usuariosRepository.save(usuario.get());
    }

    public void excluirUsuario(Long id) {
        Optional<Usuarios> usuario = usuariosRepository.findById(id);
        if (usuario.isEmpty()) {
            return;
        }

        usuariosRepository.deleteById(id);
    }

    public Usuarios buscarUsuarioPorId(Long id) {
        Optional<Usuarios> usuario = usuariosRepository.findById(id);
        if (usuario.isEmpty()) {
            return null;
        }
        return usuario.get();
    }
}
