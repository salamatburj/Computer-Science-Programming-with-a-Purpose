/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class TrinomialDP {
    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if ((n == 0) && (k == 0)) return 1;
        else if (n < Math.abs(k)) return 0;
        long[][] coef = new long[n + 1][2 * n + 3];
        coef[0][0] = 1;
        coef[1][0] = 1;
        coef[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = -i; j <= i; j++) {
                coef[i][Math.abs(j)] = coef[i - 1][Math.abs(j - 1)] + coef[i - 1][Math.abs(j)]
                        + coef[i - 1][Math.abs(j + 1)];
            }
        }
        return coef[n][Math.abs(k)];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println(trinomial(n, k));
    }
}
