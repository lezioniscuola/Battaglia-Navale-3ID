public class dortenzio {
        private static void posizionamento(int [][] m){
        // D'Ortenzio
        //La funzione si baserà sul gestire le navi da inserire che verranno inserite dalla funzione: posizionamento() di Karaje
        int [] navi={5,3,2}; //Nave piccola (1 casella):5,Veliero (2 caselle):3,Portaerei (3 caselle):2
        int inserite,dim=0; //Navi totali da inserire (Per comodità e compatibilità con una possibile estensione che potrà decidere le quantità di navi)
        for (int i=1; i<=navi.length;i++){
            inserite=0;
            dim++;
            while (inserite<navi[i-1]){
                funzBattagliaNavale.posizionamento(m,dim);
                inserite++;
            }
        }
        //Terminato il ciclo sarà completato l'insermento auotmatico, grazie alla collaborazione tra le 2 funzioni.
      }
}
