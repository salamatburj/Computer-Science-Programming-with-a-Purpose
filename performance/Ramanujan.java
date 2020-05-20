/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        int k = (int) Math.round(Math.cbrt(n));
        int count = 0;
        long i_ = 1;
        long j_ = 1;
        for (long i = 1; i <= k; i++) {
            long j = Math.round(Math.cbrt(n - i * i * i));
            if ((j > 0) && (n == (i * i * i + j * j * j))) {
                count++;
                if (count == 1) {
                    i_ = i;
                    j_ = j;
                }
                if (count == 2) {
                    if (!(j == i_) && !(i == j_)) {
                        return true;
                    }
                    else count--;

                }
            }

        }
        return false;

    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        if (isRamanujan(n)) {
            StdOut.println("true");
        }
        else {
            StdOut.println("false");
        }
    }
}
