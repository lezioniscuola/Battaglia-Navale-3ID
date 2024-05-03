public class locatelli {
    public static int  colpito ( int [] [] m, int x, int y){
        int ritorno;
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
        }
