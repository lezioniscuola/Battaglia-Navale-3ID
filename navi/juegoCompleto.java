package navi;
import java.util.Scanner;

public class juegoCompleto {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int scelta;
        String nome="";
        do {
            System.out.println("Benvenuto nella battaglia navale, come ti chiami? ");
            nome=in.nextLine();
            System.out.println("Nome registrato: Guglielmo");
            System.out.println("Benvenuto Guglielmo, ora devi scegliere una delle opzioni seguenti: ");
            System.out.println("0-Gioca\n1-Ripassa le regole\n2-Esci");
            scelta=in.nextInt();
            switch (scelta){
                case 0: //Gioco
                    //Variabili d'appoggio
                    boolean vittoria;
                    int turno=0, cRiga,cColonna,risColpo,lunghezza = 0,livello=1,modalita,mosse=10;
                    int [][] colpiPng=new int [70][2];
                    int [] naviGioc=new int[3];
                    int [] naviPc=new int[3];

                    //Scegliere la modalità prima
                    do {
                        System.out.println("Scegli una tra le modalità proposte:");
                        System.out.println("1-Facile\n2-Media\n3-Difficile\n4-Difficile^2\n5-Personalizzata");
                        modalita=in.nextInt();
                        if (modalita<1||modalita>5)
                            System.out.println("Scegli solo tra 1 e 5");
                    }while (modalita<1||modalita>5);
                    System.out.println("Benvenuto nel gioco, iniziamo:");
                    switch (modalita){
                        case 1:
                            System.out.println("Nella modalità facile ci saranno 5 barche (dim. 1),3 navi (dim. 2),2 sottomarini (dim. 3).\n\nIl campo sarà invece 9x9");
                            naviGioc[0]=5;
                            naviGioc[1]=3;
                            naviGioc[2]=2;
                            naviPc[0]=5;
                            naviPc[1]=3;
                            naviPc[2]=2;
                            lunghezza=9;
                            break;
                        case 2:
                            System.out.println("Nella modalità media ci saranno 5 barche (dim. 1),3 navi (dim. 2),3 sottomarini (dim. 3) per te. Il pc ne avrà meno, ma il numero sta te a scoprirlo.\n\nIl campo sarà invece 11x11");
                            naviGioc[0]=5;
                            naviGioc[1]=3;
                            naviGioc[2]=3;
                            naviPc[0]=3;
                            naviPc[1]=2;
                            naviPc[2]=2;
                            lunghezza=11;
                            break;
                        case 3:
                            System.out.println("Nella modalità difficile ci saranno 6 barche (dim. 1),1 navi (dim. 2),2 sottomarini (dim. 3) per te. Il pc ne avrà meno, ma il numero sta te a scoprirlo.\n\nIl campo sarà invece 9x9");
                            naviGioc[0]=6;
                            naviGioc[1]=1;
                            naviGioc[2]=2;
                            naviPc[0]=3;
                            naviPc[1]=2;
                            naviPc[2]=2; //Se il giocatore ha più navi ci sarà più possibilità di subire danno dal colpo
                            lunghezza=9;
                            break;
                        case 4:
                            System.out.println("Nella modalità difficile ci saranno 1 barca (dim. 1),1 nave (dim. 2),1 sottomarino (dim. 3) per te. Il pc ne avrà 1.\n\nIl campo sarà invece 13x13");
                            naviGioc[0]=1;
                            naviGioc[1]=1;
                            naviGioc[2]=1;
                            naviPc[0]=1;
                            lunghezza=13;
                            System.out.println("Ah scusa ... mi sono dimenticato di dirti che tu hai solo 10 colpi massimi.");
                            break;
                        case 5:
                            System.out.println("Inanzitutto decidi la lunghezza del lato del campo: (Deve essere >=9)");
                            do {
                                lunghezza=in.nextInt();
                                if (lunghezza<9)
                                    System.out.println("Ci sei?");
                            }while (lunghezza<9);
                            break;
                    }
                    //Inizio
                    colpiPng[0][0]=lunghezza; //Nella prima cella inserisce la lunghezza della matrice

                    //Creazione dei campi
                    int [][] mPc=funzBattagliaNavale2.campoDiBattaglia(lunghezza); //Campo del Pc
                    int [][] mGioc=funzBattagliaNavale2.campoDiBattaglia(lunghezza); //Campo del Giocatore

                    //Inserimento delle navi
                    funzBattagliaNavale2.posizionamentoTotale(mPc,naviPc);
                    funzBattagliaNavale2.posizionamentoTotale(mGioc,naviGioc);

                    //Gioco
                    do {
                        if (turno%2==0){
                            if (modalita==4){ //Controllo per la modalità a mosse
                                System.out.println("Mosse rimanenti: "+mosse);
                                mosse--;
                            }
                            //Giocatore
                            System.out.println("Turno del giocatore:");

                            //Stampa dei campi
                            System.out.println("Il tuo campo \n"+funzBattagliaNavale2.stampaCampoGiocatore(mGioc)+"\n Appunti sulla missione: \n"+funzBattagliaNavale2.stampaCampoPng(mPc));

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
                            switch (funzBattagliaNavale2.colpito(mPc,cRiga,cColonna)){
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
                                    System.out.println("Hai ri-bucato l'acqua .. Sei proprio un pentito!");
                                    break;
                            }

                            //Controllo dell'eventuale vittoria
                            vittoria=funzBattagliaNavale2.vittoria(mPc);
                            if (vittoria)
                                System.out.println("Hai vinto " + nome + "!");
                            if (modalita==4){
                                if (mosse==0){
                                    System.out.println("Hai terminato le mosse e Pc vince");
                                    break;
                                }
                            }
                        }else {
                            //Png
                            System.out.println("Turno del Png:");

                            //Inserimento del colpo
                            funzBattagliaNavale2.colpoPng(colpiPng,livello);
                            cRiga=colpiPng[livello][0];
                            cColonna=colpiPng[livello][1];
                            livello++;

                            //Risultato del colpo
                            risColpo=funzBattagliaNavale2.colpito(mGioc,cRiga,cColonna);
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

                            vittoria=funzBattagliaNavale2.vittoria(mGioc);
                            if (vittoria)
                                System.out.println("Hai perso " + nome + "!");
                        }
                        turno++; //gestisce i turni fra giocatori
                    }while (!vittoria);
                    break;
                case 1: //Regole
                    System.out.println("Regolamento della battaglia navale (Classica):");
                    System.out.println("Per giocare a battaglia navale occorre una tabellone di forma qudrata composto da celle, tutte di uguali dimensioni (per esempio 10×10 o un'altra dimensione concordata).\n" +
                            " I quadretti della tabella sono identificate da coppie di coordinate numeriche,corrispondenti a riga e colonna.\n" +
                            " All'inizio il giocatore deve scegliere la difficoltà, e le proprie navi per magia saranno posizionate.\n" +
                            "Una nave occupa un certo numero di quadretti adiacenti in linea retta (orizzontale o verticale) sulla tabella. NB: Due navi possono toccarsi.\n" +
                            "In base alla difficoltà ci saranno più o meno navi posizionate, sempre di dimensione 1,2 e massimo 3. Il giocatore di turno \"spara un colpo\" dichiarando un quadretto (per esempio, \"B-5\"). Quando un colpo centra l'ultimo quadretto di una nave non ancora affondata, il giocatore perderà la nave. \n" +
                            "Vince il giocatore che fa affondare tutte le navi dell'avversario per primo.");
                    System.out.println("Simbologie usate: \n - 🌊 = Mare \n - ⛵ = Nave \n - 💥 = Colpo ad una nave \n - 🔫 = Colpo a vuoto");
                    System.out.println("Essendo che è PvE al giocatore verranno proposti due campi uno quello da colpire ed uno il suo.");
                    break;
                case 2: //Bye bye
                    System.out.println("Grazie mille per aver giocato.");
                    break;
                default:
                    System.out.println("Scegli solo una delle opzioni proposte!");
            }
        }while (scelta!=2);
        in.close();
    }
}
