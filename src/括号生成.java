import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 括号生成 {
    public static void main(String[] args){

        Solution17 s = new Solution17();
        System.out.println(s.generateParenthesis(3));
    }
}

class Solution17 {
    List<String> res = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {

        dfs(n,n,"");
        return res;
    }
    public void dfs(int m, int n, String s){
        if (m == 0 && n == 0){
            res.add(s);
            return;
        }
        if (m > 0){
            dfs(m-1,n, s+"(");
        }
        if (n > m){
            dfs(m, n-1, s+")");
        }
    }
}