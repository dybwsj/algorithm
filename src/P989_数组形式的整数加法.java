import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: duyubo
 * @date: 2021年01月22日, 0022 08:51
 * @description:
 */
public class P989_数组形式的整数加法 {
    public static void main(String[] args) {
        addToArrayForm(new int[]{0}, 1000);
    }
    public static List<Integer> addToArrayForm(int[] A, int K) {
        int length = A.length - 1;
        int result = K;
        int res = 0;
        for (int i = length; i >= 0; i--) {
            res = A[i] + result;
            A[i] = res % 10;
            result = res / 10;
        }

        List<Integer> r = new LinkedList<>();
        while(result > 0) {
            r.add(0, result % 10);
            result /= 10;
        }
        for (int i = 0; i < A.length; i++) {
            r.add(A[i]);
        }
        return r;
    }
}
