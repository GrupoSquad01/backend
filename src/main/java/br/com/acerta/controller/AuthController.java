package br.com.acerta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.acerta.dto.UsuariosDto;
import br.com.acerta.service.CustomUserDetailsService;
import br.com.acerta.service.UsuariosService;
import br.com.acerta.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
    private AuthenticationManager authenticationManager;

	@Autowired
    private JwtUtil jwtUtil;
	
	@Autowired
	private UsuariosService usuariosService;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@PostMapping(value = "/cadastrar")
    public ResponseEntity<UsuariosDto> cadastrar(@RequestBody UsuariosDto usuariosDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuariosService.criarUsuario(usuariosDto));
    }
	
	@PostMapping("/login")
    public String login(@RequestBody UsuariosDto usuario){
        try {
        	Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getSenha()));
                    return jwtUtil.generateToken(authentication.getName());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Autenticação falhou", e);
		}
	}
	
    @PostMapping("/refresh-token")
    public ResponseEntity<String> refreshToken(@RequestBody String refreshToken) {
        try {
            String username = jwtUtil.getUsernameFromToken(refreshToken);

            if(jwtUtil.isTokenValid(refreshToken, customUserDetailsService.loadUserByUsername(username))) {
                String newAccessToken = jwtUtil.generateToken(username);
                return ResponseEntity.ok(newAccessToken);
            } else {
                return ResponseEntity.status(401).body("Refresh Token Inválido!");
            }
        } catch(Exception error){
            return ResponseEntity.status(401).body("Erro ao processar o Refresh Token!");
        }
    }

}
