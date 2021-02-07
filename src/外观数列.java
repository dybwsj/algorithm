public class 外观数列 {
    public String countAndSay(int n) {
        String result = "1";
        if(n == 1) return result;

        for(int i = 1; i < n; i++){
            StringBuffer sb = new StringBuffer();
            for(int j = 0; j < result.length(); j++){
                int count = 1;
                while(j + 1 < result.length() && result.charAt(j) == result.charAt(j+1)){
                    count++;
                    j++;
                }
                sb.append(count).append(result.charAt(j));
            }
            result = sb.toString();
        }
        return result;
    }
}
