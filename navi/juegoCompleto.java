package navi;
import java.util.Scanner;

public class juegoCompleto {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int opzioneSceltaMenu;
        String nome;
        do {
            System.out.println("Benvenuto nella battaglia navale, inserire di seguito il tuo nome: ");
            nome=in.nextLine();
            System.out.println("Benvenuto"+nome+", ora devi scegliere una delle opzioni seguenti: ");
            System.out.println("0-Gioca\n1-Ripassa le regole\n2-Esci");
            opzioneSceltaMenu=in.nextInt();
            switch (opzioneSceltaMenu){
                case 0: //Gioco
                    //Variabili utilizzate
                    boolean isVittoriaPresente;
                    int turnoDiGioco=0,rigaColpo,colonnaColpo,dimensioneCampoDiGioco=0,livello=1 /*Da eliminare*/,difficoltaDiGioco,mosseRimanentiOpzionali=10;
                    int [] colpoDaEffetuare=new int[2];
                    int [][] colpiPng=new int [70][2]; //Da eliminare
                    int [] naviGioc=new int[3]; //Navi in inserimento nel campo del Giocatore
                    int [] naviPc=new int[3]; //Navi in inserimento nel campo del Pc

                    //Scegliere la modalità prima
                    do {
                        System.out.println("Scegli una tra le modalità proposte:");
                        System.out.println(Colori.AZZURRO + "1-Facile\n" + Colori.VERDE + "2-Media\n" + Colori.GIALLO + "3-Difficile\n" + Colori.ROSSO +"4-Difficile^2\n" + Colori.VIOLA + "5-Personalizzata" + Colori.RESET);
                        difficoltaDiGioco=in.nextInt();
                        if (difficoltaDiGioco<1||difficoltaDiGioco>5)
                            System.out.println("Scegli solo tra 1 e 5, grazie.");
                    }while (difficoltaDiGioco<1||difficoltaDiGioco>5);
                    System.out.println(Colori.ROSSO+"Iniziamo:"+Colori.RESET);
                    switch (difficoltaDiGioco){
                        case 1:
                            System.out.println("Nella modalità facile ci saranno 5 barche (dim. 1),3 navi (dim. 2),2 sottomarini (dim. 3).\n\nIl campo sarà invece 9x9. " +
                                    "Per eventuali dubbi consulta regolamento o documentazione ufficiale.");
                            naviGioc[0]=5;
                            naviGioc[1]=3;
                            naviGioc[2]=2;
                            naviPc[0]=5;
                            naviPc[1]=3;
                            naviPc[2]=2;
                            dimensioneCampoDiGioco=9;
                            break;
                        case 2:
                            System.out.println("Nella modalità media ci saranno 5 barche (dim. 1),3 navi (dim. 2),3 sottomarini (dim. 3) per te. Il pc ne avrà meno, ma il numero sta te a scoprirlo.\n\nIl campo sarà invece 11x11." +
                                    "Per eventuali dubbi consulta regolamento o documentazione ufficiale.");
                            naviGioc[0]=5;
                            naviGioc[1]=3;
                            naviGioc[2]=3;
                            naviPc[0]=3;
                            naviPc[1]=2;
                            naviPc[2]=2;
                            dimensioneCampoDiGioco=11;
                            break;
                        case 3:
                            System.out.println("Nella modalità difficile ci saranno 6 barche (dim. 1),1 navi (dim. 2),2 sottomarini (dim. 3) per te. Il pc ne avrà meno, ma il numero sta te a scoprirlo.\n\nIl campo sarà invece 12x12." +
                                    "Per eventuali dubbi consulta regolamento o documentazione ufficiale.");
                            naviGioc[0]=6;
                            naviGioc[1]=1;
                            naviGioc[2]=2;
                            naviPc[0]=3;
                            naviPc[1]=2;
                            naviPc[2]=2; //Se il giocatore ha più navi ci sarà più possibilità di subire danno dal colpo
                            dimensioneCampoDiGioco=12;
                            break;
                        case 4:
                            System.out.println("Nella modalità difficile ci saranno 1 barca (dim. 1),1 nave (dim. 2),1 sottomarino (dim. 3) per te. Il pc ne avrà 1.\n\nIl campo sarà invece 13x13." +
                                    "Per eventuali dubbi consulta regolamento o documentazione ufficiale.");
                            naviGioc[0]=1;
                            naviGioc[1]=1;
                            naviGioc[2]=1;
                            naviPc[0]=1;
                            dimensioneCampoDiGioco=13;
                            System.out.println(Colori.ROSSO+"RICORDA: In questa modalità come già detto nelle regole hai solo 10 mosse possibili."+Colori.RESET);
                            break;
                        case 5:
                            System.out.println("Decidi la dimensione del campo,specificando la specifica dimensione che il lato assumerà: (Deve essere >=9)");
                            do {
                                dimensioneCampoDiGioco=in.nextInt();
                                if (dimensioneCampoDiGioco<9)
                                    System.out.println("Ricorda la grandezza per consentire un gioco ottimale deve essere >=9.");
                            }while (dimensioneCampoDiGioco<9);
                            System.out.println("La quantità di navi è corrispondente a quella della modalità facile.");
                            naviGioc[0]=5;
                            naviGioc[1]=3;
                            naviGioc[2]=2;
                            naviPc[0]=5;
                            naviPc[1]=3;
                            naviPc[2]=2;
                            break;
                    }
                    //Inizio
                    colpiPng[0][0]=dimensioneCampoDiGioco; //Nella prima cella inserisce la lunghezza della matrice
                    //Eliminare

                    //Creazione dei campi
                    int [][] campoPc=funzBattagliaNavale2.campoDiBattaglia(dimensioneCampoDiGioco); //Campo del Pc
                    int [][] campoGiocatore=funzBattagliaNavale2.campoDiBattaglia(dimensioneCampoDiGioco); //Campo del Giocatore

                    //Inserimento delle navi
                    funzBattagliaNavale2.posizionamentoTotale(campoPc,naviPc);
                    funzBattagliaNavale2.posizionamentoTotale(campoGiocatore,naviGioc);

                    //Gioco
                    do {
                        if (turnoDiGioco==0){
                            turnoDiGioco=1; //Indica che il prossimo turno sarà del pc
                            if (difficoltaDiGioco==4){ //Controllo per la modalità a mosse
                                System.out.println("Mosse rimanenti: "+mosseRimanentiOpzionali);
                                mosseRimanentiOpzionali--;
                            }
                            //Giocatore
                            System.out.println("Turno del giocatore:");

                            //Stampa dei campi
                            System.out.println(Colori.VERDE + "Il tuo campo \n"+funzBattagliaNavale2.stampaCampoGiocatore(campoGiocatore)+ Colori.ROSSO + "\n Appunti sulla missione: \n"+funzBattagliaNavale2.stampaCampoPc(campoPc) + Colori.RESET);

                            //Inserimento del colpo
                            System.out.println("Inserire le coordinate da colpire ---> riga:");
                            do {
                                rigaColpo=in.nextInt();
                                if (rigaColpo<0 || rigaColpo>dimensioneCampoDiGioco-1)
                                    System.out.println("Inserire un valore valido.");
                            }while (rigaColpo<0 || rigaColpo>dimensioneCampoDiGioco-1);
                            System.out.println("Inserire le coordinate da colpire ---> colonna:");
                            do {
                                colonnaColpo=in.nextInt();
                                if (colonnaColpo<0 || colonnaColpo>dimensioneCampoDiGioco-1)
                                    System.out.println("Ci sei?");
                            }while (colonnaColpo<0 || colonnaColpo>dimensioneCampoDiGioco-1);

                            //Risultato del colpo
                            switch (funzBattagliaNavale2.colpito(campoPc,rigaColpo,colonnaColpo)){
                                case 0:
                                    System.out.println(Colori.BLU + "Non hai colpito nulla!" + Colori.RESET);
                                    break;
                                case 1:
                                    System.out.println(Colori.VERDE + "Hai fatto centro!" + Colori.RESET);
                                    break;
                                case 2:
                                    System.out.println(Colori.GIALLO + "Hai ricolpito la stessa nave .. Stai attento!" + Colori.RESET);
                                    break;
                                case 3:
                                    System.out.println(Colori.ROSSO + "Attenzione qui non c'era già nulla!" + Colori.RESET);
                                    break;
                            }

                            //Controllo dell'eventuale vittoria
                            isVittoriaPresente=funzBattagliaNavale2.vittoria(campoPc);
                            if (isVittoriaPresente)
                                System.out.println(Colori.VIOLA + "Hai vinto " + nome + "!" + Colori.RESET);
                            if (difficoltaDiGioco==4){
                                if (mosseRimanentiOpzionali==0){
                                    System.out.println(Colori.ROSSO + "Hai terminato le mosse, mi spiace." + Colori.RESET);
                                    break;
                                }
                            }
                        }else {
                            turnoDiGioco=0;//Indica che il prossimo turno sarà del giocatore
                            System.out.println("Esito turno avversario:");
                            //Inserimento del colpo
                            //Versione TEMPORANEA
                            funzBattagliaNavale2.colpoPng1(colpiPng,livello); //Cambiare
                            rigaColpo=colpiPng[livello][0]; //Cambiare
                            colonnaColpo=colpiPng[livello][1]; //Cambiare
                            livello++; //Cambiare

                            //Risultato del colpo
                            switch (funzBattagliaNavale2.colpito(campoGiocatore,rigaColpo,colonnaColpo)){
                                case 0:
                                    System.out.println(Colori.BLU + "L'avversario non ha colpito nulla!" + Colori.RESET);
                                    break;
                                case 1:
                                    System.out.println(Colori.VERDE + "ATTENZIONE: Nave colpita" + Colori.RESET);
                                    break;
                            }

                            isVittoriaPresente=funzBattagliaNavale2.vittoria(campoGiocatore);
                            if (isVittoriaPresente)
                                System.out.println("Hai perso " + nome + "!");
                        }
                    }while (!isVittoriaPresente);
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
                case 2: //Termine di tutto
                    System.out.println("Grazie mille per aver giocato.");
                    break;
                default:
                    System.out.println("Scegli solo una delle opzioni proposte!");
            }
        }while (opzioneSceltaMenu!=2);
        in.close();
    }
}
