import java.util.Arrays;

/**
 * @author: duyubo
 * @date: 2021年02月02日, 0002 09:56
 * @description: 埃氏筛（如果一个数是质数，那么该数的 2 * x , 3 * x, ....都不是质数）
 */
public class P204_计数质数 {
    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}
