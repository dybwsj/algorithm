import java.util.HashMap;

/**
 * @author: duyubo
 * @date: 2021年01月26日, 0026 08:49
 * @description:
 */
public class P1128_等价多米诺骨牌对的数量 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] num = new int[100];
        int ret = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            ret += num[val];
            num[val]++;
        }
        return ret;
    }
}
