package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

class Solution {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws Exception{
        try{
           int t = Integer.parseInt(in.readLine());
           nextTest:
           while(t-- > 0){
               String[] inp = in.readLine().split(" ");

               int N = Integer.parseInt(inp[0]);
               int K = Integer.parseInt(inp[1]);
               int[] nums = new int[N + 1];

               inp = in.readLine().split(" ");
               Set<Integer> set = new HashSet<>();
               for (int i = 1; i <= N; i++) {
                   nums[i] = Integer.parseInt(inp[i - 1]);
                   if(nums[i] != i){
                       set.add(i);
                   }
               }

               int qk = 0;
               List<int[]> ans = new ArrayList<>();
               int i;
               for (i = 1; i <= N; i++) {
                   if (i != nums[i]) {
                       if (qk == K){
                           System.out.println("-1");
                           continue nextTest;
                       }

                       //find indices
                       int i1 = i;
                       int i2 = nums[i];
                       int i3 = nums[i2];
                       if (i1 == i3) {
                           boolean isfound = false;
                           for (int ii = i + 1; ii <= N; ii++) {
                               if (nums[ii] != ii && ii != i1 && ii != i2) {
                                   i3 = ii;
                                   isfound = true;
                                   break;
                               }
                           }

                           if (!isfound) {
                               System.out.println("-1");
                               continue nextTest;
                           }
                       }

                       //rotation
                       while (qk + 1 <= K && nums[i1] != i1 && nums[i2] != i2 && nums[i3] != i3) {
                           int temp = nums[i3];
                           nums[i3] = nums[i2];
                           nums[i2] = nums[i1];
                           nums[i1] = temp;
                           ans.add(new int[]{i1, i2, i3});
                           qk++;
                       }
                       if(nums[i] != i)
                        i--;
                   }
               }

               //output
               if(i - 1 == N){
                   System.out.println(qk);
                   for (int[] idx : ans){
                       System.out.println(idx[0] + " " + idx[1] + " " + idx[2]);
                   }
               }else{
                   System.out.println("-1");
               }
           }
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    static boolean isSorted(int[] nums){
        for (int i = 1; i < nums.length; i++){
            if(i != nums[i])
                return false;
        }
        return true;
    }
}