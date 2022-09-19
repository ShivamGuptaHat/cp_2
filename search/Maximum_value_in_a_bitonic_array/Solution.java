package search.Maximum_value_in_a_bitonic_array;

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    //10 20 30 25 15 2
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0){
            int n = in.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = in.nextInt();
            }

            int res = binarySearch(nums);
            System.out.println(res);
        }
    }

    public static int binarySearch(int[] nums){
        if(nums.length == 1){
            return nums[0];
        }

        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while(l < r){
            mid = (l + r) >> 1;
            if(mid > 0 && mid < nums.length - 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                return nums[mid];
            }
            if(mid > 0 && mid < nums.length - 1 && nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]){
                r = mid -1;
            }else{
                l = mid + 1;
            }
        }
        return nums[l];
    }
}