package br.com.acerta.repository;

import br.com.acerta.model.Usuarios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
	
	@Query("select u from Usuarios u where u.username = :username")
	Optional<Usuarios> findByUsername(@Param("username") String username);
	
	@Query("select u from Usuarios u where u.email = :email")
	Optional<Usuarios> findByEmail(@Param("email") String email);
	
}
