package dynamic_problems.minimum_operation_geeksforgeeks;

public class Solution {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(solve(n));
    }
    public static int solve(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            if(i % 2 != 0){
                dp[i] = 1 + dp[i - 1];
            }else{
                dp[i] = dp[i % 2] + dp[i / 2];
            }
        }
        return dp[n];
    }
}
