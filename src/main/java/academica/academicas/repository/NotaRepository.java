package academica.academicas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import academica.academicas.models.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {

    List<Nota> findByEstudianteId(Long estudianteId);

    List<Nota> findByEvaluacionId(Long evaluacionId);
}