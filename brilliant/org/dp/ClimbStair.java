package brilliant.org.dp;

public class ClimbStair{
    public static void main(String[] args) {
        System.out.println(f(20));
    }

    public static int f(int N){
        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 8;
        for (int i = 5; i <= 20; ++i){
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]  + dp[i - 4];
        }
        return dp[N];
    }

}
