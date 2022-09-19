package maths.prime;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public boolean isPrime(int n){
        if(n <= 1)
            return false;
        if(n <= 3)
            return true;

        if(n % 2 == 0 || n  % 3 == 0)
            return false;

        for(int i = 5; i * i <= n; i += 6){
            if(n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

    public boolean[] sieveOfEratosthenes(int n){
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for(int i = 2; i * i <= n; i++){
            if(primes[i])
                for(int j = 2 * i; j <= n; j += i){
                    primes[j] = false;
                }
        }
        return primes;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean[] primes = new Solution().sieveOfEratosthenes(n);
        for(int i = 0; i <= n; i++){
            if(primes[i])
                System.out.print(i + " ");
        }
    }

}
