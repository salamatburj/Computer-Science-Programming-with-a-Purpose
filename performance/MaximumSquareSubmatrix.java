/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int size = a.length;
        int[][] s = new int[size][size];
        s[0][0] = a[0][0];
        // Copy first row and column
        for (int j = 0; j < size; j++) s[0][j] = a[0][j];
        for (int i = 0; i < size; i++) s[i][0] = a[i][0];
        int max = s[0][0];
        // find sum for each right corner case
        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                if (a[i][j] == 1) {
                    s[i][j] = Math.min(Math.min(s[i - 1][j], s[i][j - 1]), s[i - 1][j - 1]) + 1;
                    max = Math.max(s[i][j], max);
                }
                else {
                    s[i][j] = 0;
                    max = Math.max(Math.max(Math.max(s[i - 1][j], s[i][j - 1]), s[i - 1][j - 1]),
                                   max);
                }
            }
        }
        return max;


    }


    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int count = 1;
        int size = StdIn.readInt();
        int[][] a = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                a[i][j] = StdIn.readInt();
            }
        }
        StdOut.println(size(a));
    }

}
