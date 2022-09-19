package tree_problems.depth_and_number_of_nodes_of_ith_node;

import java.util.*;

public class Solution {
    public static Vertex[] graph;
    public static boolean[] isVisited;
    public static int N;
    public static int[] depth;
    public static int[] subStreeChilds;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        int E = N - 1;
        graph = new Vertex[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new Vertex();
        }
        depth = new int[N + 1];
        subStreeChilds = new int[N + 1];
        isVisited = new boolean[N + 1];
        for(int i = 0; i < E; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            graph[u].adj.add(v);
            graph[v].adj.add(u);
        }

        bfs(1);
        dfs(1);
        for(int i = 1; i <= N; i++){
            System.out.println("Depth " + i + " " + depth[i]);
        }

        for(int i = 1; i <= N; i++){
            System.out.println("Children " + i + " "+ subStreeChilds[i]);
        }
    }

    //depth
    public static void bfs(int s){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        depth[s] = 0;
        isVisited[s] = true;

        while(!queue.isEmpty()){
            int u = queue.remove();
            for(int v : graph[u].adj){
                if(!isVisited[v]){
                    depth[v] = depth[u] + 1;
                    isVisited[v] = true;
                    queue.add(v);
                }
            }
        }

        Arrays.fill(isVisited, false);
    }

    //subtreeChild
    public static int dfs(int s){
        int count = 0;
        isVisited[s] = true;
        for(int v : graph[s].adj){
            if(!isVisited[v]){
                count += dfs(v);
            }
        }
        subStreeChilds[s] = count + 1;
        return count + 1;
    }
}


class Vertex{
    ArrayList<Integer> adj = new ArrayList<>();
}
