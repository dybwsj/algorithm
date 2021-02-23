public class 最长公共前缀 {
}

class Solution12 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String one = strs[0];
        for(int i = 1; i < strs.length; i++){
            String str = "";
            int l = Math.min(one.length(), strs[i].length());
            for(int j = 0; j < l; j++){
                if(one.charAt(j) == strs[i].charAt(j)){
                    str+=one.charAt(j);
                } else {
                    break;
                }
            }
            one = str;
        }
        return one;
    }
}