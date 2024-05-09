public class karaje {
    public static void main(String[] args) {
        int[][] matriceComputer = new int[1][1];
        posizionamento(matriceComputer, 3);
    }
    public static void posizionamento(int[][] matriceComputer, int dimensioneBarca) {
        int righe = matriceComputer.length;
        int colonne = matriceComputer[0].length;
        int x = (int) (Math.random() * righe);
        int y = (int) (Math.random() * colonne);
        int direzione = (int) (Math.random() * 2);
        boolean posizionato = false;
        if (dimensioneBarca >= 4 || dimensioneBarca < 1) {
            throw new IllegalArgumentException("Dimensione barca non valida");
        }
        if (dimensioneBarca > righe || dimensioneBarca > colonne) {
            throw new IllegalArgumentException("La barca non può stare nel campo di battaglia");
        }
        
        while (!posizionato) {
            if (direzione == 0) {
                if (x + dimensioneBarca < righe) {
                    for (int i = 0; i < dimensioneBarca; i++) {
                        if (matriceComputer[x + i][y] == 0) {
                            posizionato = true;
                        } else {
                            posizionato = false;
                            break;
                        }
                    }
                    if (posizionato) {
                        for (int i = 0; i < dimensioneBarca; i++) {
                            matriceComputer[x + i][y] = dimensioneBarca;
                        }
                    }
                }
            } else {
                if (y + dimensioneBarca < colonne) {
                    for (int i = 0; i < dimensioneBarca; i++) {
                        if (matriceComputer[x][y + i] == 0) {
                            posizionato = true;
                        } else {
                            posizionato = false;
                            break;
                        }
                    }
                    if (posizionato) {
                        for (int i = 0; i < dimensioneBarca; i++) {
                            matriceComputer[x][y + i] = dimensioneBarca;
                        }
                    }
                }
            }
            if (!posizionato) {
                x = (int) (Math.random() * 10);
                y = (int) (Math.random() * 10);
                direzione = (int) (Math.random() * 2);
            }
        }
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                System.out.print(matriceComputer[i][j] + " ");
            }
            System.out.println();
        }
    }
}