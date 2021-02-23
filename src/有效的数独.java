import java.util.HashMap;

public class 有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,Integer>[] r = new HashMap[9];
        HashMap<Integer,Integer>[] c = new HashMap[9];
        HashMap<Integer,Integer>[] b = new HashMap[9];

        for(int i = 0; i < 9; i++){
            r[i] = new HashMap<Integer,Integer>();
            c[i] = new HashMap<Integer,Integer>();
            b[i] = new HashMap<Integer,Integer>();
        }

        for(int x = 0; x < 9; x++){
            for(int y = 0; y < 9; y++){
                char num = board[x][y];
                int make = x/3 * 3 + y/3;
                if(num != '.'){
                    r[x].put((int)num,r[x].getOrDefault((int)num,0)+1);
                    c[y].put((int)num,c[y].getOrDefault((int)num,0)+1);
                    b[make].put((int)num,b[make].getOrDefault((int)num,0)+1);
                    if(r[x].get((int)num) > 1 || c[y].get((int)num) > 1 || b[make].get((int)num) > 1)   return false;
                }

            }
        }
        return true;
    }
}
