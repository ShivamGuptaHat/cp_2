package dynamic_problems.maximum_length_of_repeated_subarray;

import java.util.Scanner;

//problem: find max length of subarray which is common in both.
//Idea : Store previous operation result.


class Solution{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] A = new int[in.nextInt()];
        for(int i = 0; i < A.length; i++){
            A[i] = in.nextInt();
        }

        int[] B = new int[in.nextInt()];
        for(int i = 0; i < B.length; i++){
            B[i] = in.nextInt();
        }

        int res = new Solution().findLength(A, B);
        System.out.println(res);

    }

    public int findLength(int[] A, int[] B){
        int[][] dp = new int[A.length + 1][B.length + 1];
        int max = 0;
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(A[i - 1] == B[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}