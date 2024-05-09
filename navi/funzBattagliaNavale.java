package navi;
import java.util.Random;

public class funzBattagliaNavale {

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
                        s=s+"\uD83D\uDEA2"+"\t";
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
