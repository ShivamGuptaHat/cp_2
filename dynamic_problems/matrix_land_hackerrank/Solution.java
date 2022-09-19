package dynamic_problems.matrix_land_hackerrank;


import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int m = in.nextInt();
        
        int[][] mat = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                mat[i][j] = in.nextInt();
            }
        }

        long res = solve(mat);
        System.out.println(res);
    }

    private static long solve(int[][] mat) {
        if(mat == null || mat.length == 0)
            return 0L;

        int n = mat.length;
        int m = mat[0].length;

        int[] dp = null;
        long[] left = new long[m];
        long[] right = new long[m];
        long[] leftPlusUp = new long[m];
        long[] rightPlusUp = new long[m];
        long[] current = new long[m];
        long[] previous =  new long[m];


        for(int i = 0; i < n; i++){
            dp = mat[i];
            left[0] = 0;
            for(int j = 1; j < m; j++){
                left[j] = Math.max(left[j - 1] + dp[j - 1], 0);
            }

            right[m - 1] = 0;
            for(int j = m - 2; j >= 0; j--){
                right[j] = Math.max(right[j + 1] + dp[j + 1], 0);
            }

            leftPlusUp[0] = previous[0] + dp[0];
            for(int j = 1; j < m; j++){
                leftPlusUp[j] = Math.max(left[j] + dp[j] + previous[j], leftPlusUp[j - 1] + dp[j]);
            }

            rightPlusUp[m - 1] = previous[m - 1] + dp[m - 1];
            for(int j = m - 2; j >= 0; j--){
                rightPlusUp[j] = Math.max(right[j] + dp[j] + previous[j], rightPlusUp[j + 1] + dp[j]);
            }

            for(int j = 0; j < m; j++){
                current[j] = Math.max(leftPlusUp[j] + right[j], rightPlusUp[j] + left[j]);
            }

            long[] temp = previous;
            previous = current;
            current = temp;
        }
        long res = 0L;
        for(int i = 0; i < previous.length; i++){
            res = Math.max(previous[i], res);
        }
        return res;
    }
}
