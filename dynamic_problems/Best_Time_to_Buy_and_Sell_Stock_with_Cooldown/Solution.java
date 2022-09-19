package dynamic_problems.Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static int[] nums;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }
        int p = solve();
        System.out.println(p);
    }

    public static int solve(){
        return solve(0, 0, -1);
    }

    public static Map<String, Integer> map = new HashMap<>();
    public static int solve(int d, int what, int buy){
        String key = d + ":" + what;
        if(map.containsKey(key)){
            return map.get(key);
        }
        if(d >= nums.length){
            return 0;
        }


        int q = 0;

        for(int i = d; i < nums.length; i++){
            if(what == 0){
                q = Math.max(q, solve(i + 1, 1, nums[i]));
            }else{
                if(nums[i] > buy){
                    q = Math.max(q, (nums[i] - buy) + solve(i + 2, 0, -1));
                }
            }
        }
        map.put(key, q);
        return q;
    }
}
