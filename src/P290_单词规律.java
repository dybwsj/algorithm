import java.util.HashMap;
import java.util.Objects;

public class P290_单词规律 {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if(strs.length != pattern.length()) return false;
        HashMap hm = new HashMap();
        for(int i = 0; i < strs.length; i++) {
            //HashMap第一次put的返回值为null，此后的返回值为被覆盖掉的值
            //存入数组下标，依照被覆盖掉的数组下标是否相同判断
            if(!Objects.equals(hm.put(pattern.charAt(i), i), hm.put(strs[i], i))) {
                return false;
            }
        }
        return true;
    }
}
