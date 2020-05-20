/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.awt.Color;

public class KernelFilter {
    // Returns a new picture that applies an arbitrary kernel filter to the given picture.
    private static Picture kernel(Picture picture, double[][] filter) {
        int width = picture.width();
        int height = picture.height();
        Picture new_pic = new Picture(width, height);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                double[] sum_rgb = new double[3];
                for (int i_f = 0; i_f < filter.length; i_f++) {
                    for (int j_f = 0; j_f < filter.length; j_f++) {
                        int col = i + i_f - (filter.length - 1) / 2;
                        int row = j + j_f - (filter.length - 1) / 2;
                        if (col < 0) {
                            col = col + width - 1;
                            if (col < 0) col = 0;
                        }
                        if (row < 0) {
                            row = row + height - 1;
                            if (row < 0) row = 0;
                        }
                        if (col >= width - 1) {
                            col = col - (width - 1);
                            if (col >= width - 1) col = width - 1;
                        }
                        if (row >= height - 1) {
                            row = row - (height - 1);
                            if (row >= height - 1) row = (height - 1);
                        }
                        sum_rgb[0] = sum_rgb[0] + picture.get(col, row).getRed() * filter[i_f][j_f];
                        sum_rgb[1] = sum_rgb[1]
                                + picture.get(col, row).getGreen() * filter[i_f][j_f];
                        sum_rgb[2] = sum_rgb[2]
                                + picture.get(col, row).getBlue() * filter[i_f][j_f];
                    }

                }

                for (int k = 0; k < sum_rgb.length; k++) {
                    if (sum_rgb[k] < 0) sum_rgb[k] = 0.0;
                    if (sum_rgb[k] > 255) sum_rgb[k] = 255.0;
                }

                Color colors = new Color((int) Math.round(sum_rgb[0]), (int) Math.round(sum_rgb[1]),
                                         (int) Math.round(sum_rgb[2]));
                new_pic.set(i, j, colors);
            }
        }
        return new_pic;

    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[][] filter = new double[3][3];
        filter[0][0] = 1 / 16.0;
        filter[2][0] = 1 / 16.0;
        filter[0][2] = 1 / 16.0;
        filter[2][2] = 1 / 16.0;

        filter[1][0] = 1 / 8.0;
        filter[0][1] = 1 / 8.0;
        filter[2][1] = 1 / 8.0;
        filter[1][2] = 1 / 8.0;

        filter[1][1] = 1 / 4.0;
        return kernel(picture, filter);
    }


    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {

        double[][] filter = new double[3][3];
        filter[0][0] = 0.0;
        filter[2][0] = 0.0;
        filter[0][2] = 0.0;
        filter[2][2] = 0.0;

        filter[1][0] = -1.0;
        filter[0][1] = -1.0;
        filter[2][1] = -1.0;
        filter[1][2] = -1.0;

        filter[1][1] = 5;
        return kernel(picture, filter);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] filter = new double[3][3];
        for (int i = 0; i < filter.length; i++) {
            for (int j = 0; j < filter.length; j++) {
                filter[i][j] = -1.0;
            }
        }
        filter[1][1] = 8.0;
        return kernel(picture, filter);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] filter = new double[3][3];
        filter[0][0] = -2.0;
        filter[0][1] = -1.0;
        filter[0][2] = 0.0;
        filter[1][0] = -1.0;
        filter[1][1] = 1.0;
        filter[1][2] = 1.0;
        filter[2][0] = 0.0;
        filter[2][1] = 1.0;
        filter[2][2] = 2.0;
        return kernel(picture, filter);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] filter = new double[9][9];
        for (int i = 0; i < filter.length; i++) filter[i][i] = 1.0 / 9.0;
        return kernel(picture, filter);
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture pic = new Picture(args[0]);
        Picture motion = motionBlur(pic);
        motion.show();


    }

}
