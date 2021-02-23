import java.util.Arrays;

/**
 * @author: duyubo
 * @date: 2020年12月25日, 0025 11:35
 * @description:
 */
public class P455_分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int length = s.length;
        for (int i = g.length - 1; i >= 0; i--) {
            if (length == 0) {
                return count;
            }
            if (g[i] <= s[length - 1]) {
                length--;
                count++;
            }
        }
        return count;
    }
}
