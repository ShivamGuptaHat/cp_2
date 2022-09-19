package bit_manipulation;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        PriorityQueue<Distance> pq = new PriorityQueue<>();
        pq.offer(new Distance(14));
        pq.offer(new Distance(5));
        pq.offer(new Distance(29));

        while (!pq.isEmpty()){
            System.out.println(pq.remove().distance);
        }
    }
}

class Distance implements Comparable<Distance>{
    int distance;
    public Distance(int d){
        distance = d;
    }

    public int compareTo(Distance d){
        return d.distance - this.distance;
    }
}
