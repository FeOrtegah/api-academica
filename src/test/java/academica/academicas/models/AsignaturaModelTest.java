package academica.academicas.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AsignaturaModelTest {

    @Test
    void testAsignaturaLombok() {
        Asignatura asignatura = new Asignatura();
        asignatura.setId(1L);
        asignatura.setNombre("Matemáticas");
        asignatura.setCursoId(10L);
        asignatura.setProfesorId(5L);
        assertEquals(1L, asignatura.getId());
        assertEquals("Matemáticas", asignatura.getNombre());
        assertEquals(10L, asignatura.getCursoId());
        assertEquals(5L, asignatura.getProfesorId());
        Asignatura asignatura2 = new Asignatura(2L, "Física", 11L, 6L);
        assertNotNull(asignatura2);
        assertEquals("Física", asignatura2.getNombre());
    }
}