package academica.academicas.repository;

import academica.academicas.models.Curso;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CursoRepositoryTest {

    @Autowired
    private CursoRepository cursoRepository;

    @Test
    void testGuardarYBuscarCurso() {
        Curso curso = new Curso(null, "Cuarto Medio", 2026);
        Curso guardado = cursoRepository.save(curso);
        assertThat(guardado.getId()).isNotNull();
        assertThat(cursoRepository.findById(guardado.getId())).isPresent();
    }
}