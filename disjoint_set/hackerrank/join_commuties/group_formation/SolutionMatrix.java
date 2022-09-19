package disjoint_set.hackerrank.join_commuties.group_formation;

import java.util.*;

public class SolutionMatrix{
    static int[][] matrix;
    static Map<String, Integer> map;
    static int[] parent;
    static int maxSize = 0;

    static void membersInTheLargestGroups(int n, int m, int a, int b, int f, int s, int t) {
        matrix = new int[n][3];
        map = new HashMap<>();
        parent = new int[n];

        for (int i = 0; i < n; i++){
            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            int grade = Integer.parseInt(tokens[1]) - 1;
            parent[i] = i;
            map.put(name, i);
            matrix[i][grade] = 1;
        }

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        while(m-- > 0){
            String[] names = scanner.nextLine().split(" ");
            int p = map.get(names[0]);
            int q = map.get(names[1]);
            union(p, q, a, b, f, s, t);
        }

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        if(maxSize == 0 || maxSize < a) {
            System.out.println("no groups");
            return;
        }

        List<String> res = new ArrayList<>();
        for (String name : map.keySet()){
            int id = map.get(name);
            int par = find(id);
            if(matrix[par][0] + matrix[par][1] + matrix[par][2] == maxSize){
                res.add(name);
            }
        }

        Collections.sort(res);
        if(res.size() == 0){
            System.out.println("no groups");
        }
        for(String name : res){
            System.out.println(name);
        }

    }

    static void union(int p, int q, int a, int b, int f, int s, int t){
        int pParent = find(p);
        int qParent = find(q);
        if(pParent == qParent)
            return;

        int pSize = matrix[pParent][0] + matrix[pParent][1] + matrix[pParent][2];
        int qSize = matrix[qParent][0] + matrix[qParent][1] + matrix[qParent][2];

        if(pSize + qSize > b || matrix[pParent][0] + matrix[qParent][0] > f || matrix[pParent][1] + matrix[qParent][1] > s || matrix[pParent][2] + matrix[qParent][2] > t)
            return;

        maxSize = Math.max(maxSize, pSize + qSize);

        if(pSize < qSize){
            matrix[qParent][0] += matrix[pParent][0];
            matrix[qParent][1] += matrix[pParent][1];
            matrix[qParent][2] += matrix[pParent][2];
            parent[pParent] = qParent;
        }else{
            matrix[pParent][0] += matrix[qParent][0];
            matrix[pParent][1] += matrix[qParent][1];
            matrix[pParent][2] += matrix[qParent][2];
            parent[qParent] = pParent;
        }
    }

    static int find(int p){
        int r = p;
        while(p != parent[p]){
            p = parent[p];
        }

        while(p != r){
            int temp = parent[r];
            parent[r] = p;
            r = temp;
        }
        return r;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nmabfst = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nmabfst[0]);

        int m = Integer.parseInt(nmabfst[1]);

        int a = Integer.parseInt(nmabfst[2]);

        int b = Integer.parseInt(nmabfst[3]);

        int f = Integer.parseInt(nmabfst[4]);

        int s = Integer.parseInt(nmabfst[5]);

        int t = Integer.parseInt(nmabfst[6]);

        membersInTheLargestGroups(n, m, a, b, f, s, t);

        scanner.close();
    }
}

