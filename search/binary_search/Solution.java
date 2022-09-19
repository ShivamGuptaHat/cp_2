package search.binary_search;

import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
          nums[i] = in.nextInt();
        }
        int pos = binarySearch(nums, in.nextInt());
        System.out.println(pos);
    }

    private static int binarySearch(int[] nums, int k) {
        int l = 0;
        int r = nums.length;
        int mid = 0;
        while(r - l > 1){
            mid = (l + r) >> 1;
            if(nums[mid] <= k){
                l = mid;
            }else{
                r = mid;
            }
        }
        return l;
    }


}
