package academica.academicas.repository;

import academica.academicas.models.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    List<Matricula> findByEstudianteId(Long estudianteId);

}
