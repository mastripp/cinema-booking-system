import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class CinemaTest {

    private Cinema cinema;

    @BeforeEach
    void setUp() {
        cinema = new Cinema(5, 6);
    }

    @Test
    @DisplayName("Il costruttore crea una sala con le dimensioni corrette")
    void testCostruttoreDimensioni() {
        Cinema c = new Cinema(3, 4);
        assertEquals(3, c.getRighe(), "Il numero di righe deve essere 3");
        assertEquals(4, c.getColonne(), "Il numero di colonne deve essere 4");
    }

    @Test
    @DisplayName("Tutti i posti sono liberi dopo la creazione")
    void testTuttiPostiLiberiInizialmente() {
        for (int i = 0; i < cinema.getRighe(); i++) {
            for (int j = 0; j < cinema.getColonne(); j++) {
                assertFalse(cinema.isPostoPrenotato(i, j),
                    "Il posto [" + i + "][" + j + "] dovrebbe essere libero");
            }
        }
    }

    @Test
    @DisplayName("Il costruttore con dimensioni diverse funziona")
    void testCostruttoreDimensioniDiverse() {
        Cinema piccolo = new Cinema(2, 3);
        assertEquals(2, piccolo.getRighe());
        assertEquals(3, piccolo.getColonne());

        Cinema grande = new Cinema(10, 15);
        assertEquals(10, grande.getRighe());
        assertEquals(15, grande.getColonne());
    }
}
