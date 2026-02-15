public class Cinema {

    private boolean[][] posti;
    private int righe;
    private int colonne;

    public Cinema(int righe, int colonne) {
        this.righe = righe;
        this.colonne = colonne;
        this.posti = new boolean[righe][colonne];
        for (int i = 0; i < righe; i++)
            for (int j = 0; j < colonne; j++)
                posti[i][j] = false;
    }

    public int getRighe() { return righe; }
    public int getColonne() { return colonne; }

    public boolean isPostoPrenotato(int riga, int colonna) {
        if (!isValidPosition(riga, colonna)) return false;
        return posti[riga][colonna];
    }

    public void mostraPosti() {
        System.out.println("\n=== Mappa della Sala Cinema ===");
        System.out.println("   Legenda: O = Libero | X = Prenotato\n");

        System.out.print("    ");
        for (int j = 0; j < colonne; j++) System.out.printf(" %2d", (j + 1));
        System.out.println();

        System.out.print("    ");
        for (int j = 0; j < colonne; j++) System.out.print("---");
        System.out.println();

        for (int i = 0; i < righe; i++) {
            System.out.printf(" %2d |", (i + 1));
            for (int j = 0; j < colonne; j++)
                System.out.print(posti[i][j] ? " X " : " O ");
            System.out.println();
        }
        System.out.println();
    }

    private boolean isValidPosition(int riga, int colonna) {
        return riga >= 0 && riga < righe && colonna >= 0 && colonna < colonne;
    }
}
