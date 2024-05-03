public class viapiana {
    private static string stampa(int [][] matrice){
 // for che stampa la colonna verticale degli indici più il campo
		for( int i = 0; i < matrice.length; i++){
            System.out.print(i + " | ");
            for ( int j = 0; j < matrice[i].length; j++){
                    System.out.print(matrice[i][j]);
            }
            System.out.println();
            
        }
	}
}
