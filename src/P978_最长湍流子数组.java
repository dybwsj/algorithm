public class P978_最长湍流子数组 {
    public static void main(String[] args) {
        maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9});
    }
    public static int maxTurbulenceSize(int[] arr) {
        int ret = 1;
        int n = arr.length;
        int dp0 = 1, dp1 = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                dp0 = dp1 + 1;
                dp1 = 1;
            } else if (arr[i - 1] < arr[i]) {
                dp1 = dp0 + 1;
                dp0 = 1;
            } else {
                dp0 = 1;
                dp1 = 1;
            }
            ret = Math.max(ret, dp0);
            ret = Math.max(ret, dp1);
        }
        return ret;
    }
}
