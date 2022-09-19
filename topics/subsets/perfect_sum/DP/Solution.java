package topics.subsets.perfect_sum.DP;

import java.util.Scanner;

public class Solution {
    public static void main(String[]a){
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        while(q-- > 0){
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++){
                nums[i] = in.nextInt();
            }

            int sum = in.nextInt();
            int ans = solve(nums, sum);
            System.out.println(ans);
        }
    }

    static int solve(int[] nums, int sum){
        int[][] dp = new int[sum + 1][nums.length + 1];
        for (int j = 0; j < dp[0].length; j++){
            dp[0][j] = 1;
        }

        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[i].length; j++){
                dp[i][j] = dp[i][j - 1];
                if(nums[j - 1] <= i){
                    dp[i][j] += dp[i - nums[j - 1]][j - 1];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
