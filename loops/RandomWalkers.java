public class RandomWalkers {
    public static void main(String[] args) {
        int r =Integer.parseInt(args[0]);
        int n_loops=Integer.parseInt(args[1]);
        int x=0;
        int y=0;
        int count=0;
        double random =0;
        for (int i=0;i<n_loops;i++) {
            x=0;
            y=0;
            while ((Math.abs(x) + Math.abs(y)) != r) {
                random = Math.random();
                if (random < 0.25) x = x + 1;
                else if (random < 0.5) x = x - 1;
                else if (random < 0.75) y = y + 1;
                else y = y - 1;
                //System.out.println("("+x+","+y+")");
                count++;
            }
        }
        System.out.print("average number of steps = "+(float)count/n_loops);
    }
}
