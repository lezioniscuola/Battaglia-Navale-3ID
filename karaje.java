public class karaje {
    public static void posizionamento(int[][] matriceComputer, int dimensioneBarca) {
        int righe = matriceComputer.length;
        int colonne = matriceComputer[0].length;
        int x = (int) (Math.random() * righe);
        int y = (int) (Math.random() * colonne);
        int direzione = (int) (Math.random() * 2);
        boolean posizionato = false;
        if (dimensioneBarca >= 4 || dimensioneBarca < 1) {
            throw new IllegalArgumentException("Dimensione barca non valida"); // In caso in cui la dimensione della barca non è valida si lancia un errore
        }
        if (dimensioneBarca > righe || dimensioneBarca > colonne) {
            throw new IllegalArgumentException("La barca non può stare nel campo di battaglia"); // In caso in cui la barca non può stare nel campo si lancia un errore
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
    }
}