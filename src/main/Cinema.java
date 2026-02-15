public class Cinema {

    private boolean[][] posti;
    private int righe;
    private int colonne;

    public Cinema(int righe, int colonne) {
        this.righe = righe;
        this.colonne = colonne;
        this.posti = new boolean[righe][colonne];
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                posti[i][j] = false;
            }
        }
    }

    public int getRighe() { return righe; }
    public int getColonne() { return colonne; }

    public boolean isPostoPrenotato(int riga, int colonna) {
        if (!isValidPosition(riga, colonna)) return false;
        return posti[riga][colonna];
    }

    private boolean isValidPosition(int riga, int colonna) {
        return riga >= 0 && riga < righe && colonna >= 0 && colonna < colonne;
    }
}
