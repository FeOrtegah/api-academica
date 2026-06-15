package academica.academicas.repository;

import academica.academicas.models.Asignatura;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@DataJpaTest
class AsignaturaRepositoryTest {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Test
    void findByCursoId_ShouldReturnAsignaturas() {
        Asignatura asig1 = new Asignatura(null, "Matemáticas", 1L, 10L);
        asignaturaRepository.save(asig1);
        List<Asignatura> result = asignaturaRepository.findByCursoId(1L);
        assertThat(result).isNotEmpty();
        assertThat(result.get(0).getNombre()).isEqualTo("Matemáticas");
    }
}