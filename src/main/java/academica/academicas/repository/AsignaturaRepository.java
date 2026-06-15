package academica.academicas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import academica.academicas.models.Asignatura;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {

    List<Asignatura> findByCursoId(Long cursoId);
}
