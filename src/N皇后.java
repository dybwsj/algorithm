import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class N皇后 {
    List<List<String>> list = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        if(n <= 0) return list;
        char[][] qipan = new char[n][n];
        for (char[] chars : qipan) Arrays.fill(chars, '.');
        find(qipan, 0);
        return list;
    }

    private void find(char[][] qipan, int row){
        if(row == qipan[0].length){
            list.add(charToString(qipan));
            return;
        }
        for(int j = 0; j < qipan[row].length; j++){
            if(is(qipan, row, j)){
                qipan[row][j] = 'Q';
                find(qipan, row+1);
                qipan[row][j] = '.';
            }
        }
    }

    private boolean is(char[][] qipan, int row, int col){
        for(char[] x : qipan){
            if(x[col] == 'Q') return false;
        }
        for(int i = row-1, j = col+1; i >= 0 && j < qipan[row].length; i--, j++){
            if(qipan[i][j] == 'Q') return false;
        }
        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--){
            if(qipan[i][j] == 'Q') return false;
        }
        return true;
    }

    private List<String> charToString(char[][] m){
        List<String> result = new LinkedList<>();
        for (char[] x : m){
            result.add(String.valueOf(x));
        }
        return result;
    }
}
