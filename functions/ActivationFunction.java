/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ActivationFunction {
    public static double heaviside(double x) {
        if (x < 0.0) return 0.0;
        else if (x == 0.0) return 0.5;
        else return 1.0;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        return (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        return x / (1.0 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (x <= -2) return -1;
        else if (x < 0) return x + (x * x) / 4.0;
        else if (x < 2) return x - (x * x) / 4.0;
        else return 1;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        System.out.print("heaviside(" + x + ") = ");
        System.out.println(heaviside(x));
        System.out.print("sigmoid(" + x + ") = ");
        System.out.println(sigmoid(x));
        System.out.print("tanh(" + x + ") = ");
        System.out.println(tanh(x));
        System.out.print("softsign(" + x + ") = ");
        System.out.println(softsign(x));
        System.out.print("sqnl(" + x + ") = ");
        System.out.println(sqnl(x));

    }

}

