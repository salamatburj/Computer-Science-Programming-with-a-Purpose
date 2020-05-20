/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class AudioCollage {
    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] * alpha;
        }
        return c;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[a.length - 1 - i];
        }
        return b;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] c = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) c[i] = a[i];
        for (int j = 0; j < b.length; j++) c[a.length + j] = b[j];
        return c;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        double[] a_ = new double[a.length];
        double[] b_ = new double[b.length];
        if (a.length > b.length) {
            for (int i = 0; i < b.length; i++) a_[i] = a[i] + b[i];
            for (int j = b.length; j < a.length; j++) a_[j] = a[j];
            return a_;
        }
        else {
            for (int i = 0; i < a.length; i++) b_[i] = b[i] + a[i];
            for (int j = a.length; j < b.length; j++) b_[j] = b[j];
            return b_;
        }
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int m = (int) Math.floor(a.length / alpha);
        double[] c = new double[m];
        for (int i = 0; i < m; i++) {
            int j = (int) Math.floor(i * alpha);
            c[i] = a[j];
        }
        return c;

    }

    // See below for the requirements.    // Creates an audio collage and plays it on standard audio.
    public static void main(String[] args) {
        double[] A = new double[44100];
        double[] B = new double[44100];

        A = StdAudio.read("beatbox.wav");
        B = StdAudio.read("chimes.wav");

        double alpha = 1.5;

        StdAudio.play(amplify(A, alpha));
        StdAudio.play(reverse((A)));
        StdAudio.play(merge(A, B));
        StdAudio.play(mix(A, B));
        StdAudio.play(changeSpeed(A, alpha));

    }
}
