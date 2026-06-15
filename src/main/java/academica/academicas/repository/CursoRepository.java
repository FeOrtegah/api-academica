package academica.academicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import academica.academicas.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
