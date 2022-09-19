package topics.subsets.perfect_sum;

import java.util.*;
import java.lang.*;

class Solution {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        while(q-- > 0){
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++){
                nums[i] = in.nextInt();
            }

            int t = in.nextInt();
            int res = solve(nums, t);
            System.out.println(res);
        }
    }

    static int solve(int[] nums, int t){
        return solve(nums, t, 0, 0);
    }

    static int solve(int[] nums, int t, int sum, int idx){
        if(sum == t)
            return 1;
        if(idx == nums.length)
            return 0;
        return solve(nums, t, sum + nums[idx], idx + 1) + solve(nums, t, sum, idx + 1);
    }
}