
package brilliant.org.dp;

public class FullBinaryTree {
    public static void main(String[] args) {
        System.out.println(f(3));
    }

    static int f(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; ++i){
            for (int ii = 0; ii <= i - 1; ++ii){
                dp[i] += dp[ii] * dp[i - 1 - ii];
            }
        }
        return dp[n];
    }
}

