package academica.academicas.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatriculaModelTest {

    @Test
    void testMatriculaLombok() {
        Matricula matricula = new Matricula();
        matricula.setId(1L);
        matricula.setEstudianteId(500L);
        matricula.setAsignaturaId(200L);
        assertEquals(1L, matricula.getId());
        assertEquals(500L, matricula.getEstudianteId());
        assertEquals(200L, matricula.getAsignaturaId());
        Matricula matriculaCompleta = new Matricula(2L, 501L, 201L);       
        assertNotNull(matriculaCompleta);
        assertEquals(2L, matriculaCompleta.getId());
        assertEquals(501L, matriculaCompleta.getEstudianteId());
    }
}