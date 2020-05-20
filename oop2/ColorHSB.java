/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ColorHSB {
    private final int hue, sat, bright;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if ((h >= 0) && (h <= 359)) hue = h;
        else throw new IllegalArgumentException("the hue must be between 0 and 359");
        if ((s >= 0) && (s <= 100)) sat = s;
        else throw new IllegalArgumentException("the saturation must be between 0 and 100");
        if ((b >= 0) && (b <= 100)) bright = b;
        else throw new IllegalArgumentException("the brightness must be between 0 and 100");

    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hue + ", " + sat + ", " + bright + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        if ((sat == 0) || (bright == 0)) return true;
        else return false;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        int d = Math.min((that.hue - hue) * (that.hue - hue),
                         (360 - Math.abs(that.hue - hue)) * (360 - Math.abs(that.hue - hue)));
        d = d + (that.sat - sat) * (that.sat - sat) + (that.bright - bright) * (that.bright
                - bright);
        return d;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB item1 = new ColorHSB(h, s, b);
        ColorHSB result = new ColorHSB(0, 0, 0);
        int d = 0;
        int i = 0;
        String color_final = "";
        while (StdIn.hasNextLine()) {
            String line = StdIn.readLine();
            String[] a = line.split("\\s+");
            String color_name = a[0];
            h = Integer.parseInt(a[1]);
            s = Integer.parseInt(a[2]);
            b = Integer.parseInt(a[3]);
            ColorHSB item2 = new ColorHSB(h, s, b);
            if (i == 0) {
                d = item1.distanceSquaredTo(item2);
                color_final = color_name;
                result = item2;
            }
            else if (d > item1.distanceSquaredTo(item2)) {
                d = item1.distanceSquaredTo(item2);
                result = item2;
                color_final = color_name;
            }
            i++;
        }
        StdOut.print(color_final + " ");
        StdOut.println(result.toString());
        //StdOut.println(d);
    }
}


