public class 回文数 {
    public static void main(String[] args) {
        Solution9 s = new Solution9();
        System.out.println(s.isPalindrome(1001));
    }
}

class Solution9 {
    public boolean isPalindrome(int x) {
        //转为字符串比较
//        if (x < 0) {
//            return false;
//        }
//        String s = String.valueOf(x);
//        int i = 0;
//        int j = s.length()-1;
//        while (i != j && i < j){
//            if (s.charAt(i) == s.charAt(j)){
//                i++;
//                j--;
//            } else {
//                return false;
//            }
//        }
//        return true;

        //整数比较
        if (x < 0) {
            return false;
        }
        int z = 0;
        int m = x;
        while (m!=0){
            z = z*10+m%10;
            m = m/10;
        }
        return z == x;
    }
}