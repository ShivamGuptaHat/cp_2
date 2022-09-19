package game.sudoku;

import java.util.Scanner;
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int t = in.nextInt();
        int[][] sudoku = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                sudoku[i][j] = in.nextInt();
            }
        }

        sudokuSolver(sudoku, t);
        System.out.println();

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    //9 X 9 Sudoku
    public static boolean sudokuSolver(int[][] sudoku, int t){
        for(int i = 0; i < sudoku.length; i++){
            for(int j = 0; j < sudoku[0].length; j++){
                if(sudoku[i][j] == 0){
                    for(int k = 1; k <= sudoku.length; k++){
                        if(isValid(sudoku, i, j, k, t)){
                            sudoku[i][j] = k;

                            if(sudokuSolver(sudoku, t)){
                                return true;
                            }else{
                                sudoku[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(int[][] sudoku, int i, int j, int k, int t){
        for(int s = 0; s < sudoku.length; s++){
            if(sudoku[i][s] != 0 && sudoku[i][s] == k){
                return false;
            }
            if(sudoku[s][j] != 0 && sudoku[s][j] == k){
                return false;
            }

            if(sudoku[t * (i / t) + s / t][t * (j / t) + s % t] != 0 && sudoku[t * (i / t) + s / t][t * (j / t) + s % t] == k){
                return false;
            }
        }
        return true;
    }

}
