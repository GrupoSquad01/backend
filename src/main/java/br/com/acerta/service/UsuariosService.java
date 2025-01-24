package br.com.acerta.service;

import br.com.acerta.dto.UsuariosDto;
import br.com.acerta.model.Usuarios;
import br.com.acerta.repository.UsuariosRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	private void validaUsernameExistente(String username) {
		Optional<Usuarios> userFound = usuariosRepository.findByUsername(username);
		if(userFound.isPresent())
			throw new ServiceException("Já existe um usuário cadastrado com o username: " + username);
	}
	
	private void validaEmailExistente(String email) {
		Optional<Usuarios> userFound = usuariosRepository.findByEmail(email);
		if(userFound.isPresent())
			throw new ServiceException("Já existe um usuário cadastrado com o email: " + email);
	}
	
	public UsuariosDto criarUsuario(UsuariosDto usuariosDto) {
		validaUsernameExistente(usuariosDto.getUsername());
		validaEmailExistente(usuariosDto.getEmail());
		
		var usuario = new Usuarios();
		BeanUtils.copyProperties(usuariosDto, usuario);
		
		usuariosRepository.saveAndFlush(usuario);
		
		usuariosDto.setId(usuario.getId());

		return usuariosDto;
	}

	public List<UsuariosDto> listarUsuarios() {
		List<Usuarios> usuarios = usuariosRepository.findAll();
		List<UsuariosDto> dtos = new ArrayList<>();
		
		for (Usuarios usuario : usuarios) {
			UsuariosDto dto = new UsuariosDto();
			BeanUtils.copyProperties(usuario, dto);
			dtos.add(dto);
		}
		
		return dtos;
	}

	public UsuariosDto editarUsuario(Long id, UsuariosDto usuariosDto) {
		Optional<Usuarios> usuario = usuariosRepository.findById(id);

		if (usuario.isEmpty()) {
			throw new ServiceException("Usuário não encontrado");
		}

		Usuarios usuarioEditado = usuario.get();
		
		if(usuariosDto.getUsername() != null && !usuarioEditado.getUsername().equals(usuariosDto.getUsername())) {
			usuarioEditado.setUsername(usuariosDto.getUsername());
			validaUsernameExistente(usuarioEditado.getUsername());
		} else
			usuariosDto.setUsername(usuarioEditado.getUsername());
		
		if(usuariosDto.getSenha() != null)
			usuarioEditado.setSenha(usuariosDto.getSenha());
		else
			usuariosDto.setSenha(usuarioEditado.getSenha());
		
		if(usuariosDto.getEmail() != null && !usuarioEditado.getEmail().equals(usuariosDto.getEmail())) {
			usuarioEditado.setEmail(usuariosDto.getEmail());
			validaEmailExistente(usuarioEditado.getEmail());
		} else
			usuariosDto.setEmail(usuarioEditado.getEmail());
		
		if(usuariosDto.getNome() != null)
			usuarioEditado.setNome(usuariosDto.getNome());
		else
			usuariosDto.setNome(usuarioEditado.getNome());
		
		if(usuariosDto.getFoto() != null)
			usuarioEditado.setFoto(usuariosDto.getFoto());
		else
			usuariosDto.setFoto(usuarioEditado.getFoto());
		
		if(usuariosDto.getTelefone() != null)
			usuarioEditado.setTelefone(usuariosDto.getTelefone());
		else
			usuariosDto.setTelefone(usuarioEditado.getTelefone());

		if (usuariosDto.getDataNascimento() != null)
			usuarioEditado.setDataNascimento(usuariosDto.getDataNascimento());
		else
			usuariosDto.setDataNascimento(usuarioEditado.getDataNascimento());

		if (usuariosDto.getGenero() != null)
			usuarioEditado.setGenero(usuariosDto.getGenero());
		else
			usuariosDto.setGenero(usuarioEditado.getGenero());

		if (usuariosDto.getRaca() != null)
			usuarioEditado.setRaca(usuariosDto.getRaca());
		else
			usuariosDto.setRaca(usuarioEditado.getRaca());

		if (usuariosDto.getNacionalidade() != null)
			usuarioEditado.setNacionalidade(usuariosDto.getNacionalidade());
		else
			usuariosDto.setNacionalidade(usuarioEditado.getNacionalidade());

		if (usuariosDto.getDataUltimaResposta() != null)
			usuarioEditado.setDataUltimaResposta(usuariosDto.getDataUltimaResposta());
		else
			usuariosDto.setDataUltimaResposta(usuarioEditado.getDataUltimaResposta());

		if (usuariosDto.getSequenciaDias() != 0)
			usuarioEditado.setSequenciaDias(usuariosDto.getSequenciaDias());
		else
			usuariosDto.setSequenciaDias(usuarioEditado.getSequenciaDias());

		usuariosRepository.saveAndFlush(usuarioEditado);
		
		BeanUtils.copyProperties(usuarioEditado, usuariosDto);
		
		return usuariosDto;
	}

	public void excluirUsuario(Long id) {
		Optional<Usuarios> usuario = usuariosRepository.findById(id);
		if (usuario.isEmpty()) {
			throw new ServiceException("Usuário não encontrado");
		}

		usuariosRepository.deleteById(id);
	}

	public UsuariosDto buscarUsuarioPorId(Long id) {
		Optional<Usuarios> usuario = usuariosRepository.findById(id);
		if (usuario.isEmpty()) {
			throw new ServiceException("Usuário não encontrado");
		}
		
		UsuariosDto dto = new UsuariosDto();
		BeanUtils.copyProperties(usuario.get(), dto);
		
		return dto;
	}
}
