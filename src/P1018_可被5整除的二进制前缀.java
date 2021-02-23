import java.util.ArrayList;
import java.util.List;

/**
 * @author: duyubo
 * @date: 2021年01月14日, 0014 09:01
 * @description:
 */
public class P1018_可被5整除的二进制前缀 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList<Boolean>();
        int prefix = 0;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            prefix = ((prefix << 1) + A[i]) % 5;
            list.add(prefix == 0);
        }
        return list;
    }
}
