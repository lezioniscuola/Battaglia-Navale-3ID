public class seghezzi {
    public static boolean vittoria(int[][] matrice) {
        for(int i = 0; i < matrice.length; i++) {
            for(int j = 0; j < matrice[0].length; j++) {
                if (matrice[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
