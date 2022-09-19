package dynamic_problems.Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;


public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cost = 0;
        int hold = -prices[0];
        for(int i = 1; i < prices.length; i++){
            cost = Math.max(cost, hold + prices[i] - fee);
            hold = Math.max(hold, cost - prices[i]);
        }
        return cost;
    }
}