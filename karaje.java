public class karaje {
    public static void posizionamento(int[][] matriceComputer, int dimensioneBarca) {
        int righe = matriceComputer.length; // Ottengo il numero di righe della matrice
        int colonne = matriceComputer[0].length; // Ottengo il numero di colonne della matrice
        int x = (int) (Math.random() * righe); // Genero un numero casuale per la coordinata x
        int y = (int) (Math.random() * colonne); // Genero un numero casuale per la coordinata y
        int direzione = (int) (Math.random() * 2); // Genero un numero casuale per la direzione
        boolean posizionato = false; // Variabile booleana per controllare se la barca è stata posizionata
        if (dimensioneBarca >= 4 || dimensioneBarca < 1) {
            throw new IllegalArgumentException("Dimensione barca non valida"); // In caso in cui la dimensione della barca non è valida si lancia un errore
        }
        if (dimensioneBarca > righe || dimensioneBarca > colonne) {
            throw new IllegalArgumentException("La barca non può stare nel campo di battaglia"); // In caso in cui la barca non può stare nel campo si lancia un errore
        }
        while (!posizionato) { // Ciclo finché la barca non è posizionata
            if (direzione == 0) { // Se la direzione è 0
                if (x + dimensioneBarca < righe) { // Se la barca può stare nella matrice
                    for (int i = 0; i < dimensioneBarca; i++) { // Ciclo per controllare se la barca può stare nella matrice
                        if (matriceComputer[x + i][y] == 0) { // Se la cella è vuota
                            posizionato = true; // La barca può stare
                        } else { // Se la cella non è vuota
                            posizionato = false; // La barca non può stare
                            break; // Esco dal ciclo
                        }
                    }
                    if (posizionato) { // Se la barca può stare
                        for (int i = 0; i < dimensioneBarca; i++) { // Ciclo per posizionare la barca
                            matriceComputer[x + i][y] = dimensioneBarca; // Posiziono la barca
                        }
                    }
                }
            } else { // Se la direzione è 1
                if (y + dimensioneBarca < colonne) { // Se la barca può stare nella matrice
                    for (int i = 0; i < dimensioneBarca; i++) { // Ciclo per controllare se la barca può stare nella matrice
                        if (matriceComputer[x][y + i] == 0) { // Se la cella è vuota
                            posizionato = true; // La barca può stare
                        } else {
                            posizionato = false; // La barca non può stare
                            break;
                        }
                    }
                    if (posizionato) { // Se la barca può stare
                        for (int i = 0; i < dimensioneBarca; i++) { // Ciclo per posizionare la barca
                            matriceComputer[x][y + i] = dimensioneBarca; // Posiziono la barca
                        }
                    }
                }
            }
            if (!posizionato) { // Se la barca non è posizionata
                x = (int) (Math.random() * righe); // Genero un nuovo numero casuale per la coordinata x 
                y = (int) (Math.random() * colonne); // Genero un nuovo numero casuale per la coordinata y
                direzione = (int) (Math.random() * 2); // Genero un nuovo numero casuale per la direzione
           }
        }
    }
}