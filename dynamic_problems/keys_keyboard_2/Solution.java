package dynamic_problems.keys_keyboard_2;

import java.util.Scanner;

//idea: How to divide problem into subproblems of maximum and equal size.

class Solution {
    public int minSteps(int n) {
        if(n <= 1)
            return 0;

        if(n == 2)
            return 2;

        if(n == 3)
            return 3;

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 2;
        dp[3] = 3;

        for(int i = 4; i <= n; i++){
            if(i % 2 != 0){
                int h = highestFactor(i);
                dp[i] = dp[h] + i / h;
            }else{
                dp[i] = dp[i / 2] + 2;
            }
        }
        return dp[n];
    }

    private int highestFactor(int num) {
        for(int i = num - 1; i > 0; i--){
            if(num % i == 0)
                return i;
        }
        return 1;
    }
}