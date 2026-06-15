package academica.academicas.services;

import academica.academicas.models.Nota;
import academica.academicas.repository.NotaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NotaServiceTest {

    @Mock
    private NotaRepository notaRepository;

    @InjectMocks
    private NotaService notaService;

    @Test
    void guardarNota_ConValorValido_DeberiaGuardar() {
        // Nota(id, valor, estudianteId, evaluacionId, comentario)
        Nota nota = new Nota(null, 5.5, 100L, 50L, null);
        when(notaRepository.save(nota)).thenReturn(nota);

        Nota resultado = notaService.guardarNota(nota);

        assertThat(resultado.getValor()).isEqualTo(5.5);
        verify(notaRepository, times(1)).save(nota);
    }

    @Test
    void guardarNota_ConValorInvalido_DeberiaLanzarExcepcion() {
        Nota notaMala = new Nota(null, 8.0, 100L, 50L, null);

        assertThatThrownBy(() -> notaService.guardarNota(notaMala))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("La nota debe estar entre 1.0 y 7.0");

        verify(notaRepository, never()).save(any());
    }

    @Test
    void guardarNota_ConValorNulo_DeberiaLanzarExcepcion() {
        Nota notaNula = new Nota(null, null, 100L, 50L, null);

        assertThatThrownBy(() -> notaService.guardarNota(notaNula))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("La nota no puede ser nula");

        verify(notaRepository, never()).save(any());
    }

    @Test
    void eliminarNota_DeberiaLlamarAlRepositorio() {
        notaService.eliminarNota(1L);
        verify(notaRepository, times(1)).deleteById(1L);
    }
}
