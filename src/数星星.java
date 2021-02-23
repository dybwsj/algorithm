public class 数星星 {
    int result = 0;
    int[] res;
    int mark = 1;
    public static void main(String[] args){
        数星星 s = new 数星星();
        System.out.println(s.sumStar(100));
    }
    public int sumStar(int num){
        res = new int[num];
        sum(num);
        return result;
    }
    private void sum(int num){
        if(mark == num+1) {
            result++;
            result%=1000000007;
            return;
        }
        for(int i = 1; i <= num; i++){   //2 1 3
            if(i != mark && res[i-1] == 0){
                mark++;         //2
                res[i-1] = 1;
                sum(num);
                mark--;
                res[i-1] = 0;
            }
        }
    }
}
