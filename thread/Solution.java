package thread;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    // Complete the solve function below.
    static int solve(int[] c) {
        int mod = 1000000007;
        int res = 1;
        Arrays.sort(c);
        for (int p = 1; p <= c.length; p++){
            int count = 0;
            for (int i = p - 1; i < c.length; i++){
                if(c[i] < p){
                    count++;
                }else if(c[i] >= p){
                    break;
                }
            }
            res = (int)((1L * res * count ) % mod);
            if(res == 0)
                return 0;
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        while(q-- > 0){
            int n = scanner.nextInt();
            int[] c = new int[n];
            for (int i = 0; i < n; i++){
                c[i] = scanner.nextInt();
            }
            System.out.println(solve(c));
        }
    }
}
