package academica.academicas.repository;

import academica.academicas.models.Evaluacion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EvaluacionRepositoryTest {

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    @Test
    void findByAsignaturaId_ShouldReturnEvaluaciones() {
        evaluacionRepository.save(new Evaluacion(null, "Quiz 1", 0.2, LocalDate.now(), 10L));
        evaluacionRepository.save(new Evaluacion(null, "Examen Parcial", 0.4, LocalDate.now(), 10L));
        List<Evaluacion> result = evaluacionRepository.findByAsignaturaId(10L);
        assertThat(result).hasSize(2);
        assertThat(result.stream().allMatch(e -> e.getAsignaturaId().equals(10L))).isTrue();
    }
}
