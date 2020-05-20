public class GeneralizedHarmonic {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        double sum=0.0;
        for (int j=1;j<=n;j++){
            sum=sum+Math.pow(1./j,r);
            //System.out.println(j+" "+sum);
        }
        System.out.println(sum);
    }
}
