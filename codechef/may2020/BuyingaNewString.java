package codechef.may2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

class BuyingaNewString {
    static private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static private PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception{
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String A = in.readLine();
            String B = in.readLine();
            int N = Integer.parseInt(in.readLine());
            List<Pair> fav = new ArrayList<>();
            for(int i = 0; i < N; i++){
                String[] inp = in.readLine().split(" ");
                fav.add(new Pair(inp[0], Integer.parseInt(inp[1])));
            }

            int ans = f(A, B, fav);
            System.out.println(ans);
        }
    }

    static int f(String A, String B, List<Pair> data){
        int max = -1;
        for (int i = A.length() - 1; i >= 0; i--){
            for (int j = 0; j < B.length(); j++){
                max = Math.max(max, r(A.substring(0, i + 1) + B.substring(j), data));
            }
        }
        return max;
    }

    static int r(String C, List<Pair> data){
        int ans = 0;
        for (Pair p : data){
            ans += s(p.s, C) * p.b;
        }
        return ans;
    }

    static int s(String pat, String C){
        int count = 0;
        int patlen = pat.length();
        for (int i = 0; i < C.length() - pat.length() + 1; i++){
            if(C.substring(i, i + patlen).equals(pat)){
                count++;
            }
        }
        return count;
    }
}

class Pair{
    String s;
    int b;
    public Pair(String s, int b){
        this.s = s;
        this.b = b;
    }
}