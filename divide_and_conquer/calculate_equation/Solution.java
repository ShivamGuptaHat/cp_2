package divide_and_conquer.calculate_equation;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        List<Integer> res = new Solution().diffWaysToCompute("2-1-1");
        for (int a : res){
            System.out.print(a + " ");
        }
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if(countSymbols(input) == 0){
            res.add(Integer.parseInt(input));
            return res;
        }
        if(countSymbols(input) == 1){
            res.add(performOperation(input));
            return res;
        }

        for (int i = 0; i < input.length(); i++){
            char sym = input.charAt(i);
            if(sym == '+' || sym == '-' || sym == '*'){
                List<Integer> l = diffWaysToCompute(input.substring(0, i));
                List<Integer> r = diffWaysToCompute(input.substring(i + 1));
                combine(l, r, res, sym);
            }
        }
        return res;
    }


    public int countSymbols(String s){
        int c = 0;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*'){
                c++;
            }
        }
        return c;
    }

    public int performOperation(String str){
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+') {
                res =  Integer.parseInt(str.substring(0, i) + "") + Integer.parseInt(str.substring(i + 1) + "");
            } else if (str.charAt(i) == '-') {
                res = Integer.parseInt(str.substring(0, i) + "") - Integer.parseInt(str.substring(i + 1) + "");
            } else if(str.charAt(i) == '*'){
                res = Integer.parseInt(str.substring(0, i)) * Integer.parseInt(str.substring(i + 1));
            }
        }
        return res;
    }

    public void combine(List<Integer> l, List<Integer>  r, List<Integer> ans, char symbol){
        for (int i = 0; i < l.size(); i++){
            for (int j = 0; j < r.size(); j++){
                if(symbol == '+'){
                    ans.add(l.get(i) + r.get(j));
                }else if(symbol == '-'){
                    ans.add(l.get(i) - r.get(j));
                }else{
                    ans.add(l.get(i) * r.get(j));
                }
            }
        }
    }
}