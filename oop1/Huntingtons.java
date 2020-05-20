/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int n = dna.length();
        int max_count = 0;
        int index = 0;
        int count = 0;

        while (index + 3 <= n) {
            if (dna.substring(index, index + 3).equals("CAG")) {
                count++;
                index = index + 3;
            }
            else {
                max_count = Math.max(max_count, count);
                count = 0;
                index = index + 1;
            }
        }
        // check again in case it doesn't go through else statement
        max_count = Math.max(max_count, count);
        return max_count;
    }


    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        s = s.replace(" ", "");
        s = s.replace("\t", "");
        s = s.replace("\n", "");
        return s;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats < 10) return "not human";
        if (maxRepeats < 36) return "normal";
        if (maxRepeats < 40) return "high risk";
        if (maxRepeats < 181) return "Huntington's";
        else return "not human";

    }

    // Sample client (see below).
    public static void main(String[] args) {
        In in = new In(args[0]);
        String s = in.readAll();
        s = removeWhitespace(s);
        int maxrep = maxRepeats(s);
        StdOut.println("max repeats = " + maxrep);
        StdOut.println(diagnose(maxrep));

    }
}

