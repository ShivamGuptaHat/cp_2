package backtracking.beautiful_arrangement_Leetcode;

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.println(new Solution().countArrangement(N));
    }

    public int count = 0;
    public int countArrangement(int N) {
        int[] nums = new int[N + 1];
        for(int i = 1; i <= N; i++){
            nums[i] = i;
        }
        permute(nums, 1);
        return count;
    }

    public void permute(int[] nums, int s){
        if(s == nums.length) {
            count++;
            return;
        }

        for(int i = s; i < nums.length; i++){
            swap(nums, s, i);
            if(nums[s] % s == 0 || s % nums[s] == 0){
                permute(nums, s + 1);
            }
            swap (nums, s, i);
        }
    }

    private void swap(int[] nums, int s, int i) {
        int t = nums[s];
        nums[s] = nums[i];
        nums[i] = t;
    }
}