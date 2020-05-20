/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] m_list = new int[m];
        int count = 0;
        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            m_list[x - 1] = m_list[x - 1] + 1;
            count++;
        }
        double entropy = 0;
        for (int i = 0; i < m; i++) {
            if (m_list[i] != 0) {
                double p = (double) m_list[i] / (double) count;
                entropy = entropy - p * Math.log(p) / Math.log(2);
            }
        }
        StdOut.println(entropy);
    }
}

