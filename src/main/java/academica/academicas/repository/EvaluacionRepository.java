package academica.academicas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import academica.academicas.models.Evaluacion;

public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {

    List<Evaluacion> findByAsignaturaId(Long asignaturaId);

}
