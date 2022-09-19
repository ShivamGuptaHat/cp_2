package graph.geeksforgeeks.Bellman_ford;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static int vertices;
    private static int edges;
    private static int[][] graph;

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        vertices = in.nextInt();
        edges = in.nextInt();
        graph = new int[vertices][vertices];
        for(int i = 0; i < edges; i++){
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            int w = in.nextInt();
            graph[u][v] = w;
        }

        int[] distance = bellmanFord(graph);
        for(int i = 0; i < distance.length; i++){
            System.out.println(distance[i]);
        }
    }

    public static int[] bellmanFord(int[][] graph){
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        for(int i = 1; i < vertices; i++){
            for(int u = 0; u < vertices; u++){
                if(distance[u] == Integer.MAX_VALUE)
                    continue;;

                for(int v = 0; v < vertices; v++){
                    if(u != v && graph[u][v] != 0){
                        if(distance[v] > distance[u] + graph[u][v]){
                            distance[v] = distance[u] + graph[u][v];
                         }
                    }
                }
            }
        }
        return distance;
    }
}


