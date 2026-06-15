package academica.academicas.controller;

import academica.academicas.models.Asignatura;
import academica.academicas.services.AsignaturaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AsignaturaControllerTest {

    @Mock
    private AsignaturaService asignaturaService;

    @InjectMocks
    private AsignaturaController asignaturaController;

    @Test
    void listarAsignaturas_ShouldReturnList() {
        when(asignaturaService.listarAsignaturas()).thenReturn(Collections.singletonList(new Asignatura()));
        ResponseEntity<List<Asignatura>> response = asignaturaController.listarAsignaturas();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    @Test
    void obtenerAsignaturaPorId_WhenExists_ShouldReturnOk() {
        Asignatura asignatura = new Asignatura();
        when(asignaturaService.obtenerAsignaturaPorId(1L)).thenReturn(Optional.of(asignatura));
        ResponseEntity<Asignatura> response = asignaturaController.obtenerAsignaturaPorId(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void eliminarAsignatura_ShouldReturnNoContent() {
        doNothing().when(asignaturaService).eliminarAsignatura(1L);
        ResponseEntity<Void> response = asignaturaController.eliminarAsignatura(1L);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(asignaturaService, times(1)).eliminarAsignatura(1L);
    }
}