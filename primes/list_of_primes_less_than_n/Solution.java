package primes.list_of_primes_less_than_n;

import java.util.*;

public class Solution {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        System.out.println(lp(10));
    }

    public static List<Integer> lp(int n){
        boolean[] l = new boolean[n + 1];
        Arrays.fill(l, true);
        l[0] = l[1] = false;
        for (int i = 2; i * i <= n; ++i){
            if(l[i]){
                for (int j = i * i; j <= n; j += i){
                    l[j] = false;
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 2; i <= n; ++i){
            if(l[i])
                ans.add(i);
        }
        return ans;
    }
}
