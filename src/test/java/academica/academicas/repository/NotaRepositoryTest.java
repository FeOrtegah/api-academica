package academica.academicas.repository;

import academica.academicas.models.Nota;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class NotaRepositoryTest {

    @Autowired
    private NotaRepository notaRepository;

    @Test
    void findByEstudianteId_ShouldReturnNotas() {
        Nota n1 = new Nota(); n1.setValor(5.5); n1.setEstudianteId(100L); n1.setEvaluacionId(1L);
        Nota n2 = new Nota(); n2.setValor(6.0); n2.setEstudianteId(100L); n2.setEvaluacionId(2L);
        notaRepository.save(n1);
        notaRepository.save(n2);
        List<Nota> result = notaRepository.findByEstudianteId(100L);
        
        assertThat(result).hasSize(2);
        assertThat(result).allMatch(n -> n.getEstudianteId().equals(100L));
    }

    @Test
    void findByEvaluacionId_ShouldReturnNotas() {
        Nota n1 = new Nota(); n1.setValor(5.5); n1.setEstudianteId(100L); n1.setEvaluacionId(50L);
        Nota n2 = new Nota(); n2.setValor(6.5); n2.setEstudianteId(200L); n2.setEvaluacionId(50L);
        notaRepository.save(n1);
        notaRepository.save(n2);

        List<Nota> result = notaRepository.findByEvaluacionId(50L);

        assertThat(result).hasSize(2);
        assertThat(result).allMatch(n -> n.getEvaluacionId().equals(50L));
    }
}
