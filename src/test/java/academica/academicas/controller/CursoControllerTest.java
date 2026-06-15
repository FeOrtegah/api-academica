package academica.academicas.controller;

import academica.academicas.models.Curso;
import academica.academicas.services.CursoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CursoControllerTest {

    @Mock
    private CursoService cursoService;

    @InjectMocks
    private CursoController cursoController;

    @Test
    void crearCurso_ShouldReturnOk() {
        Curso curso = new Curso();
        when(cursoService.guardarCurso(any(Curso.class))).thenReturn(curso);
        ResponseEntity<Curso> response = cursoController.crearCurso(curso);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(cursoService).guardarCurso(any(Curso.class));
    }

    @Test
    void actualizarCurso_WhenNotFound_ShouldReturnNotFound() {
        Curso curso = new Curso();
        when(cursoService.actualizarCurso(eq(99L), any(Curso.class)))
            .thenThrow(new IllegalArgumentException());
        ResponseEntity<Curso> response = cursoController.actualizarCurso(99L, curso);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void eliminarCurso_WhenExists_ShouldReturnNoContent() {
        doNothing().when(cursoService).eliminarCurso(1L);
        ResponseEntity<Void> response = cursoController.eliminarCurso(1L);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}