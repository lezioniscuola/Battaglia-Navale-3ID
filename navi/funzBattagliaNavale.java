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
    private static void posizionamento(int[][] matriceComputer, int dimensioneBarca){ //Karaje
      //Terminare
    }
    public static String stampaCampoGiocatore(int [][] matrice){ //Viapiana
        String s="    "; //Stringa inizializzata con lo spazio che occuperà la colonna verticale di indici e separatori
        //Terminare
        return s;
    }
    public static String stampaCampoPng(int [][] matrice){ //Funzione modificata di quella di Viapiana
        String s="    "; //Stringa inizializzata con lo spazio che occuperà la colonna verticale di indici e separatori
        //Terminare
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
        //Terminare: Data la matrice con i colpi del png inserire i colpi effettuati evitando così colpi ripetuti
    }
}
