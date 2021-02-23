import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 字母异位词分组 {
    public static void main(String[] args){
        groupAnagrams(new String[]{"hos","boo","nay","deb","wow","bop","bob","brr","hey","rye","eve","elf","pup","bum","iva","lyx","yap","ugh","hem","rod","aha","nam","gap","yea","doc","pen","job","dis","max","oho","jed","lye","ram","pup","qua","ugh","mir","nap","deb","hog","let","gym","bye","lon","aft","eel","sol","jab"});
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List> hm = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            int[] arr = new int[26];
            Arrays.fill(arr, 0);
            for(int j = 0; j < strs[i].length(); j++){
                arr[strs[i].charAt(j) - 'a'] += 1;
            }
            String str = Arrays.toString(arr);
            System.out.println(str);
            if(!hm.containsKey(str)){
                hm.put(str,new ArrayList());
            }
            hm.get(str).add(strs[i]);
        }
        return new ArrayList(hm.values());
    }
}
