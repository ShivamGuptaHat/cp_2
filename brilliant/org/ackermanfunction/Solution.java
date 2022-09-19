package brilliant.org.ackermanfunction;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[]args)
    {
        int[][] mat = {{15,11,7},{5,19,9},{13,3,7}};
        System.out.println(ms(mat));
    }

    static int acker(int m, int n){ //acker
        if(m == 0) return n + 1;
        else if(m > 0 && n == 0) return acker(m - 1,  1);
        else if(m > 0 && n > 0) return acker(m - 1, acker(m, n - 1));
        return 0;
    }

    static double k(int w){ // knapsack example
        double ans = 0.0;
        for (int large = 0; large <= 3; ++large){
            for (int medium = 0; medium <= 5; ++medium){
                for (int small = 0; small <= 14; ++small){
                    for (int tiny = 0; tiny <= 20; ++tiny){
                        double t = large * 7 + medium * 3.4 + small * 1.10 + tiny * .77;
                        if(t <= w && ans < t){
                            ans = large * 7 + medium * 3.4 + small * 1.1 + tiny * .77;
                        }
                    }
                }
            }
        }
        return ans;
    }

    static boolean ms(int[][] mat){
        int sum = -1;
        for (int i = 0; i < mat.length; ++i){
            int temp = 0;
            for (int j = 0; j < mat[i].length; ++j){
                temp += mat[i][j];
            }
            if(sum == -1){
                sum = temp;
            }else if(sum != temp)
                return false;
        }

        for (int i = 0; i < mat.length; ++i){
            int temp = 0;
            for (int j = 0; j < mat[i].length; ++j){
                temp += mat[j][i];
            }
            if(sum == -1){
                sum = temp;
            }else if(sum != temp)
                return false;
        }

        int t1 = 0, t2 = 0;
        for (int i = 0; i < mat.length; ++i){
            t1 += mat[i][i];
            t2 += mat[i][mat.length - 1 - i];
        }

        return sum == t1 && sum == t2;
    }

    static int w(int n){
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= 100; ++i){
            q.add(i);
        }

        while(q.size() != 1){
            for (int i = 1; i <= 3; ++i){
                q.add(q.remove());
            }
            q.remove();
        }
        return q.remove();
    }
}
