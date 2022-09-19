package advance_tree.segment_tree.applications.Factorial_Array;

import java.util.*;
import java.io.*;

public class Solution {
    static long MOD = 1000000000L;
    static long[] fact;
    public static void calculateFactorial() {
        fact[0] = 1;

        for(int i=1;i<=39;i++) {
            fact[i] = ((long)i*fact[i-1])%MOD;
            fact[i]+=MOD;
            fact[i]%=MOD;
            //System.out.println(i + " " + fact[i]);
        }
    }

    public static void initialize(int[] A, long[][] segmentTree, int start, int end, int index) {
        if(start==end) {
            if(A[start]<=39) {
                segmentTree[index][A[start]]++;
            }
            return;
        }

        int mid = (start+end)/2;

        initialize(A,segmentTree, start, mid, index*2+1);
        initialize(A,segmentTree, mid+1, end, index*2+2);

        //segmentTree[index] = segmentTree[index*2+1] + segmentTree[index*2+2];
        for(int i=0;i<=39;i++) {
            segmentTree[index][i] = segmentTree[index*2+1][i]+segmentTree[index*2+2][i];
        }
    }

    public static void update(int[] A, long[][] segmentTree, long[] lazyBit, int start, int end, int index, int rangeStart, int rangeEnd, int diff) {
        if(lazyBit[index]!=0) {
            //segmentTree[index]+=(end-start+1)*lazyBit[index];
            long[] temp = new long[40];
            for(int i=0;i<=39;i++) {
                if((long)i+lazyBit[index]>=0 && (long)i+lazyBit[index]<=39 && segmentTree[index][i]>0) {
                    temp[i+(int)lazyBit[index]]=segmentTree[index][i];
                }
            }

            for(int i=0;i<=39;i++) {
                segmentTree[index][i] = temp[i];
            }

            if(start!=end) {
                lazyBit[index*2+1] += lazyBit[index];
                lazyBit[index*2+2] += lazyBit[index];
            }
            lazyBit[index] = 0;
        }

        if(rangeStart>rangeEnd || rangeStart>end || rangeEnd<start) {
            return;
        }

        if(rangeStart<=start && rangeEnd>=end) {
            //segmentTree[index]+=(end-start+1)*diff;
            long[] temp = new long[40];
            for(int i=0;i<=39;i++) {
                if(i+diff>=0 && i+diff<=39 && segmentTree[index][i]>0) {
                    temp[i+diff] += segmentTree[index][i];
                }
            }

            for(int i=0;i<=39;i++) {
                segmentTree[index][i] = temp[i];
            }

            if(start!=end) {
                lazyBit[index*2+1] += diff;
                lazyBit[index*2+2] += diff;
            }

            return;
        }

        int mid = (start+end)/2;
        update(A,segmentTree,lazyBit,start,mid,index*2+1,rangeStart,rangeEnd,diff);
        update(A,segmentTree,lazyBit,mid+1,end,index*2+2,rangeStart,rangeEnd,diff);

        //segmentTree[index] = segmentTree[index*2+1] + segmentTree[index*2+2];
        for(int i=0;i<=39;i++) {
            segmentTree[index][i] = segmentTree[index*2+1][i] + segmentTree[index*2+2][i];
        }
    }

    public static void updateValue(int[] A, long[][] segmentTree, long[] lazyBit, int start, int end, int index, int pos, int val) {
        if(lazyBit[index]!=0) {
            //segmentTree[index]+=(end-start+1)*lazyBit[index];
            long[] temp = new long[40];
            for(int i=0;i<=39;i++) {
                if((long)i+lazyBit[index]>=0 && (long)i+lazyBit[index]<=39 && segmentTree[index][i]>0) {
                    temp[i+(int)lazyBit[index]]=segmentTree[index][i];
                }
            }

            for(int i=0;i<=39;i++) {
                segmentTree[index][i] = temp[i];
            }

            if(start!=end) {
                lazyBit[index*2+1] += lazyBit[index];
                lazyBit[index*2+2] += lazyBit[index];
            }
            lazyBit[index] = 0;
        }

        if(pos>end || pos<start) {
            return;
        }

        if(start==end) {
            long[] temp = new long[40];

            if(val>=0 && val<=39) {
                temp[val]++;
            }

            for(int i=0;i<=39;i++) {
                segmentTree[index][i] = temp[i];
            }
            return;
        }

        int mid = (start+end)/2;
        updateValue(A,segmentTree,lazyBit,start,mid,index*2+1,pos,val);
        updateValue(A,segmentTree,lazyBit,mid+1,end,index*2+2,pos,val);

        for(int i=0;i<=39;i++) {
            segmentTree[index][i] = segmentTree[index*2+1][i] + segmentTree[index*2+2][i];
        }
    }

