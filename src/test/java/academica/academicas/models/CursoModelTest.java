package academica.academicas.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CursoModelTest {

    @Test
    void testCursoLombok() {
        Curso curso = new Curso();
        curso.setId(1L);
        curso.setNombre("Primero Medio");
        curso.setAnio(2026);
        assertEquals(1L, curso.getId());
        assertEquals("Primero Medio", curso.getNombre());
        assertEquals(2026, curso.getAnio());
        Curso cursoCompleto = new Curso(2L, "Segundo Medio", 2027);
        assertEquals(2L, cursoCompleto.getId());
        assertEquals("Segundo Medio", cursoCompleto.getNombre());
        assertEquals(2027, cursoCompleto.getAnio());
    }
}