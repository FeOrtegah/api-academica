package academica.academicas.models;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class EvaluacionModelTest {

    @Test
    void testEvaluacionLombok() {
        LocalDate fechaActual = LocalDate.now();
        Evaluacion eval = new Evaluacion();
        eval.setId(1L);
        eval.setNombre("Examen Final");
        eval.setPonderacion(0.4);
        eval.setFecha(fechaActual);
        eval.setAsignaturaId(100L);
        assertEquals(1L, eval.getId());
        assertEquals("Examen Final", eval.getNombre());
        assertEquals(0.4, eval.getPonderacion());
        assertEquals(fechaActual, eval.getFecha());
        assertEquals(100L, eval.getAsignaturaId());
        Evaluacion evalCompleta = new Evaluacion(2L, "Quiz 1", 0.1, fechaActual, 101L);       
        assertNotNull(evalCompleta);
        assertEquals(0.1, evalCompleta.getPonderacion());
    }
}