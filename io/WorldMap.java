/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class WorldMap {
    public static void main(String[] args) {

        double width = StdIn.readDouble();
        double height = StdIn.readDouble();
        StdDraw.setCanvasSize((int) width, (int) height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int m = StdIn.readInt();
            double[] x_ = new double[m];
            double[] y_ = new double[m];
            for (int i = 0; i < m; i++) {
                x_[i] = StdIn.readDouble();
                y_[i] = StdIn.readDouble();

            }
            StdDraw.polygon(x_, y_);
        }
    }
}
