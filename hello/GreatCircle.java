public class GreatCircle {
    public static void main(String[] args) {
        // write your code here
        double r= 6371.0;
        double x1= Math.toRadians(Double.parseDouble(args[0]));
        double y1= Math.toRadians(Double.parseDouble(args[1]));
        double x2= Math.toRadians(Double.parseDouble(args[2]));
        double y2= Math.toRadians(Double.parseDouble(args[3]));
        double a=Math.pow(Math.sin((x2-x1)/2.0),2);
        double b=Math.cos(x1)*Math.cos(x2)*Math.pow(Math.sin((y2-y1)/2.0),2);
        double d=2*r*Math.asin(Math.sqrt(a+b));
        System.out.println(d + " kilometers");

    }
}
