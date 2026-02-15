import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    private static final int RIGHE = 5;
    private static final int COLONNE = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cinema cinema = new Cinema(RIGHE, COLONNE);

        System.out.println("========================================");
        System.out.println("   SISTEMA DI PRENOTAZIONE CINEMA");
        System.out.println("   Sala: " + RIGHE + " righe x " + COLONNE + " posti");
        System.out.println("========================================");

        boolean continua = true;

        while (continua) {
            System.out.println("\n=== MENU PRINCIPALE ===");
            System.out.println("1. Mostra posti");
            System.out.println("2. Prenota posto");
            System.out.println("3. Annulla prenotazione");
            System.out.println("4. Esci");
            System.out.print("Scelta: ");

            int scelta;
            try {
                scelta = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Errore: inserisci un numero valido!");
                scanner.nextLine();
                continue;
            }

            switch (scelta) {
                case 1: cinema.mostraPosti(); break;
                case 2:
                    cinema.mostraPosti();
                    System.out.println("--- Prenotazione Posto ---");
                    int rp = leggiIntero(scanner, "Inserisci riga (1-" + RIGHE + "): ");
                    if (rp == -1) continue;
                    int cp = leggiIntero(scanner, "Inserisci colonna (1-" + COLONNE + "): ");
                    if (cp == -1) continue;
                    if (cinema.prenotaPosto(rp - 1, cp - 1)) {
                        System.out.println("Posto [" + rp + ", " + cp + "] prenotato con successo!");
                    } else {
                        System.out.println("Impossibile prenotare il posto [" + rp + ", " + cp + "].");
                        System.out.println("Il posto potrebbe essere gia occupato o le coordinate non valide.");
                    }
                    break;
                case 3:
                    cinema.mostraPosti();
                    System.out.println("--- Annullamento Prenotazione ---");
                    int ra = leggiIntero(scanner, "Inserisci riga (1-" + RIGHE + "): ");
                    if (ra == -1) continue;
                    int ca = leggiIntero(scanner, "Inserisci colonna (1-" + COLONNE + "): ");
                    if (ca == -1) continue;
                    if (cinema.annullaPrenotazione(ra - 1, ca - 1)) {
                        System.out.println("Prenotazione [" + ra + ", " + ca + "] annullata con successo!");
                    } else {
                        System.out.println("Impossibile annullare il posto [" + ra + ", " + ca + "].");
                        System.out.println("Il posto potrebbe essere gia libero o le coordinate non valide.");
                    }
                    break;
                case 4:
                    continua = false;
                    System.out.println("\nGrazie per aver usato il sistema di prenotazione!");
                    System.out.println("Buona visione!");
                    break;
                default:
                    System.out.println("Scelta non valida. Inserisci un numero da 1 a 4.");
                    break;
            }
        }
        scanner.close();
    }

    private static int leggiIntero(Scanner scanner, String prompt) {
        System.out.print(prompt);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Errore: inserisci un numero valido!");
            scanner.nextLine();
            return -1;
        }
    }
}
