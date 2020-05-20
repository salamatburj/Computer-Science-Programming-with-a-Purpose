/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RevesPuzzle {
    static void towerOfHanoi(int n, char from_rod,
                             char to_rod, char aux_rod1,
                             char aux_rod2) {
        if (n == 0)
            return;
        if (n == 1) {
            System.out.println("Move disk " + n +
                                       " from " + from_rod +
                                       " to " + to_rod);
            return;
        }

        towerOfHanoi(n - 2, from_rod, aux_rod1, aux_rod2,
                     to_rod);
        System.out.println("Move disk " + (n - 1) +
                                   " from " + from_rod +
                                   " to " + aux_rod2);
        System.out.println("Move disk " + n +
                                   " from " + from_rod +
                                   " to " + to_rod);
        System.out.println("Move disk " + (n - 1) +
                                   " from " + aux_rod2 +
                                   " to " + to_rod);
        towerOfHanoi(n - 2, aux_rod1, to_rod, from_rod,
                     aux_rod2);
    }

    static void hanoi(int n, int k, char from, char temp, char to) {
        if (n == 0) return;
        hanoi(n - 1, k, from, to, temp);
        StdOut.println("Move disc " + (n + k) + " from " + from + " to " + to);
        hanoi(n - 1, k, temp, from, to);
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = (int) Math.floor(n + 1 - Math.sqrt(2 * n + 1));
        towerOfHanoi(k, 'A', 'B', 'C', 'D');
        hanoi(n - k, k, 'A', 'C', 'D');
        towerOfHanoi(k, 'B', 'D', 'A', 'C');


    }

}
