package academica.academicas.services;

import academica.academicas.models.Curso;
import academica.academicas.repository.CursoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CursoServiceTest {

    @Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private CursoService cursoService;

    @Test
    void actualizarCurso_CuandoExiste_DeberiaActualizar() {
        Long id = 1L;
        Curso existente = new Curso(id, "Primero Medio", 2025);
        Curso nuevosDatos = new Curso(id, "Segundo Medio", 2026);
        
        when(cursoRepository.findById(id)).thenReturn(Optional.of(existente));
        when(cursoRepository.save(any(Curso.class))).thenReturn(existente);

        Curso resultado = cursoService.actualizarCurso(id, nuevosDatos);

        assertThat(resultado.getNombre()).isEqualTo("Segundo Medio");
        assertThat(resultado.getAnio()).isEqualTo(2026);
        verify(cursoRepository, times(1)).save(existente);
    }

    @Test
    void eliminarCurso_DeberiaLlamarAlRepositorio() {
        cursoService.eliminarCurso(1L);

        verify(cursoRepository, times(1)).deleteById(1L);
    }
}
