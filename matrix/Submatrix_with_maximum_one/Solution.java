package matrix.Submatrix_with_maximum_one;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0){
            int m = in.nextInt();
            int n = in.nextInt();

            int[][] matrix = new int[m][n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    matrix[i][j] = in.nextInt();
                }
            }

            solve(matrix);
        }
    }

    public static void solve(int[][] mat){
        int[][] dp = new int[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++){
            dp[i][0] = mat[i][0];
        }

        for(int j = 0; j < mat[0].length; j++){
            dp[0][j] = mat[0][j];
        }



        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j  < dp[0].length; j++){
                if(mat[i][j] != 0)
                    dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1]) + 1;
                else
                    dp[i][j] = 0;
            }
        }

        int maxSize = dp[0][0];
        int r = 0;
        int c = 0;

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(maxSize < dp[i][j]){
                    maxSize = dp[i][j];
                    r = i;
                    c = j;
                }
            }
        }
        System.out.println(maxSize);
    }

    public static int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}