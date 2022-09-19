package advance_tree.fenwick_tree;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }

        FenwickTree fenwickTree = new FenwickTree(nums);
        int q = in.nextInt();
        while(q-- > 0){
            int to = in.nextInt();
            int res = fenwickTree.getSum(to, n);
            System.out.println(res);
        }
    }
}


class FenwickTree{
    int size;
    int[] ftree;
    public FenwickTree(int[] nums){
        size = nums.length + 1;
        ftree = new int[size];
        /*
        for(int i = 0; i < ftree.length; i++){
            ftree[i] = 0;
        }
        */
        init(nums);
    }

    public void init(int[] nums){
        for(int i = 0; i < nums.length; i++){
            update(i, nums[i], nums.length);
        }
    }

    public void update(int idx, int val, int n){
        idx += 1;
        while(idx <= n){
            ftree[idx] += val;
            idx += (idx & (-idx));
        }
    }

    public int getSum(int idx, int n){
        int sum = 0;
        idx += 1;
        while(idx > 0){
            sum += ftree[idx];
            idx -= (idx & (-idx));
        }
        return sum;
    }
}
