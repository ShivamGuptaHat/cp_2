package brilliant.org;

public class Solution {
    public static void main(String[] args) {
        int[] a = {121,432,222,124,768,789};
        a = radixsort(a, 3);
        for (int i = 0; i < a.length; ++i){
            System.out.print(a[i] + " ");
        }

    }

    static int[] radixsort(int[] a, int d){
        for (int i = 1; i <= d; ++i){
            a = countingsort(a, i);
        }
        return a;
    }


    static void print(int[] a){
        for (int i = 0; i <  a.length; ++i)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static int[] countingsort(int[] a, int d){
        int[] t = new int[10];
        t[0] = 1;
        for (int i = 1; i < t.length; ++i){
            t[i] = t[i - 1] * 10;
        }

        int[] C = new int[10];
        for (int i = 0; i < a.length; ++i){
            int tt = (a[i] % t[d]) / t[d - 1];
            C[tt]++;
        }

        for (int i = 1; i < C.length; ++i){
            C[i] += C[i - 1];
        }

        int[] B = new int[a.length];
        for (int i = a.length - 1; i >= 0; --i){
            int tt = (a[i] % t[d]) / t[d - 1];
            B[C[tt] - 1] = a[i];
            C[tt]--;
        }
        return B;
    }
}
