public class locatelli {
    public static int [][] colpito ( int [] [] m, int x, int y){
        if (m[x][y] == 0){
            System.out.println("colpo a vuoto");
            m[x][y] = 3;
        }
        if (m[x][y] == 1){
            System.out.println("colpito");
            m[x][y] = 2;
        }
        if (m[x][y] == 2){
            System.out.println("colpo su una nave già colpita");
        }
        if (m[x][y] == 3){
            System.out.println("colpo a vuoto ripetuto");
        }
                return m;
            }
        }
