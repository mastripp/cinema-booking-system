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
        assertTrue(outContent.toString().contains("O"));
        assertFalse(outContent.toString().contains("X"));
    }

    @Test @DisplayName("Prenotare un posto libero ritorna true")
    void testPrenotaPostoLibero() { assertTrue(cinema.prenotaPosto(0, 0)); }

    @Test @DisplayName("Il posto diventa prenotato")
    void testPostoDiventaPrenotato() {
        cinema.prenotaPosto(2, 3);
        assertTrue(cinema.isPostoPrenotato(2, 3));
    }

    @Test @DisplayName("Prenotare posto gia occupato ritorna false")
    void testPrenotaPostoOccupato() {
        cinema.prenotaPosto(1, 1);
        assertFalse(cinema.prenotaPosto(1, 1));
    }

    @Test @DisplayName("Prenotare con indici non validi ritorna false")
    void testPrenotaIndiciNonValidi() {
        assertFalse(cinema.prenotaPosto(-1, 0));
        assertFalse(cinema.prenotaPosto(0, 99));
        assertFalse(cinema.prenotaPosto(99, 0));
    }

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

    @Test @DisplayName("Annullare un posto prenotato ritorna true")
    void testAnnullaPostoPrenotato() {
        cinema.prenotaPosto(0, 0);
        assertTrue(cinema.annullaPrenotazione(0, 0));
    }

    @Test @DisplayName("Il posto diventa libero dopo annullamento")
    void testPostoDiventaLiberoDopoAnnullamento() {
        cinema.prenotaPosto(2, 3);
        cinema.annullaPrenotazione(2, 3);
        assertFalse(cinema.isPostoPrenotato(2, 3));
    }

    @Test @DisplayName("Annullare un posto gia libero ritorna false")
    void testAnnullaPostoGiaLibero() { assertFalse(cinema.annullaPrenotazione(0, 0)); }

    @Test @DisplayName("Annullare con indici non validi ritorna false")
    void testAnnullaIndiciNonValidi() {
        assertFalse(cinema.annullaPrenotazione(-1, 0));
        assertFalse(cinema.annullaPrenotazione(0, 99));
        assertFalse(cinema.annullaPrenotazione(99, 0));
    }

    @Test @DisplayName("Ciclo completo: prenota -> annulla -> ri-prenota")
    void testCicloPrenotaAnnulla() {
        assertTrue(cinema.prenotaPosto(3, 2));
        assertTrue(cinema.isPostoPrenotato(3, 2));
        assertTrue(cinema.annullaPrenotazione(3, 2));
        assertFalse(cinema.isPostoPrenotato(3, 2));
        assertTrue(cinema.prenotaPosto(3, 2));
        assertTrue(cinema.isPostoPrenotato(3, 2));
    }
}
