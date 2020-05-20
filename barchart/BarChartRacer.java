/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException(
                    "Enter input file name, and number of bars. Example: countries.txt 10");
        }
        In in = new In(args[0]);
        int num = Integer.parseInt(args[1]);

        String title = in.readLine();
        String xAxis = in.readLine();
        String source = in.readLine();
        BarChart chart = new BarChart(title, xAxis, source);
        String caption = "";
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();
        //StdAudio.loop("soundtrackB.wav");
        in.readLine();
        while (in.hasNextLine()) {
            int n = Integer.parseInt(in.readLine());
            Bar[] bars = new Bar[n];
            for (int i = 0; i < n; i++) {
                String[] info = in.readLine().split(",");
                caption = info[0];
                String name = info[1];
                String country = info[2];
                int value = Integer.parseInt(info[3]);
                String category = info[4];
                bars[i] = new Bar(name, value, category);
            }
            // empty space after each block
            in.readLine();
            Arrays.sort(bars);
            for (int i = n - 1; i > n - 1 - num; i--) {
                chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
            }
            chart.setCaption(caption);
            chart.draw();
            StdDraw.show();
            StdDraw.pause(30);
            StdDraw.clear();
            chart.reset();
        }
    }
}

