
package brilliant.org.dp;

import java.util.*;

class Solution
{
    static int findMedian(int arr[], int i,int n)
    {
        if(i <= n)
            Arrays.sort(arr, i, n); //Sort array of size 5 -> O(1)
        else
            Arrays.sort(arr, n, i);  //Sort array of size less than 5 -> O(1)
        return arr[n/2]; // return median of array of size 5
    }
    static int kthSmallest(int arr[], int l, int r, int k)
    {
        if (k > 0 && k <= r - l + 1) // k must be less than  number of elements
        {
            int n = r - l + 1 ; //total number of elements
            int i;
            int []median = new int[(n + 4) / 5]; // array of size n / 5 but because sometime there will be some remainder there we take (n + 4) / 5
            for (i = 0; i < n / 5; i++)
                median[i] = findMedian(arr, l + i * 5, 5);
            if (i*5 < n) // check if there is some remainder or not
            {
                median[i] = findMedian(arr,l + i * 5, n % 5);
                i++;
            }
            int medOfMed = -1;
            if(i == 1){
                medOfMed = median[i - 1];
            }else{
                medOfMed = kthSmallest(median, 0, i - 1, i / 2);
            }
            print(median);
            int pos = partition(arr, l, r, medOfMed);
            if (pos-l == k - 1)
                return arr[pos];
            if (pos-l > k - 1)
                return kthSmallest(arr, l, pos - 1, k);
            return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
        }
        return Integer.MAX_VALUE; //Error
    }

    static int[] swap(int []arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
    static int partition(int arr[], int l, int r, int x)
    {
        int i;
        for (i = l; i < r; i++)
            if (arr[i] == x)
                break;

        swap(arr, i, r);
        i = l;
        for (int j = l; j <= r - 1; j++)
        {
            if (arr[j] <= x)
            {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    public static int[] getRandom(int n){
        int[] a = new int[n];
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < n; ++i){
            l.add(i);
        }
        Collections.shuffle(l);
        int i = 0;
        for (int val : l){
            a[i++] = val;
        }
        return a;
    }

    public static void print(int[] a){
        for (int val : a){
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] a = getRandom(100);
        print(a);
        System.out.println(kthSmallest(a, 0, a.length - 1, 47));
    }
}