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

    @Test @DisplayName("mostraPosti() non causa eccezioni")
    void testMostraPostiNoException() { assertDoesNotThrow(() -> cinema.mostraPosti()); }

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

    @Test @DisplayName("Prenotare un posto libero ritorna true")
    void testPrenotaPostoLibero() { assertTrue(cinema.prenotaPosto(0, 0)); }

    @Test @DisplayName("Il posto diventa prenotato dopo la prenotazione")
    void testPostoDiventaPrenotato() {
        cinema.prenotaPosto(2, 3);
        assertTrue(cinema.isPostoPrenotato(2, 3));
    }

    @Test @DisplayName("Prenotare un posto gia occupato ritorna false")
    void testPrenotaPostoOccupato() {
        cinema.prenotaPosto(1, 1);
        assertFalse(cinema.prenotaPosto(1, 1));
    }

    @Test @DisplayName("Prenotare con riga negativa ritorna false")
    void testPrenotaRigaNegativa() { assertFalse(cinema.prenotaPosto(-1, 0)); }

    @Test @DisplayName("Prenotare con colonna fuori limite ritorna false")
    void testPrenotaColonnaFuoriLimite() { assertFalse(cinema.prenotaPosto(0, 99)); }

    @Test @DisplayName("Prenotare con riga fuori limite ritorna false")
    void testPrenotaRigaFuoriLimite() { assertFalse(cinema.prenotaPosto(99, 0)); }

    @Test @DisplayName("Prenotare piu posti diversi funziona")
    void testPrenotaPiuPosti() {
        assertTrue(cinema.prenotaPosto(0, 0));
        assertTrue(cinema.prenotaPosto(1, 1));
        assertTrue(cinema.prenotaPosto(4, 5));
        assertTrue(cinema.isPostoPrenotato(0, 0));
        assertTrue(cinema.isPostoPrenotato(1, 1));
        assertTrue(cinema.isPostoPrenotato(4, 5));
        assertFalse(cinema.isPostoPrenotato(2, 2));
    }
}
