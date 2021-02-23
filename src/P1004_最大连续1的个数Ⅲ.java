public class P1004_最大连续1的个数Ⅲ {
    public int longestOnes(int[] A, int K) {
        int length = A.length;
        int left = 0;
        int right = 0;
        int num = 0;
        int res = 0;
        for (; right < length; right++) {
            if (A[right] == 1) {
                continue;
            }
            num++;
            if (num > K) {
                res = Math.max(res, right - left);
                while (A[left] != 0) {
                    left++;
                }
                left += 1;
                num -= 1;
            }
        }
        res = Math.max(res, right - left);
        return res;

        // 标准滑动窗口模板
//        int N = A.length;
//        int res = 0;
//        int left = 0, right = 0;
//        int zeros = 0;
//        while (right < N) {
//            if (A[right] == 0)
//                zeros ++;
//            while (zeros > K) {
//                if (A[left++] == 0)
//                    zeros --;
//            }
//            res = Math.max(res, right - left + 1);
//            right ++;
//        }
//        return res;
    }
}
