public class 最长回文字串 {
}

class Solution7 {
    int start = 0;
    int length = 1;
    public String longestPalindrome(String s) {
        if (s.length() < 1){
            return "";
        }

        for (int i = 0; i < s.length(); i++){
            find(s,i-1,i+1);//000111000
            find(s,i,i+1);
        }
        return s.substring(start,start+length);

    }

    private void find(String str, int i, int j) {
        while (i > -1 && j < str.length() && str.charAt(i) == str.charAt(j)){
            if (j - i + 1 > length){
                length = j - i + 1;
                start = i;
            }
            i--;
            j++;
        }
    }
}