package academica.academicas.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NotaModelTest {

    @Test
    void testNotaLombokYValidaciones() {
        Nota nota = new Nota(1L, 6.5, 10L, 5L, "Excelente desempeño");
        assertEquals(1L, nota.getId());
        assertEquals(6.5, nota.getValor());
        assertEquals("Excelente desempeño", nota.getComentario());
        assertTrue(nota.getValor() >= 1.0 && nota.getValor() <= 7.0);
    }
}