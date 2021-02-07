public class 字符串匹配 {
    public static void main(String[] args){
    }
}

//KMP算法  还有暴力算法（Java的String类里indexOf()方法所使用）和BM算法（最快，Ctrl+f所使用的）
class Solution5 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0){
            return 0;
        }
        if (haystack.length() == 0){
            return -1;
        }
        int i = 0, j = 0;
        int[] next = getNext(needle);
        while (i < haystack.length() && j < needle.length()){
            if (haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == needle.length()){
            return i - j;
        }
        return 0;
    }

    private int[] getNext(String str) {
        int[] next = new int[str.length()];
        int i = 0;
        int j = -1;
        next[0] = -1;
        next[1] = 0;
        char[] array = str.toCharArray();
        while (i < array.length-1) {
            if (j == -1 || array[j] == array[i]){
                next[++i] = ++j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
}