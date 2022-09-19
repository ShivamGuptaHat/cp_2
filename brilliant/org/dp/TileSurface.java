package brilliant.org.dp;

public class TileSurface {
    public static void main(String[] args) {
        System.out.println(t(10));
    }
    static int t(int N){
        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; ++i){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }
}
