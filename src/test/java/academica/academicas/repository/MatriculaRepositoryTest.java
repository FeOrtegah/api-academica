package academica.academicas.repository;

import academica.academicas.models.Matricula;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MatriculaRepositoryTest {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Test
    void findByEstudianteId_ShouldReturnMatriculas() {
        matriculaRepository.save(new Matricula(null, 100L, 1L));
        matriculaRepository.save(new Matricula(null, 100L, 2L));
        matriculaRepository.save(new Matricula(null, 200L, 1L));

        List<Matricula> result = matriculaRepository.findByEstudianteId(100L);

        assertThat(result).hasSize(2);
        assertThat(result).allMatch(m -> m.getEstudianteId().equals(100L));
    }

    @Test
    void save_ShouldPersistMatricula() {
        Matricula matricula = matriculaRepository.save(new Matricula(null, 300L, 5L));
        assertThat(matricula.getId()).isNotNull();
        assertThat(matricula.getEstudianteId()).isEqualTo(300L);
    }
}
