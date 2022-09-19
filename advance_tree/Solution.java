package advance_tree;

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0){
            int m = in.nextInt();
            int n = in.nextInt();
            int[][] mat = new int[m][n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    mat[i][j] = in.nextInt();
                }
            }

            int[] res = solve(mat);
            System.out.println(res[0] + " " + res[1]);
        }
    }

    public static int[] solve(int[][] mat){
        int i = 0, j = 0;
        int m = mat.length;
        int n = mat[0].length;
        char dir = 'R';
        while(true){
            if(mat[i][j] == 0){
                if(dir == 'R'){
                    if(j + 1 < n){
                        j++;
                    }else{
                        return new int[]{i, j};
                    }
                }else if(dir == 'D'){
                    if(i + 1 < m){
                        i++;
                    }else{
                        return new int[]{i, j};
                    }
                }else if(dir == 'L'){
                    if(j - 1 >= 0){
                        j--;
                    }else{
                        return new int[]{i, j};
                    }
                }else if(dir == 'U'){
                    if(i - 1 >= 0){
                        i--;
                    }else{
                        return new int[]{i, j};
                    }
                }
            }else{
                if(dir == 'R'){
                    if(i + 1 < m){
                        mat[i][j] = 0;
                        i++;
                        dir = 'D';
                    }else{
                        return new int[]{i, j};
                    }
                }else if(dir == 'D'){
                    if(j - 1 >= 0){
                        mat[i][j] = 0;
                        j--;
                        dir = 'L';
                    }else{
                        return new int[]{i, j};
                    }
                }else if(dir == 'L'){
                    if(i - 1 >= 0){
                        mat[i][j] = 0;
                        i--;
                        dir = 'U';
                    }else{
                        return new int[]{i, j};
                    }
                }else if(dir == 'U'){
                    if(j + 1 < n){
                        mat[i][j] = 0;
                        j++;
                        dir = 'R';
                    }else{
                        return new int[]{i, j};
                    }
                }
            }
        }
    }
}