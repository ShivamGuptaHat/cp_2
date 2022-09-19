package dynamic_problems.Ones_and_Zeroes_LEETCODE_STAR;

//Idea: knapsack 0/1 problem using 3D array.
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        BinaryData[] binaryData = new BinaryData[strs.length];
        fillWithBinary(binaryData, strs);
        return findMaxForm(binaryData, m, n);
    }

    public int findMaxForm(BinaryData[] binaryData, int m , int n){
        int[][][] dp = new int[binaryData.length + 1][m + 1][n + 1];
        for(int i = 0; i < dp[0].length; i++){
            for(int j = 0; j < dp[0][0].length; j++){
                dp[0][i][j] = 0;
            }
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j <= m; j++){
                for(int k = 0; k <= n; k++){
                    if(j >= binaryData[i - 1].zero && k >= binaryData[i - 1].one){
                        dp[i][j][k] = Math.max(dp[i - 1][j - binaryData[i - 1].zero][k - binaryData[i - 1].one] + 1, dp[i - 1][j][k]);
                    }else{
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[dp.length - 1][m][n];
    }

    private void fillWithBinary(BinaryData[] binaryData, String[] strs){
        for(int i = 0; i < strs.length; i++){
            int zero = 0;
            int one = 0;
            for(int j = 0; j < strs[i].length(); j++){
                if(strs[i].charAt(j) == '0')
                    zero++;
                else
                    one++;
            }
            binaryData[i] = new BinaryData(zero, one);
        }
    }
}

class BinaryData{
    public int zero;
    public int one;
    public BinaryData(int zero, int one){
        this.zero = zero;
        this.one = one;
    }
}