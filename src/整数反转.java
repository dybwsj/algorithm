public class 整数反转 {
    public static void main(String[] args){
        Solution8 s = new Solution8();
        System.out.println(s.reverse(-2147483648));
    }
}

class Solution8 {
    public int reverse(int x) {
        long n = 0;
        while(x!=0){
            n = n*10 + x%10;
            x /= 10;
        }
        System.out.println(n);
        if(n>Integer.MAX_VALUE || n < Integer.MIN_VALUE){
            return 0;
        } else {
            return (int)n;
        }
    }
}