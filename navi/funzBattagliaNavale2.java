package navi;
import java.util.Random;

public class funzBattagliaNavale2 {

    public static int [][] campoDiBattaglia(int dimensioneCampoDiGioco){ //Panseri
        int [][] campoDaAssegnare = new int [dimensioneCampoDiGioco][dimensioneCampoDiGioco];
        return campoDaAssegnare; //Il campo potrà essere assegnato sia a pc che a giocatore
    }
    public static void posizionamentoTotale(int [][] campoGiocatoreOPc,int [] navi){ //D'Ortenzio
        //La funzione si baserà sul gestire le navi da inserire che verranno inserite dalla funzione: posizionamento() di Karaje
        //N° navi in base al dichiarato nel Main
        int naviInserite,dimensioneNave=0; //Navi totali da inserire (Per comodità e compatibilità con una possibile estensione che potrà decidere le quantità di navi)
        for (int i=1; i<=navi.length;i++){
            naviInserite=0;
            dimensioneNave++;
            while (naviInserite<navi[i-1]){
                posizionamento(campoGiocatoreOPc,dimensioneNave);
                naviInserite++;
            }
        }
        //Terminato il ciclo sarà completato l'insermento auotmatico, grazie alla collaborazione tra le 2 funzioni.
    }
    public static void posizionamento(int[][] campoGiocatoreOPc, int dimensioneNave) { //Karaje
        int righe = campoGiocatoreOPc.length; // Ottengo il numero di righe della matrice
        int colonne = campoGiocatoreOPc[0].length; // Ottengo il numero di colonne della matrice
        int x = (int) (Math.random() * righe); // Genero un numero casuale per la coordinata x
        int y = (int) (Math.random() * colonne); // Genero un numero casuale per la coordinata y
        int direzione = (int) (Math.random() * 2); // Genero un numero casuale per la direzione
        boolean posizionato = false; // Variabile booleana per controllare se la barca è stata posizionata
        if (dimensioneNave >= 4 || dimensioneNave < 1) {
            throw new IllegalArgumentException("Dimensione barca non valida"); // In caso in cui la dimensione della barca non è valida si lancia un errore
        }
        while (!posizionato) { // Ciclo finché la barca non è posizionata
            if (direzione == 0) { // Se la direzione è 0
                if (x + dimensioneNave < righe) { // Se la barca può stare nella matrice
                    for (int i = 0; i < dimensioneNave; i++) { // Ciclo per controllare se la barca può stare nella matrice
                        if (campoGiocatoreOPc[x + i][y] == 0) { // Se la cella è vuota
                            posizionato = true; // La barca può stare
                        } else { // Se la cella non è vuota
                            posizionato = false; // La barca non può stare
                            break; // Esco dal ciclo
                        }
                    }
                    if (posizionato) { // Se la barca può stare
                        for (int i = 0; i < dimensioneNave; i++) { // Ciclo per posizionare la barca
                            campoGiocatoreOPc[x + i][y] = 1; // Posiziono la barca
                        }
                    }
                }
            } else { // Se la direzione è 1
                if (y + dimensioneNave < colonne) { // Se la barca può stare nella matrice
                    for (int i = 0; i < dimensioneNave; i++) { // Ciclo per controllare se la barca può stare nella matrice
                        if (campoGiocatoreOPc[x][y + i] == 0) { // Se la cella è vuota
                            posizionato = true; // La barca può stare
                        } else {
                            posizionato = false; // La barca non può stare
                            break;
                        }
                    }
                    if (posizionato) { // Se la barca può stare
                        for (int i = 0; i < dimensioneNave; i++) { // Ciclo per posizionare la barca
                            campoGiocatoreOPc[x][y + i] = 1; // Posiziono la barca
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
    public static String stampaCampoGiocatore(int [][] campoGiocatore){ //Viapiana
        String stringaCampoGiocatore="    "; //Stringa inizializzata con lo spazio che occuperà la colonna verticale di indici e separatori
        //Stampa della riga di indici superiori
        for (int k=0;k<campoGiocatore[0].length;k++){
            stringaCampoGiocatore=stringaCampoGiocatore+k+"\t";
        }
        stringaCampoGiocatore=stringaCampoGiocatore+"\n";
        //Stampa di una riga di separazione
        for (int p=-1;p<campoGiocatore[0].length;p++){ //p=-1 perchè conta anche la prima riga di indici verticali
            stringaCampoGiocatore=stringaCampoGiocatore+"_"+"\t";
        }
        stringaCampoGiocatore=stringaCampoGiocatore+"\n";
        // for che stampa la colonna verticale degli indici più il campo
        for( int i = 0; i < campoGiocatore.length; i++){
            if (i>=10)
                stringaCampoGiocatore=stringaCampoGiocatore+i + "| ";
            else
                stringaCampoGiocatore=stringaCampoGiocatore+i + " | ";
            for ( int j = 0; j < campoGiocatore[i].length; j++){
                switch (campoGiocatore[i][j]){
                    case 0:
                        stringaCampoGiocatore=stringaCampoGiocatore+"🌊\t"; // \t = spazio
                        break;
                    case 1:
                        stringaCampoGiocatore=stringaCampoGiocatore+"⛵\t";
                        break;
                    case 2:
                        stringaCampoGiocatore=stringaCampoGiocatore+"💥\t";
                        break;
                    case 3:
                        stringaCampoGiocatore=stringaCampoGiocatore+"🔫\t";
                        break;
                    default:
                        stringaCampoGiocatore=stringaCampoGiocatore+campoGiocatore[i][j]+"\t";
                }
            }
            stringaCampoGiocatore=stringaCampoGiocatore+"\n";
        }
        return stringaCampoGiocatore;
    }
    public static String stampaCampoPc(int [][] campoPc){ //Viapiana
        String stringaCampoPc="    "; //Stringa inizializzata con lo spazio che occuperà la colonna verticale di indici e separatori
        //Stampa della riga di indici superiori
        for (int k=0;k<campoPc[0].length;k++){
            stringaCampoPc=stringaCampoPc+k+"\t";
        }
        stringaCampoPc=stringaCampoPc+"\n";
        //Stampa di una riga di separazione
        for (int p=-1;p<campoPc[0].length;p++){ //p=-1 perchè conta anche la prima riga di indici verticali
            stringaCampoPc=stringaCampoPc+"_"+"\t";
        }
        stringaCampoPc=stringaCampoPc+"\n";
        // for che stampa la colonna verticale degli indici più il campo
        for( int i = 0; i < campoPc.length; i++){
            if (i>=10)
                stringaCampoPc=stringaCampoPc+i + "| ";
            else
                stringaCampoPc=stringaCampoPc+i + " | ";
            for ( int j = 0; j < campoPc[i].length; j++){
                switch (campoPc[i][j]){
                    case 0:
                    case 1:
                        stringaCampoPc=stringaCampoPc+"🌊\t";
                        break;
                    case 2:
                        stringaCampoPc=stringaCampoPc+"💥\t";
                        break;
                    case 3:
                        stringaCampoPc=stringaCampoPc+"🔫\t";
                        break;
                    default:
                        stringaCampoPc=stringaCampoPc+campoPc[i][j]+"\t";
                }
            }
            stringaCampoPc=stringaCampoPc+"\n";
        }
        return stringaCampoPc;
    }
    public static int colpito ( int [][] campoGiocatoreOPc, int x, int y) { //Locatelli
        int ritorno = 0;
        if (campoGiocatoreOPc[x][y] == 0) {
            ritorno = 0;
            campoGiocatoreOPc[x][y] = 3;
        } else if (campoGiocatoreOPc[x][y] == 1) {
            ritorno = 1;
            campoGiocatoreOPc[x][y] = 2;
        } else if (campoGiocatoreOPc[x][y] == 2) {
            ritorno = 2;
        } else if (campoGiocatoreOPc[x][y] == 3) {
            ritorno = 3;
        }
        return ritorno;
    }
        public static boolean vittoria(int[][] campoGiocatoreOPc) { //Seghezzi
        for(int i = 0; i < campoGiocatoreOPc.length; i++) {
            for(int j = 0; j < campoGiocatoreOPc[0].length; j++) {
                if (campoGiocatoreOPc[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void colpoPng1 (int [][] m, int livello) { //Rocchi
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
    public static void colpoPc (int [][] campoGiocatore, int dimensioneCampoDiGioco, int [] colpoDaEffettuare) { //Rocchi nuova versione
        int rigaColpo,colonnaColpo;
        boolean isGiaColpito=false;
        do {
            // Generazione di due numeri casuali compresi tra 0 e n
            rigaColpo = (int) (Math.random() * dimensioneCampoDiGioco);
            colonnaColpo = (int) (Math.random() * dimensioneCampoDiGioco);
            //Verifica di cosa contiene la casella della matrice del campo
            if (campoGiocatore[rigaColpo][colonnaColpo] == 2 || campoGiocatore[rigaColpo][colonnaColpo] == 3){
                isGiaColpito=true;
            } 
        }while (isGiaColpito);
        colpoDaEffettuare[0]=rigaColpo;
        colpoDaEffettuare[1]=colonnaColpo;
    }
}
