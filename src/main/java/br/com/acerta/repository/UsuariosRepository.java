package br.com.acerta.repository;

import br.com.acerta.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
}