    public static long query(int[] A, long[][] segmentTree, long[] lazyBit, int start, int end, int index, int rangeStart, int rangeEnd) {
        if(lazyBit[index]!=0) {
            //segmentTree[index]+=(end-start+1)*lazyBit[index];
            long[] temp = new long[40];
            for(int i=0;i<=39;i++) {
                if((long)i+lazyBit[index]>=0 && (long)i+lazyBit[index]<=39 && segmentTree[index][i]>0) {
                    temp[i+(int)lazyBit[index]]=segmentTree[index][i];
                }
            }

            for(int i=0;i<=39;i++) {
                segmentTree[index][i] = temp[i];
            }

            if(start!=end) {
                lazyBit[index*2+1] += lazyBit[index];
                lazyBit[index*2+2] += lazyBit[index];
            }
            lazyBit[index] = 0;
        }

        if(rangeStart>end || rangeEnd<start) {
            return 0;
        }

        if(rangeStart<=start && rangeEnd>=end) {
            long sum = 0;

            for(int i=0;i<=39;i++) {
                if(segmentTree[index][i]>0) {
                    sum+=(fact[i]*segmentTree[index][i])%MOD;
                    sum+=MOD;
                    sum%=MOD;
                }
            }
            return sum;
        }

        int mid = (start+end)/2;
        long val1 = query(A,segmentTree, lazyBit,start, mid, index*2+1, rangeStart, rangeEnd);
        long val2 = query(A,segmentTree, lazyBit,mid+1, end, index*2+2, rangeStart, rangeEnd);

        long val = (val1+val2)%MOD;
        val+=MOD;
        val%=MOD;
        return val;
    }

    public static void main(String[] args) throws Exception{
        InputReader in = new InputReader(System.in);
        fact = new long[40];
        calculateFactorial();

        int n = in.nextInt();
        int m = in.nextInt();

        int[] A = new int[n];

        for(int i=0;i<n;i++) {
            A[i] = in.nextInt();
        }

        int x = (int)Math.ceil(Math.log(n)/Math.log(2));

        int size = (int)Math.pow(2,x+1)-1;

        long[][] segmentTree = new long[size+1][40];
        long[] lazyBit = new long[size+1];
        initialize(A,segmentTree,0,n-1,0);

        for(int i=0;i<m;i++) {
            int type = in.nextInt();
            int l,r;

            switch(type) {
                case 1:
                    l = in.nextInt();
                    r = in.nextInt();
                    l--;
                    r--;
                    update(A,segmentTree,lazyBit,0,n-1,0,l,r,1);
                    break;
                case 2:
                    l = in.nextInt();
                    r = in.nextInt();
                    l--;
                    r--;
                    long rslt = query(A,segmentTree,lazyBit,0,n-1,0,l,r);
                    rslt+=MOD;
                    rslt%=MOD;
                    System.out.println(rslt);
                    break;
                case 3:
                    int pos = in.nextInt();
                    int val = in.nextInt();
                    pos--;
                    updateValue(A,segmentTree,lazyBit,0,n-1,0,pos,val);
                    break;
                default:
                    break;
            }
        }
    }

    public static void QuickSort(int[] A, int lo, int hi) {
        if(lo<hi) {
            int index = partition(A,lo, hi);
            QuickSort(A, lo, index-1);
            QuickSort(A, index+1, hi);
        }
    }

