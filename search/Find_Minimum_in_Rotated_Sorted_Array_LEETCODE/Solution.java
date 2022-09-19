package search.Find_Minimum_in_Rotated_Sorted_Array_LEETCODE;

import java.util.Scanner;

class Solution {
    //4 5 6 7 0 1 2
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0){
            int n = in.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = in.nextInt();
            }

            int res = findMin(nums);
            System.out.println(res);
        }
    }

    public static int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while(l < r){
            mid = (l + r) >> 1;
            if(mid > 0 && nums[mid] < nums[mid - 1]){
                return nums[mid];
            }
            if(nums[mid] > nums[l] && nums[mid] > nums[r]){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return nums[l];
    }
}