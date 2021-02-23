import java.util.Arrays;

public class 背包问题 {
    // 0-1背包
    public static int zeroOnePack(int V, int N, int[] weight, int[] value){
        //动态规划，V 背包容量， N 物品种类
        int[] dp = new int[V+1];
        for(int i = 1; i < N + 1; i++){
            //逆序实现
            for(int j = V; j >= weight[i-1]; j--){
                dp[j] = Math.max(dp[j - weight[i-1]] + value[i-1], dp[j]);
            }
        }
        return dp[V];
    }

    // 多重背包
    public static int manyPack(int V,int N,int[] weight,int[] value, int[] num){
        //动态规划， k 为多少个
        int[][] dp = new int[N+1][V+1];
        for(int i = 1; i < N + 1; i++){
            // 正序实现，逆序实现可以将空间复杂度缩小到 O(N)
            for(int j = 1; j < V + 1; j++){
                //如果第i件物品的重量大于背包容量j,则不装入背包
                //由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
                if(weight[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else{
                    //考虑物品的件数限制
                    int maxV = Math.min(num[i-1],j/weight[i-1]);
                    for(int k=0;k<maxV+1;k++){
                        dp[i][j] = dp[i][j]>Math.max(dp[i-1][j],dp[i-1][j-k*weight[i-1]]+k*value[i-1]) ? dp[i][j]:Math.max(dp[i-1][j],dp[i-1][j-k*weight[i-1]]+k*value[i-1]);
                    }
                }
            }
        }
        return dp[N][V];
    }

    // 完全背包，相较于0-1背包只是将第二层循环的逆序改为正序
    public static int completePack(int V,int N,int[] weight,int[] value){
        //动态规划
        int[] dp = new int[V+1];
        for(int i = 1; i < N+1; i++){
            // 正序实现
            for(int j = weight[i-1]; j < V + 1; j++){
                dp[j] = Math.max(dp[j - weight[i-1]] + value[i-1], dp[j]);
            }
        }
        return dp[V];
    }

    // 恰好完全装满，和完全背包的区别在于给数组赋初始值的时候将除数组下标 0 以外的值都设为 -INF
    public static int fillPack(int V,int N,int[] weight,int[] value) {
        int[] dp = new int[V+1];
        Arrays.fill(dp, -1000000);
        dp[0] = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = weight[i-1]; j < V + 1; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i-1]] + value[i-1]);
            }
        }
        if (dp[V] < 0) {
            return 0;
        } else {
            return dp[V];
        }
    }
}
