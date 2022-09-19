package dynamic_problems.coin_change_count_coins_leetcode;

import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] coins = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = in.nextInt();
        }
        int res = new Solution().coinChange(coins, in.nextInt());
        System.out.println(res);

    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0 && dp[i - coins[j]] != -1){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
            dp[i] = dp[i] == Integer.MAX_VALUE ? -1 : dp[i];
        }
        return dp[amount];
    }
}
