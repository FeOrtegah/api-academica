package academica.academicas.controller;

import academica.academicas.models.Evaluacion;
import academica.academicas.services.EvaluacionService;
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
class EvaluacionControllerTest {

    @Mock
    private EvaluacionService evaluacionService;

    @InjectMocks
    private EvaluacionController evaluacionController;

    @Test
    void listarEvaluacionesPorAsignatura_ShouldReturnList() {
        List<Evaluacion> lista = Arrays.asList(new Evaluacion(), new Evaluacion());
        when(evaluacionService.listarPorAsignaturaId(1L)).thenReturn(lista);
        ResponseEntity<List<Evaluacion>> response = evaluacionController.listarEvaluacionesPorAsignatura(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }

    @Test
    void obtenerEvaluacionPorId_WhenExists_ShouldReturnOk() {
        Evaluacion evaluacion = new Evaluacion();
        when(evaluacionService.obtenerEvaluacionPorId(1L)).thenReturn(Optional.of(evaluacion));
        ResponseEntity<Evaluacion> response = evaluacionController.obtenerEvaluacionPorId(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void eliminarEvaluacion_ShouldReturnNoContent() {
        doNothing().when(evaluacionService).eliminarEvaluacion(1L);
        ResponseEntity<Void> response = evaluacionController.eliminarEvaluacion(1L);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(evaluacionService, times(1)).eliminarEvaluacion(1L);
    }
}