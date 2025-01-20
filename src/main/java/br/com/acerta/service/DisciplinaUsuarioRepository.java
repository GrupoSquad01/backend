package br.com.acerta.repository;

import br.com.acerta.model.DisciplinaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaUsuarioRepository extends JpaRepository<DisciplinaUsuario, Long> {
}
