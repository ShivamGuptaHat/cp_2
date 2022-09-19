package solution;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(3,5);
        map.put(4, 7);
        map.remove(1);
        for (int key : map.keySet()){
            System.out.println(key + " " + map.get(key));
        }
    }
}