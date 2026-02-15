import java.util.Scanner;

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

            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1: cinema.mostraPosti(); break;
                case 2:
                    cinema.mostraPosti();
                    System.out.print("Riga (1-" + RIGHE + "): ");
                    int rp = scanner.nextInt();
                    System.out.print("Colonna (1-" + COLONNE + "): ");
                    int cp = scanner.nextInt();
                    System.out.println(cinema.prenotaPosto(rp-1, cp-1) ?
                        "Posto ["+rp+","+cp+"] prenotato!" : "Errore prenotazione!");
                    break;
                case 3:
                    cinema.mostraPosti();
                    System.out.print("Riga (1-" + RIGHE + "): ");
                    int ra = scanner.nextInt();
                    System.out.print("Colonna (1-" + COLONNE + "): ");
                    int ca = scanner.nextInt();
                    System.out.println(cinema.annullaPrenotazione(ra-1, ca-1) ?
                        "Prenotazione ["+ra+","+ca+"] annullata!" : "Errore annullamento!");
                    break;
                case 4: continua = false; System.out.println("Buona visione!"); break;
                default: System.out.println("Scelta non valida!"); break;
            }
        }
        scanner.close();
    }
}
