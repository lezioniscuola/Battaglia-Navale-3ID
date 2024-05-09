public static void colpoPng (int [][] m, int livello) { 
    //matrice = colpi livello = numeri di colpi inseriti
    
    int riga,colonna;
    boolean isGiaPresente=false;
    Random rand = new Random();
    do {
        // Generazione di due numeri casuali compresi tra 0 e n
        riga = rand.nextInt(m[0][0]); //m[0][0]=grandezza campo
        colonna = rand.nextInt(m[0][0]);
        for (int i=1;i<=livello;i++){
            //Controllo matrice colpi
            if (m[i][0] == riga && m[i][1] == colonna){
                isGiaPresente=true;
                break;
            }
        }
    }while (isGiaPresente);
    m[livello][0]=riga;
    m[livello][1]=colonna;
}


//funziona un bordello
