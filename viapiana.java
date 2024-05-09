public static String stampaCampoGiocatore(int [][] matrice){
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
    public static String stampaCampoPng(int [][] matrice){
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
