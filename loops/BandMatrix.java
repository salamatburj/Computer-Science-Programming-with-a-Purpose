public class BandMatrix {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j==n-1) {
                    if (Math.abs(j-i)<=width) System.out.println("*");
                    else System.out.println(0);
                    //System.out.print(" ");
                }
                else{
                    if (Math.abs(j-i)<=width) System.out.print("*");
                    else System.out.print(0);
                    System.out.print("  ");
                }
            }
        }
    }
}
