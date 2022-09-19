package dynamic_problems.coin_change_with_limited_coins;

public class Solution {
    public static void main(String[] args) {
        int[] D = {1, 5, 7, 9};
        int[] limit = {2, 1, 2, 5};
        makeChangeLimitedCoins(D, limit, 10);
    }

    public static void makeChangeLimitedCoins(int[] D, int[] S, int N) {
        int[] C = new int[N + 1];
        C[0] = 0;

        int len = D.length;
        int[][] track = new int[N + 1][len];
        for (int i = 0; i < len; i++) {
            track[0][i] = S[i];
        }
        for (int j = 1; j <= N; j++) {
            C[j] = Integer.MAX_VALUE;
            for (int k = 0; k < len; k++) {
                if (j >= D[k] && (C[j - D[k]] < Integer.MAX_VALUE) && (track[j - D[k]][k] > 0)) {
                    if ((C[j] > 1 + C[j - D[k]])) {
                        C[j] = 1 + C[j - D[k]];
                        track[j][k] = track[j - D[k]][k] - 1;
                    } else {
                        track[j][k] = track[j - D[k]][k];
                    }
                } else if (j < D[k]) {
                    track[j][k] = track[0][k];
                }
            }
        }
        System.out.println(C[N]);
    }
}