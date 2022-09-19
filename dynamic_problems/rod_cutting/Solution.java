package dynamic_problems.rod_cutting;


class Solution{
    public static void main(String[]args){
        int[] price = {0, 1, 5, 8, 9};
        //int revenue = rodCutting(price, 4);
        int revenue = bottomUP(price, 4);
        System.out.println(revenue);
    }

    //recursive approach

    public static int rodCutting(int[] price, int length){
        if(length == 0)
            return 0;
        else{
            int max = Integer.MIN_VALUE;
            for(int i = 1; i <= length; i++){
                max = Math.max(max, price[i] + rodCutting(price, length - i));
            }
            return max;
        }
    }

    //Memoized solution
    public static int memoizedRodCutting(int[] price, int length){
        int[] memory = new int[price.length];
        for(int i = 0; i < memory.length; i++){
            memory[i] = Integer.MIN_VALUE;
        }
        return memoizedRodCurttingAUX(price, length, memory);
    }

    private static int memoizedRodCurttingAUX(int[] price, int length, int[] memory){
        if(memory[length] >= 0)
            return memory[length];
        else if(length == 0)
            return 0;
        else{
            int max = Integer.MIN_VALUE;
            for(int i = 1; i <= length; i++){
                max = Math.max(max, price[i] + memoizedRodCurttingAUX(price, length - i, memory));
            }
            memory[length] = max;
            return max;
        }
    }

    //dynamic programming

    public static int bottomUP(int[] prices, int N){
        int max = 0;
        int[] dp = new int[N + 1];
        dp[0] = 0;
        for(int i = 1; i <= N; i++){
            max = 0;
            for(int j = 1; j <= i; j++){
                max = Math.max(max, prices[j] + dp[i - j]);
            }
            dp[i] = max;
        }
        return dp[N];
    }
}