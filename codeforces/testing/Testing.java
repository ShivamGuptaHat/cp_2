package codeforces.testing;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Testing {
    public static void main(String[] args) throws Exception{
        BufferedReader ir = new BufferedReader(new FileReader("src/codeforces/testing/input.txt"));
        BufferedReader or = new BufferedReader(new FileReader("src/codeforces/testing/output.txt"));
        String ss = "";
        while((ss = ir.readLine()) != null){
            if(!ss.equals(or.readLine().toString())){
                System.out.println(ss);
                break;
            }
        }
    }
}
