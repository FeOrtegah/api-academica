package academica.academicas.services;

import academica.academicas.models.Matricula;
import academica.academicas.repository.MatriculaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MatriculaServiceTest {

    @Mock
    private MatriculaRepository matriculaRepository;

    @InjectMocks
    private MatriculaService matriculaService;

    @Test
    void listarPorEstudianteId_DeberiaRetornarLista() {
        Long estId = 500L;
        Matricula m1 = new Matricula(1L, estId, 1L);
        Matricula m2 = new Matricula(2L, estId, 2L);
        when(matriculaRepository.findByEstudianteId(estId)).thenReturn(Arrays.asList(m1, m2));

        List<Matricula> result = matriculaService.listarPorEstudianteId(estId);

        assertThat(result).hasSize(2);
        assertThat(result.get(0).getEstudianteId()).isEqualTo(estId);
        verify(matriculaRepository, times(1)).findByEstudianteId(estId);
    }

    @Test
    void guardarMatricula_DeberiaLlamarAlRepositorio() {
        Matricula m = new Matricula(null, 100L, 1L);
        when(matriculaRepository.save(m)).thenReturn(m);

        Matricula saved = matriculaService.guardarMatricula(m);

        assertThat(saved).isNotNull();
        verify(matriculaRepository, times(1)).save(m);
    }
}
