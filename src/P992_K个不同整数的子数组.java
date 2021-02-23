/**
 * 滑动窗口， 恰好由K个不同整数组成的子数组个数 == 最多由K个不同整数组成的子数组个数 - 最多由K-1个不同整数组成的子数组个数
 */
public class P992_K个不同整数的子数组 {
    public int subarraysWithKDistinct(int[] A, int K) {
        return mostKDistinct(A, K) - mostKDistinct(A, K-1);
    }

    private int mostKDistinct(int[] A, int K) {
        int length = A.length;
        int[] flag = new int[length+1];
        int left = 0;
        int right = 0;
        int num = 0;
        int res = 0;
        for (; right < length; right++) {
            if (flag[A[right]]++ == 0) {
                num++;
            }
            while (num > K) {
                if (--flag[A[left]] == 0) {
                    num--;
                }
                left++;
            }
            res += right - left;
        }
        return res;
    }
}
