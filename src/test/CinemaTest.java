import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CinemaTest {

    private Cinema cinema;

    @BeforeEach
    void setUp() { cinema = new Cinema(5, 6); }

    @Test @DisplayName("Il costruttore crea una sala con le dimensioni corrette")
    void testCostruttoreDimensioni() {
        Cinema c = new Cinema(3, 4);
        assertEquals(3, c.getRighe());
        assertEquals(4, c.getColonne());
    }

    @Test @DisplayName("Tutti i posti sono liberi dopo la creazione")
    void testTuttiPostiLiberiInizialmente() {
        for (int i = 0; i < cinema.getRighe(); i++)
            for (int j = 0; j < cinema.getColonne(); j++)
                assertFalse(cinema.isPostoPrenotato(i, j));
    }

    @Test @DisplayName("Il costruttore con dimensioni diverse funziona")
    void testCostruttoreDimensioniDiverse() {
        Cinema piccolo = new Cinema(2, 3);
        assertEquals(2, piccolo.getRighe());
        assertEquals(3, piccolo.getColonne());
    }

    @Test @DisplayName("mostraPosti() non causa eccezioni")
    void testMostraPostiNoException() {
        assertDoesNotThrow(() -> cinema.mostraPosti());
    }

    @Test @DisplayName("mostraPosti() mostra O per posti liberi")
    void testMostraPostiOutputLiberi() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        cinema.mostraPosti();
        System.setOut(originalOut);
        String output = outContent.toString();
        assertTrue(output.contains("O"));
        assertFalse(output.contains("X"));
    }
}
