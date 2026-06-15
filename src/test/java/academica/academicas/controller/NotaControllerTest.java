package academica.academicas.controller;

import academica.academicas.models.Nota;
import academica.academicas.services.NotaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NotaControllerTest {

    @Mock
    private NotaService notaService;

    @InjectMocks
    private NotaController notaController;

    @Test
    void crearNota_ShouldReturnOk() {
        Nota nota = new Nota();
        when(notaService.guardarNota(any(Nota.class))).thenReturn(nota);
        ResponseEntity<Nota> response = notaController.crearNota(nota);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(notaService, times(1)).guardarNota(any(Nota.class));
    }

    @Test
    void actualizarNota_ShouldReturnUpdatedNota() {
        Nota nota = new Nota();
        when(notaService.guardarNota(any(Nota.class))).thenReturn(nota);
        ResponseEntity<Nota> response = notaController.actualizarNota(1L, nota);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(notaService).guardarNota(argThat(n -> n.getId() == 1L));
    }

    @Test
    void listarNotasPorEstudiante_ShouldReturnList() {
        List<Nota> notas = Arrays.asList(new Nota(), new Nota());
        when(notaService.listarPorEstudianteId(10L)).thenReturn(notas);
        ResponseEntity<List<Nota>> response = notaController.listarNotasPorEstudiante(10L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }

    @Test
    void obtenerNotaPorId_WhenExists_ShouldReturnOk() {
        Nota nota = new Nota();
        when(notaService.obtenerNotaPorId(1L)).thenReturn(Optional.of(nota));
        ResponseEntity<Nota> response = notaController.obtenerNotaPorId(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void eliminarNota_ShouldReturnNoContent() {
        doNothing().when(notaService).eliminarNota(1L);
        ResponseEntity<Void> response = notaController.eliminarNota(1L);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(notaService, times(1)).eliminarNota(1L);
    }
}