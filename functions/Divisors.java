/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Divisors {
    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        int a_ = Math.abs(a);
        int b_ = Math.abs(b);
        int t = b_;
        while (b_ > 0) {
            b_ = a_ % b_;
            a_ = t;
            t = b_;
        }
        return a_;
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs(a) * (Math.abs(b) / gcd(a, b));
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
        return gcd(a, b) == 1;
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (areRelativelyPrime(n, i)) {
                count = count + 1;
            }
        }
        return count;
    }

    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.print("gcd(" + a + "," + b + ") = ");
        System.out.println(gcd(a, b));
        System.out.print("lcm(" + a + "," + b + ") = ");
        System.out.println(lcm(a, b));
        System.out.print("areRelativelyPrime(" + a + "," + b + ") = ");
        System.out.println(areRelativelyPrime(a, b));
        System.out.print("totient(" + a + ") = ");
        System.out.println(totient(a));
        System.out.print("totient(" + b + ") = ");
        System.out.println(totient(b));


    }
}
