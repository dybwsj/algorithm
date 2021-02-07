public class 找零 {
    public static void main(String[] args){
        System.out.println(GetCoinCount(200));
    }
    public static int GetCoinCount (int N) {
        // write code here
        int num = 1024 - N;  //824
        int result = 0;
        while(num > 0){
            if(num >= 64){  //
                num -= 64;
                result++;
                System.out.println(result + "xmmmm");
                continue;
            }
            if(num >= 16){
                num-=16;
                result++;
                System.out.println(result + "ymmmm");
                continue;
            }
            if(num >= 1){
                num -= 1;
                result++;
                System.out.println(result);

            }
        }
        return result;
    }
}
