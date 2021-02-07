/**
 * @author: duyubo
 * @date: 2020年12月28日, 0028 16:18
 * @description: 困难，最多两笔交易
 *
 * 股票类型题解：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/si-chong-jie-fa-tu-jie-188mai-mai-gu-piao-de-zui-j/
 *
 * 本题题解：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/xiao-bai-tong-su-yi-dong-de-jie-fa-by-clark-12/
 */
public class P123_买卖股票的最佳时机III {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;
        int pro1 = 0;
        int pro2 = 0;
        for(int price : prices) {
            buy1 = Math.min(buy1, price);
            pro1 = Math.max(pro1, price - buy1);
            buy2 = Math.min(buy2, price - pro1);
            pro2 = Math.max(pro2, price - buy2);
        }
        return pro2;
    }
}
