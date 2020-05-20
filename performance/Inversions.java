/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        int count = 0;
        boolean sorted = false;
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) b[i] = a[i];
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < b.length; i++) {
                if (b[i - 1] > b[i]) {
                    sorted = false;
                    int temp = b[i];
                    b[i] = b[i - 1];
                    b[i - 1] = temp;
                    count++;
                }
            }
        }
        return count;
    }


    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] a = new int[n];
        int count = 0;
        boolean sorted = false;
        for (int i = 0; i < a.length; i++) a[i] = i;
        while (!sorted) {
            sorted = true;
            for (int i = a.length - 1; i > 0; i--) {
                if (count == k) return a;
                if (a[i] > a[i - 1]) {
                    sorted = false;
                    int temp = a[i];
                    a[i] = a[i - 1];
                    a[i - 1] = temp;
                    count++;
                }
            }
        }
        return a;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] a = new int[n];
        a = generate(n, k);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
    }
}
