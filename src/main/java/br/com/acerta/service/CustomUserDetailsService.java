package br.com.acerta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.acerta.model.CustomUserDetails;
import br.com.acerta.model.Usuarios;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsuariosService usuariosService;
	
	@Override
	 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuarios usuario = usuariosService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
		
		return new CustomUserDetails(usuario);
	}

}
