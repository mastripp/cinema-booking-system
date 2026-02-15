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
        System.out.println("   Posti prenotati: " + getPostiPrenotati() + "/" + (righe * colonne));
        System.out.printf("   Occupazione: %.1f%%\n", getPercentualeOccupazione());
        System.out.println();
    }

    public boolean prenotaPosto(int riga, int colonna) {
        if (!isValidPosition(riga, colonna)) return false;
        if (posti[riga][colonna]) return false;
        posti[riga][colonna] = true;
        return true;
    }

    public boolean annullaPrenotazione(int riga, int colonna) {
        if (!isValidPosition(riga, colonna)) return false;
        if (!posti[riga][colonna]) return false;
        posti[riga][colonna] = false;
        return true;
    }

    public int getPostiPrenotati() {
        int contatore = 0;
        for (int i = 0; i < righe; i++)
            for (int j = 0; j < colonne; j++)
                if (posti[i][j]) contatore++;
        return contatore;
    }

    public double getPercentualeOccupazione() {
        int totale = righe * colonne;
        if (totale == 0) return 0.0;
        return (double) getPostiPrenotati() / totale * 100.0;
    }

    private boolean isValidPosition(int riga, int colonna) {
        return riga >= 0 && riga < righe && colonna >= 0 && colonna < colonne;
    }
}
