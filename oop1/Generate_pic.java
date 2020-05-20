/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.awt.Color;

public class Generate_pic {
    public static void main(String[] args) {
        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);
        Picture pic = new Picture(width, height);
        Color colors = new Color(105, 105, 105);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                pic.set(i, j, colors);
            }
        }
        pic.save("generated.png");
        pic.show();


    }
}
