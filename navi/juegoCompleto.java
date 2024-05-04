package navi;
import java.util.Scanner;

public class juegoCompleto {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int scelta;
        do {
            System.out.println("Benvenuto Giovanni ... o come ti chiami, ora devi scegliere una delle opzioni seguenti: ");
            System.out.println("0-Gioca\n1-Ripassa le regole\n2-Esci");
            scelta=in.nextInt();
            switch (scelta){
                case 0: //Gioco
                    //Variabili d'appoggio
                    boolean vittoria;
                    int turno=0, cRiga,cColonna,risColpo,lunghezza,livello=1;
                    int [][] colpiPng=new int [70][2];

                    //Inizio
                    System.out.println("Benvenuto nel gioco, iniziamo:");//Difficoltà da aggiungere
                    System.out.println("Inanzitutto decidi la lunghezza del lato del campo: (Deve essere >=9)");
                    do {
                        lunghezza=in.nextInt();
                        if (lunghezza<9)
                            System.out.println("Ci sei?");
                    }while (lunghezza<9);
                    colpiPng[0][0]=lunghezza; //Nella prima cella inserisce la lunghezza della matrice

                    //Creazione dei campi
                    int [][] mPc=funzBattagliaNavale.campoDiBattaglia(lunghezza); //Campo del Pc
                    int [][] mGioc=funzBattagliaNavale.campoDiBattaglia(lunghezza); //Campo del Giocatore

                    //Inserimento delle navi
                    funzBattagliaNavale.posizionamentoTotale(mPc);
                    funzBattagliaNavale.posizionamentoTotale(mGioc);

                    //Gioco
                    do {
                        if (turno%2==0){
                            //Giocatore
                            System.out.println("Turno del giocatore:");

                            //Stampa dei campi
                            System.out.println("Il tuo campo \n"+funzBattagliaNavale.stampaCampoGiocatore(mGioc)+"\n Appunti sulla missione: \n"+funzBattagliaNavale.stampaCampoPng(mPc));

                            //Inserimento del colpo
                            System.out.println("Inserire le coordinate da colpire; riga:");
                            do {
                                cRiga=in.nextInt();
                                if (cRiga<0 || cRiga>lunghezza-1)
                                    System.out.println("Ci sei?");
                            }while (cRiga<0 || cRiga>lunghezza-1);
                            System.out.println("Inserire le coordinate da colpire; colonna:");
                            do {
                                cColonna=in.nextInt();
                                if (cColonna<0 || cColonna>lunghezza-1)
                                    System.out.println("Ci sei?");
                            }while (cColonna<0 || cColonna>lunghezza-1);

                            //Risultato del colpo
                            risColpo=funzBattagliaNavale.colpito(mPc,cRiga,cColonna);
                            switch (risColpo){
                                case 0:
                                    System.out.println("Hai fatto letteralmente un buco nell'acqua");
                                    break;
                                case 1:
                                    System.out.println("Hai fatto centro");
                                    break;
                                case 2:
                                    System.out.println("Hai ricolpito la stessa nave .. Stai attento!");
                                    break;
                                case 3:
                                    System.out.println("Hai ri-bucato l'acqua .. Stai attento!");
                                    break;
                            }

                            //Controllo dell'eventuale vittoria
                            vittoria=funzBattagliaNavale.vittoria(mPc);
                            if (vittoria)
                                System.out.println("Hai vinto Capo Di PandaBuy");
                        }else {
                            //Png
                            System.out.println("Turno del Png:");

                            //Inserimento del colpo
                            funzBattagliaNavale.colpoPng(colpiPng,livello);
                            cRiga=colpiPng[livello][0];
                            cColonna=colpiPng[livello][1];
                            livello++;

                            //Risultato del colpo
                            risColpo=funzBattagliaNavale.colpito(mPc,cRiga,cColonna);
                            switch (risColpo){
                                case 0:
                                    System.out.println("Ha fatto letteralmente un buco nell'acqua");
                                    break;
                                case 1:
                                    System.out.println("Ha fatto centro");
                                    break;
                                case 2: //In teoria non servirebbe ma funzione in beta testing quindi per sicurezza lo si lascia
                                    System.out.println("Ha ricolpito la stessa nave .. Stai attento!");
                                    break;
                                case 3: //In teoria non servirebbe ma funzione in beta testing quindi per sicurezza lo si lascia
                                    System.out.println("Ha ri-bucato l'acqua .. Stai attento!");
                                    break;
                            }

                            vittoria=funzBattagliaNavale.vittoria(mGioc);
                            if (vittoria)
                                System.out.println("Hai perso trimone");
                        }
                        turno++;
                    }while (vittoria);
                    break;
                case 1: //Regole
                    System.out.println("Regolamento della battaglia navale (Classica):");
                    System.out.println("Per giocare a battaglia navale occorre una tabellone di forma qudrata composto da celle, tutte di uguali dimensioni (per esempio 10×10 o un'altra dimensione concordata).\n" +
                            " I quadretti della tabella sono identificate da coppie di coordinate numeriche,corrispondenti a riga e colonna.\n" +
                            " All'inizio il giocatore deve scegliere la difficoltà, e le proprie navi per magia saranno posizionate.\n" +
                            "Una nave occupa un certo numero di quadretti adiacenti in linea retta (orizzontale o verticale) sulla tabella. NB: Due navi possono toccarsi.\n" +
                            "In base alla difficoltà ci saranno più o meno navi posizionate, sempre di dimensione 1,2 e massimo 3. Il giocatore di turno \"spara un colpo\" dichiarando un quadretto (per esempio, \"B-5\"). Quando un colpo centra l'ultimo quadretto di una nave non ancora affondata, il giocatore perderà la nave. \n" +
                            "Vince il giocatore che fa affondare tutte le navi dell'avversario per primo.");
                    System.out.println("Simbologie usate: \n - \uD83C\uDF0A = Mare \n - \uD83D\uDEA2 = Nave \n - \uD83D\uDCA5 = Colpo ad una nave \n - \uD83D\uDD2B = Colpo a vuoto");
                    System.out.println("Essendo che è PvE al ggiocatore verranno proposti due campi uno quello da colpire ed uno il suo.");
                    break;
                case 2: //Bye bye
                    System.out.println("Grazie mille per aver giocato.");
                    break;
                default:
                    System.out.println("Scegli solo una delle opzioni proposte!");
            }
        }while (scelta!=2);
    }
}
