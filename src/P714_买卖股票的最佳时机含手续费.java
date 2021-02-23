public class P714_买卖股票的最佳时机含手续费 {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0;       //手中的钱
        int shenyu = -prices[0];        //买了当天股票后剩余的钱

        for(int i = 1; i < prices.length; i++) {
            // 一次买入卖出
//            shenyu = Math.max(shenyu, -prices[i]);
//            cash = Math.max(cash, shenyu + prices[i] - fee);

            // 无限次买入卖出
            cash = Math.max(cash, shenyu + prices[i] - fee);    //保持最大余额
            shenyu = Math.max(shenyu, cash - prices[i]);    //保持买入股票后的最大余额
        }
        return cash;
    }
}
