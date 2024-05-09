package navi;
import java.util.Random;

public class funzBattagliaNavale2 {

    public static int [][] campoDiBattaglia(int lunghezza){ //Panseri
        int [][] nome = new int [lunghezza][lunghezza];
        return nome;
    }
    public static void posizionamentoTotale(int [][] m,int [] navi){ //D'Ortenzio
        //La funzione si baserà sul gestire le navi da inserire che verranno inserite dalla funzione: posizionamento() di Karaje
        //N° navi in base al dichiarato nel Main
        int inserite,dim=0; //Navi totali da inserire (Per comodità e compatibilità con una possibile estensione che potrà decidere le quantità di navi)
        for (int i=1; i<=navi.length;i++){
            inserite=0;
            dim++;
            while (inserite<navi[i-1]){
                posizionamento(m,dim);
                inserite++;
            }
        }
        //Terminato il ciclo sarà completato l'insermento auotmatico, grazie alla collaborazione tra le 2 funzioni.
    }
    public static void posizionamento(int[][] matriceComputer, int dimensioneBarca) { //Karaje
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
                            matriceComputer[x + i][y] = 1; // Posiziono la barca
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
                            matriceComputer[x][y + i] = 1; // Posiziono la barca
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
    public static String stampaCampoGiocatore(int [][] matrice){ //Viapiana
        String s="    "; //Stringa inizializzata con lo spazio che occuperà la colonna verticale di indici e separatori
        //Stampa della riga di indici superiori
        for (int k=0;k<matrice[0].length;k++){
            s=s+k+"\t";
        }
        s=s+"\n";
        //Stampa di una riga di separazione
        for (int p=-1;p<matrice[0].length;p++){ //p=-1 perchè conta anche la prima riga di indici verticali
            s=s+"_"+"\t";
        }
        s=s+"\n";
        // for che stampa la colonna verticale degli indici più il campo
        for( int i = 0; i < matrice.length; i++){
            s=s+i + " | ";
            for ( int j = 0; j < matrice[i].length; j++){
                switch (matrice[i][j]){
                    case 0:
                        s=s+"\uD83C\uDF0A"+"\t";
                        break;
                    case 1:
                        s=s+"\u26F5"+"\t";
                        break;
                    case 2:
                        s=s+"\uD83D\uDCA5"+"\t";
                        break;
                    case 3:
                        s=s+"\uD83D\uDD2B"+"\t";            //   \t = spazio           \n = va a capo
                        break;
                    default:
                        s=s+matrice[i][j]+"\t";
                }
            }
            s=s+"\n";
        }
        return s;
    }
    public static String stampaCampoPng(int [][] matrice){ //Viapiana
        String s="    "; //Stringa inizializzata con lo spazio che occuperà la colonna verticale di indici e separatori
        //Stampa della riga di indici superiori
        for (int k=0;k<matrice[0].length;k++){
            s=s+k+"\t";
        }
        s=s+"\n";
        //Stampa di una riga di separazione
        for (int p=-1;p<matrice[0].length;p++){ //p=-1 perchè conta anche la prima riga di indici verticali
            s=s+"_"+"\t";
        }
        s=s+"\n";
        // for che stampa la colonna verticale degli indici più il campo
        for( int i = 0; i < matrice.length; i++){
            s=s+i + " | ";
            for ( int j = 0; j < matrice[i].length; j++){
                switch (matrice[i][j]){
                    case 0:
                    case 1:
                        s=s+"\uD83C\uDF0A"+"\t";
                        break;
                    case 2:
                        s=s+"\uD83D\uDCA5"+"\t";
                        break;
                    case 3:
                        s=s+"\uD83D\uDD2B"+"\t";
                        break;
                    default:
                        s=s+matrice[i][j]+"\t";
                }
            }
            s=s+"\n";
        }
        return s;
    }
    public static int  colpito ( int [] [] m, int x, int y){ //Locatelli
        int ritorno = 0;
        if (m[x][y] == 0){
            ritorno = 0;
            m[x][y] = 3;
        }
        if (m[x][y] == 1){
            ritorno = 1;
            m[x][y] = 2;
        }
        if (m[x][y] == 2){
            ritorno = 2;
        }
        if (m[x][y] == 3){
            ritorno = 3;
        }
        return ritorno;
    }
    public static boolean vittoria(int[][] matrice) { //Seghezzi
        for(int i = 0; i < matrice.length; i++) {
            for(int j = 0; j < matrice[0].length; j++) {
                if (matrice[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void colpoPng (int [][] m, int livello) { //Rocchi
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
}
