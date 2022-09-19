package iiita.ADA.stack;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        stack.push(3); stack.push(1); stack.push(2);
        sort(stack);
        while(stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

    public static void sort(Stack<Integer> stack){
        Stack<Integer> tstack = new Stack<>();
        tstack.push(Integer.MAX_VALUE);
        int n = stack.size();
        for (int i = n; i >= 1; i--){
            for (int j = 1; j <= i; j++){
                int temp = stack.pop();
                if(temp < tstack.peek()){
                    tstack.push(temp);
                }else{
                    int tt = tstack.pop();
                    tstack.push(temp);
                    tstack.push(tt);
                }
            }
            while(tstack.size() > 1){
                stack.push(tstack.pop());
            }
        }
    }
}
