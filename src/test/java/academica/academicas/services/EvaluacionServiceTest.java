package academica.academicas.services;

import academica.academicas.models.Evaluacion;
import academica.academicas.repository.EvaluacionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EvaluacionServiceTest {

    @Mock
    private EvaluacionRepository evaluacionRepository;

    @InjectMocks
    private EvaluacionService evaluacionService;

    @Test
    void listarPorAsignaturaId_DeberiaRetornarLista() {
        Long asignaturaId = 10L;
        Evaluacion eval1 = new Evaluacion(1L, "Quiz", 0.2, LocalDate.now(), asignaturaId);
        Evaluacion eval2 = new Evaluacion(2L, "Parcial", 0.4, LocalDate.now(), asignaturaId);
        
        when(evaluacionRepository.findByAsignaturaId(asignaturaId))
            .thenReturn(Arrays.asList(eval1, eval2));
        List<Evaluacion> resultado = evaluacionService.listarPorAsignaturaId(asignaturaId);

        assertThat(resultado).hasSize(2);
        assertThat(resultado.get(0).getAsignaturaId()).isEqualTo(asignaturaId);
        verify(evaluacionRepository, times(1)).findByAsignaturaId(asignaturaId);
    }

    @Test
    void eliminarEvaluacion_DeberiaLlamarAlRepositorio() {
        evaluacionService.eliminarEvaluacion(5L);

        verify(evaluacionRepository, times(1)).deleteById(5L);
    }
}
