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
