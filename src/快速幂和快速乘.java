public class 快速幂和快速乘 {
    public long ksm(long a, long b) {
        long ans = 1, base = a;
        while (b != 0) {
            if ((b & 1) != 0) {
                ans *= base;
            }
            base *= base;
            b >>= 1;
        }
        return ans;
    }

    public long ksc(long a, long b) {
        long ans = 1, base = a;
        while (b != 0) {
            if ((b & 1) != 0) {
                ans += base;
            }
            base *= base;
            b >>= 1;
        }
        return ans;
    }
}
