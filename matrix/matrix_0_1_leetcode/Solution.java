package matrix.matrix_0_1_leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] mat = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                mat[i][j] = in.nextInt();
            }
        }
        int[][] res = new Solution().updateMatrix(mat);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    boolean[][] isVisited;
    public int[][] updateMatrix(int[][] matrix) {
        isVisited = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    isVisited[i][j] = true;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 1 && !isVisited[i][j]){
                    bfs(i, j, matrix);
                }
            }
        }
        return matrix;
    }

    public void bfs(int r, int c, int[][] mat){
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{r, c});
        int[] rows = {-1,0,1,0};
        int[] cols = {0,1,0,-1};
        isVisited[r][c] = true;

        while(!queue.isEmpty()){
            int[] adr = queue.remove();
            int min = mat[adr[0]][adr[1]];

            for(int i = 0; i < 4; i++){
                int rw = adr[0] + rows[i];
                int cl = adr[1] + cols[i];
                if(rw >= 0 && cl >= 0 && rw < mat.length && cl < mat[0].length)
                    min = Math.min(min, mat[rw][cl]);
                if(isValid(rw, cl, mat)){
                    isVisited[rw][cl] = true;
                    queue.add(new int[]{rw, cl});
                }
            }
            mat[adr[0]][adr[1]] = min + 1;
        }
    }

    public boolean isValid(int r, int c, int[][] matrix){
        if(r >= 0 && c >= 0 && r < matrix.length && c < matrix[0].length && !isVisited[r][c])
            return true;
        else
            return false;
    }
}
