import java.util.Arrays;

/**
 * @author: duyubo
 * @date: 2020年12月15日, 0015 16:47
 * @description:
 */
public class P738_单调递增的数字 {
    public int monotoneIncreasingDigits(int N) {
        char[] strs = Integer.toString(N).toCharArray();
        int i = 1;
        while (i < strs.length && strs[i-1] <= strs[i]) {
            i++;
        }
        int j;
        if(i < strs.length) {
            for (j = i-1; j >= 0 && strs[j] > strs[j+1];) {
                strs[j] -= 1;
                j--;
            }
            for (int z = j+2; z < strs.length; z++) {
                strs[z] = '9';
            }
        }

        return Integer.parseInt(new String(strs));
    }
}
