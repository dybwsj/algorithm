import java.util.Arrays;
import java.util.HashMap;

public class Z字形变换 {
    public static void main(String[] args){

        Solution6 s = new Solution6();
        System.out.println(s.convert("LEETCODEISHIRING", 3));
    }
}

class Solution6 {
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }

        //数学规律题
        StringBuilder sb = new StringBuilder();
        int m = 0;
        for (int i = 0; i < numRows; i++){

            //每次跳跃到 N 字中的竖线部分，所以不会到达斜杠部分的字符。
            for(int j = i; j < s.length(); j+= (numRows - 1) * 2){
                sb.append(s.charAt(j));

                //这段代码寻找 N 字中的斜杠位置的字符，且第一行和最后一行不会出现斜杠。
                //j + 2 * (numRows - i - 1);  表示当前字符与同一行斜杠中的字符的关系。
                if (i > 0 && i < numRows - 1) {
                    System.out.println(sb.toString());

                    int sec = j + 2 * (numRows - i - 1);
                    if (sec < s.length()) {
                        sb.append(s.charAt(sec));
                    }
                    System.out.println(sb.toString() + ":-----sec:" + sec);

                }
            }
        }
        return sb.toString();
    }
}