package academica.academicas.controller;

import academica.academicas.models.Matricula;
import academica.academicas.services.MatriculaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MatriculaControllerTest {

    @Mock
    private MatriculaService matriculaService;

    @InjectMocks
    private MatriculaController matriculaController;

    @Test
    void listarMatriculas_ShouldReturnList() {
        List<Matricula> lista = Arrays.asList(new Matricula(), new Matricula());
        when(matriculaService.listarMatriculas()).thenReturn(lista);
        ResponseEntity<List<Matricula>> response = matriculaController.listarMatriculas();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }

    @Test
    void listarPorEstudiante_ShouldReturnList() {
        List<Matricula> lista = Arrays.asList(new Matricula());
        when(matriculaService.listarPorEstudianteId(50L)).thenReturn(lista);
        ResponseEntity<List<Matricula>> response = matriculaController.listarPorEstudiante(50L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void eliminarMatricula_ShouldReturnNoContent() {
        doNothing().when(matriculaService).eliminarMatricula(1L);
        ResponseEntity<Void> response = matriculaController.eliminarMatricula(1L);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(matriculaService, times(1)).eliminarMatricula(1L);
    }
}