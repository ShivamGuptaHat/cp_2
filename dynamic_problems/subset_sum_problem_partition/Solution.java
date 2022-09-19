package dynamic_problems.subset_sum_problem_partition;

import java.util.*;

class Solution {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        while(q-- > 0){
            int n = in.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = in.nextInt();
            }

            boolean isYes = solve(nums);
            System.out.println(isYes ? "YES" : "NO");
        }
    }

    public static boolean solve(int[] nums){
        if(nums == null || nums.length == 0)
            return true;

        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0)
            return false;

//        return solve(nums, 0,  sum / 2, 0);
        return bottomUP(nums, sum / 2);
    }

    public static boolean solve(int[] nums, int res, int target, int idx){
        if(res > target)
            return false;

        if(res == target)
            return true;

        if(idx == nums.length)
            return false;

        return solve(nums, res + nums[idx], target, idx + 1) || solve(nums, res, target, idx + 1);
    }

    public static boolean bottomUP(int[] nums, int target){
        boolean[][] dp = new boolean[target + 1][nums.length + 1];

        for(int j = 0; j < dp[0].length; j++){
            dp[0][j] = true;
        }

        for (int i = 1; i < dp.length; i++){
            dp[i][0] = true;
        }

        for (int i = 1; i < dp.length; i++){
            for (int j = 0; j < nums.length; j++){
                if(nums[j] <= target){
                    dp[i][j + 1] = dp[i][j] || dp[i - nums[j]][j];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

}