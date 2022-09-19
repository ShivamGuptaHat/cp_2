package iiita.ADA.matrix;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int N = 5;
        int[][] matrix = new int[N][N];
        int R = 3;
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < N; i++){
            matrix[i] = Arrays.stream(in.nextLine().split(" ")).mapToInt(val -> Integer.parseInt(val)).toArray();
        }

        double[][] res = f(matrix, R);
        for (int i = 0; i < res.length; i++){
            for (int j = 0; j  < res[i].length; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double[][] f(int[][] M, int R){
        int N = M.length;
        int rn = N - R + 1;
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                dp[i + 1][j + 1] = M[i][j] + dp[i + 1][j] + dp[i][j + 1] - dp[i][j];
            }
        }

        double[][] ans = new double[N - rn + 1][N - rn + 1];
        int div = rn * rn;
        for (int i = rn, ii = 0; i <= N; i++, ii++){
            for (int j = rn, jj = 0; j <= N; j++, jj++){
                ans[ii][jj] = (dp[i][j] - dp[i - R][j] - dp[i][j - R] + dp[i - R][j - R]) * 1.0 / div;
            }
        }
        return ans;
    }
}
