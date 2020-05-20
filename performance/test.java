/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class test {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) a[i] = i;
        for (int i = 0; i < k; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }

    }
}