    public static int partition(int[] A, int lo, int hi) {
        int pivot = A[hi];

        int i = lo-1;

        for(int j=lo;j<hi;j++) {
            if(A[j]<=pivot) {
                i++;
                swap(A,i,j);
            }
        }
        swap(A,i+1,hi);
        return i+1;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    //Search for A particular Key in a sorted array
    public static int binarySearch(int[] A, int key, int lo, int hi) {
        while(lo<=hi) {
            int mid = (lo+hi)/2;
            if(A[mid]==key) {
                return mid;
            } else if(A[mid]>key) {
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        return -1;
    }

    public static int upperBound(int[] A, int key, int lo, int hi) {
        while(lo<=hi) {
            int mid = (lo+hi)/2;
            if(A[mid]>key && (mid==1 || A[mid-1]<=key)) {
                return mid;
            } else if(A[mid]>key) {
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        return -1;
    }

    public static int lowerBound(int[] A, int key, int lo, int hi) {
        while(lo<=hi) {
            int mid = (lo+hi)/2;
            if(A[mid]>=key && (mid==1 || A[mid-1]<key)) {
                return mid;
            } else if(A[mid]>=key) {
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        return -1;
    }

    public static long power(long x, long n) {
        if(n==0) {
            return 1;
        }
        if(n==1) {
            return x;
        }
        long ret = (power(x,n/2)+MOD)%MOD;
        long val = (ret*ret+MOD)%MOD;
        if(n%2==1) {
            val*=x;
            val+=MOD;
            val%=MOD;
        }
        return val;
    }

    public static boolean check(int N, int pos) {
        return (N&(1<<pos))!=0;
    }

    public static int set(int N, int pos) {
        return N|=(1<<pos);
    }

    public static int[] sieve(int N) {
        int[] status = new int[(N>>5)+2];
        int sqrtN = (int)Math.sqrt(N);
        for(int i=3;i<=sqrtN;i+=2) {
            if(!check(status[i>>5],i&31)) {
                for(int j=i*i;j<=N;j+=(i<<1)) {
                    status[j>>5] = set(status[j>>5],j&31);
                }
            }
        }

        int[] prime = new int[N];
        int cnt=0;
        prime[cnt++]=2;
        for(int i=3;i<=N;i+=2) {
            if(!check(status[i>>5],i&31)) {
                prime[cnt++]=i;
            }
        }
        return prime;
    }

    public static int[][][] FibonacciGeneration(int P) {
        int[][][] A = new int[P][2][2];
        A[0][0][0] = 1;
        A[0][0][1] = 1;
        A[0][1][0] = 1;
        A[0][1][1] = 0;

        for(int i=1;i<P;i++) {
            A[i][0][0] = A[i-1][0][0]*A[i-1][0][0] + A[i-1][0][1]*A[i-1][1][0];
            A[i][0][1] = A[i-1][0][0]*A[i-1][0][1] + A[i-1][0][1]*A[i-1][1][1];
            A[i][1][0] = A[i-1][1][0]*A[i-1][0][0] + A[i-1][1][1]*A[i-1][1][0];
            A[i][1][1] = A[i-1][1][0]*A[i-1][0][1] + A[i-1][1][1]*A[i-1][1][1];
        }
        return A;
    }

    public static int[][] matrixMultiplication(int[][] A, int[][] B) {
        int ARow = A.length;
        int ACol = A[0].length;

        int BCol = B[0].length;

        int[][] C = new int[ARow][BCol];

        for(int i=0;i<ARow;i++) {
            for(int j=0;j<BCol;j++) {
                C[i][j]=0;
                for(int k=0;k<ACol;k++) {
                    C[i][j] += A[i][k]*B[k][j];
                }
            }
        }
        return C;
    }


    public static void Fibonacci() {
        //Array Size
        int N = 1000000001;
        //highest 2 power which is less than N
        int P = (int)Math.ceil(Math.log(N)/Math.log(2));
        //A contains fibonacci matrix for the power of 2's
        int[][][] A = FibonacciGeneration(P);

        //Lth Fibonacci(T=L-1)
        int T = 6;
        int[][] rs = {{1,0},{0,1}};

        for(int i=P-1;i>=0;i--) {
            if((T&(1<<i))!=0) {
                rs = matrixMultiplication(rs,A[i]);
            }
        }

        int rslt = rs[0][0] + rs[0][1];
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String next() throws Exception {
            while(tokenizer==null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public String nextLine() throws Exception {
            return reader.readLine();
        }

        public int nextInt() throws Exception {
            return Integer.parseInt(next());
        }

        public long nextLong() throws Exception {
            return Long.parseLong(next());
        }

        public double nextDouble() throws Exception {
            return Double.parseDouble(next());
        }
    }
}
