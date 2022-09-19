package disjoint_set.hackerrank.join_commuties.group_formation;

import java.util.*;
import java.lang.*;

class Node{
    int id;
    int[] grade = new int[3];
    int total;
    Node parent;

    public Node(int id, int grade){
        this.id = id;
        this.grade[grade] = 1;
        this.total = 1;
        this.parent = this;
    }
}

public class Solution{
    static Map<String, Integer> nameMap = new HashMap<>();
    static Map<Integer, Node> nodeMap = new HashMap<>();
    static int max = 0;

    public static void union(int p, int q, int a, int b, int f, int s, int t){
        Node pParent = find(nodeMap.get(p));
        Node qParent = find(nodeMap.get(q));
        if(pParent.id == qParent.id)
            return;

        if(pParent.total + qParent.total > b || pParent.grade[0] + qParent.grade[0] > f || pParent.grade[1] + qParent.grade[1] > s || pParent.grade[2] + qParent.grade[2] > t)
            return;

        max = Math.max(max, pParent.total + qParent.total);

        if(pParent.total < qParent.total){
            qParent.grade[0] += pParent.grade[0];
            qParent.grade[1] += pParent.grade[1];
            qParent.grade[2] += pParent.grade[2];
            qParent.total = pParent.total + qParent.total;
            pParent.parent = qParent;
        }else{
            pParent.grade[0] += qParent.grade[0];
            pParent.grade[1] += qParent.grade[1];
            pParent.grade[2] += qParent.grade[2];
            pParent.total = pParent.total + qParent.total;
            qParent.parent = pParent;
        }
    }

    public static Node find(Node p){
        if(p == p.parent)
            return p;
        p.parent = find(p.parent);
        return p.parent;
    }

    public static void makeSet(int id, int grade){
        Node node = new Node(id, grade);
        nodeMap.put(id, node);
    }



    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] tokens = in.nextLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);
        int a = Integer.parseInt(tokens[2]);
        int b = Integer.parseInt(tokens[3]);
        int f = Integer.parseInt(tokens[4]);
        int s = Integer.parseInt(tokens[5]);
        int t = Integer.parseInt(tokens[6]);

        for (int i = 0; i < n; i++){
            tokens = in.nextLine().split(" ");
            String name = tokens[0];
            int grade = Integer.parseInt(tokens[1]) - 1;
            nameMap.put(name, i);
            Node node = new Node(i, grade);
            nodeMap.put(i, node);
        }

        while(m-- > 0){
            tokens = in.nextLine().split(" ");
            int p = nameMap.get(tokens[0]);
            int q = nameMap.get(tokens[1]);
            union(p, q, a, b, f, s, t);
        }

        if(max == 0 || max < a){
            System.out.println("no groups");
        }

        List<String> res = new ArrayList<>();
        for (String name : nameMap.keySet()){
            Node p = nodeMap.get(nameMap.get(name));
            Node parent = find(p);
            if(parent.total == max){
                res.add(name);
            }
        }

        if(res.size() == 0){
            System.out.println("no groups");
        }

        Collections.sort(res);
        for (String name : res){
            System.out.println(name);
        }
    }
}