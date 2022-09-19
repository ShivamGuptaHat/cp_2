import java.util.*;

public class Testing {
    public static void main(String[] args) {
        Random random = new Random();
        Map<Integer, int[]> map = new HashMap<>();
        for  (int i = 0; i < 3; i++){
            int[] arr = new int[3];
            for (int j = 0; j < 3; j++){
                arr[j] = (int)random.nextInt(1000);
            }
            map.put(i, arr);
        }
        for (int k : map.keySet()){
            for (int i = 0; i < 3; i++){
                System.out.print(map.get(k)[i] + " ");
            }
            System.out.println();
        }
    }
}
