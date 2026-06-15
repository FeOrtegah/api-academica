package academica.academicas.services;

import academica.academicas.models.Asignatura;
import academica.academicas.repository.AsignaturaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AsignaturaServiceTest {

    @Mock
    private AsignaturaRepository asignaturaRepository;

    @InjectMocks
    private AsignaturaService asignaturaService;

    @Test
    void obtenerAsignaturaPorId_DeberiaRetornarAsignatura() {
        Asignatura asig = new Asignatura(1L, "Matemáticas", 1L, 10L);
        when(asignaturaRepository.findById(1L)).thenReturn(Optional.of(asig));

        Optional<Asignatura> resultado = asignaturaService.obtenerAsignaturaPorId(1L);

        assertThat(resultado).isPresent();
        assertThat(resultado.get().getNombre()).isEqualTo("Matemáticas");
        verify(asignaturaRepository, times(1)).findById(1L);
    }
}
