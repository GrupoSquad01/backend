package br.com.acerta.repository;

import br.com.acerta.model.Disciplina;
import br.com.acerta.model.UsuarioDisciplina;
import br.com.acerta.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioDisciplinaRepository extends JpaRepository<UsuarioDisciplina, Long> {

    @Query("select u from UsuarioDisciplina u where u.usuario = :usuario and u.disciplina = :disciplina")
    Optional<List<UsuarioDisciplina>> findByRelacao(@Param("usuario") Usuarios usuario, @Param("disciplina") Disciplina disciplina);


    List<UsuarioDisciplina> findByUsuario(Usuarios usuario);
}
