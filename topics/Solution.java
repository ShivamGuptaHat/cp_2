package topics;

import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return ans;

        int p = (int)Math.pow(2, nums.length);

        for (int i = 0; i < p; i++){
            List<Integer> t = new ArrayList<>();
            for (int j = 0; j < nums.length; j++){
                if((i & (1 << j)) != 0){
                    t.add(nums[j]);
                }
            }
            ans.add(t);
        }
        return ans;
    }
}
