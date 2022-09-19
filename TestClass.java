
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int V = in.nextInt();
        int E = in.nextInt();

        int[][] G = new int[V + 1][V + 1];
        int[][] GT = new int[V + 1][V + 1];
        for (int i = 0; i < E; ++i){
            int u = in.nextInt();
            int v = in.nextInt();
            G[u][v] = 1;
            GT[v][u] = 1;
        }

        int res = scc(G, GT, V);
        System.out.println(res);
    }

    static int cs = 0;
    static int scc(int[][] G, int[][] GT, int V){
        boolean[] iv = new boolean[V + 1];
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= V; ++i){
            if(!iv[i]){
                cs = 0;
                dfs(G, iv, i, V, stack);
            }
        }

        Arrays.fill(iv, false);
        int C = 0;
        int D = 0;
        while(!stack.isEmpty()){
            int u = stack.pop();
            if(!iv[u]) {
                cs = 0;
                dfs(GT, iv, u, V);
                if(cs % 2 == 0){
                    D += cs;
                }else{
                    C += cs;
                }
            }
        }
        return C-D;
    }

    static void dfs(int[][] G, boolean[] iv, int src, int V, Stack<Integer> stack){
        iv[src] = true;
        for (int v = 1; v <= V; ++v){
            if(G[src][v] == 1 && !iv[v]){
                dfs(G, iv, v, V, stack);
            }
        }
        stack.push(src);
    }

    static void dfs(int[][] G, boolean[] iv, int src, int V){
        iv[src] = true;
        cs++;
        for (int v = 1; v <= V; ++v){
            if(G[src][v] == 1 && !iv[v]){
                dfs(G, iv, v, V);
            }
        }
    }
}
