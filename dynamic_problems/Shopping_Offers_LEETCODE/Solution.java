package dynamic_problems.Shopping_Offers_LEETCODE;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        List<Integer> price = new ArrayList(){
            {
                add(2); add(5);
            }
        };

        List<Integer> needs = new ArrayList(){
            {
                add(3); add(2);
            }
        };


        List<List<Integer>> specialOffers  = new ArrayList(){
            {
                add(new ArrayList(){
                    {
                        add(3); add(0); add(5);
                    }
                });

                add(new ArrayList(){
                    {
                        add(1); add(2); add(10);
                    }
                });
            }
        };

        System.out.println(new Solution().shoppingOffers(price, specialOffers, needs));
    }

    public Map<List<Integer>, Integer> memo = new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return shopping(price, special, needs);
    }

    public int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs){
        if(memo.containsKey(needs))
            return memo.get(memo.get(needs));

        int res = cost(price, needs);
        for(List<Integer> offer : special){
            List<Integer> clone = new ArrayList<>(needs);
            int j = 0;
            for(j = 0; j < clone.size(); j++){
                int diff = clone.get(j) - offer.get(j);
                if(diff < 0)
                    break;
                clone.set(j, diff);
            }
            if(j == clone.size())
                res = Math.min(res, offer.get(j) + shopping(price, special, clone));
        }
        memo.put(needs, res);
        return res;
    }

    private int cost(List<Integer> price, List<Integer> needs) {
        int sum = 0;
        for(int i = 0; i < needs.size(); i++){
            sum += price.get(i) * needs.get(i);
        }

        return sum;
    }


}