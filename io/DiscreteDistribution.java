public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] a = new int [args.length-1];
        int[] sum=new int[a.length+1];
        int sum_temp=0;
        for (int i=0;i<a.length;i++){
            a[i]=Integer.parseInt(args[i+1]);
            sum_temp=0;
            for (int j=0;j<=i;j++) {
                sum_temp=sum_temp+a[j];
            }
            sum[i+1]=sum_temp;
        }
        for (int k=0;k<m;k++){
            int r=(int) (Math.random()*(sum[sum.length-1]-1));

            for (int i=1;i<(sum.length+1);i++) {
                if ((r >= sum[i - 1]) && (r < sum[i])) {
                    System.out.print(i);
                    System.out.print(" ");
                    break;
                }
            }
        }
    }
}
