package matrix.max_path_sum_in_matrix.Solution;

import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0){
            int n = in.nextInt();
            int k = in.nextInt();

            int ans = 0;
            if(k == 1)
                ans = f1(n - 1) - 1;
            else if(k == 2)
                ans = f2(n - 1) - 1;
            else if(k == 3)
                ans = f3(n - 1) - 1;
            else if(k == 4)
                ans = f4(n - 1) - 1;
            else if(k == 5)
                ans = f5(n - 1) - 1;
            else if(k == 6)
                ans = f6(n - 1) - 1;
            System.out.println(ans);
        }
    }

    public static int f1(int n){
        return (n * (n + 1)) / 2;
    }

    public static int f2(int n){
        return (n * (n + 1) * (2 * n + 1))/6;
    }
    public static int f3(int n){
        return (int)Math.pow((int)((n * (n + 1)) / 2), 2);
    }

    public static int f4(int n){
        return (n * (n + 1) * (2 * n + 1) * (3 * pow(n, 2) + 3 * n - 1)) / 30;
    }

    public static int f5(int n){
        return pow((n * (n + 1)),2) * (2 * pow(n, 2) + 2 * n - 1)/ 12;
    }

    public static int f6(int n){
        return n * (n + 1) * (2 * n + 1) * (3 * pow(n, 4) + 6 * pow(n, 3) - 3 * n + 1) / 42;
    }

    public static int pow(int a, int b){
        return new Double(Math.pow(a, b)).intValue();
    }
}
