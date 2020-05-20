public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int pow=(int)(Math.log(n)/Math.log(2));
        int m=n;
        if (n!=Math.pow(2,pow)){
            n=(int)Math.pow(2,pow+1);
        }


        boolean[] grid=new boolean[n*n];
        for (int i=1;i<n*n;i=i*2){
            for (int j=0;j<i;j++){
                grid[i+j]=!grid[j];
            }

        }
        for (int i=0;i<m;i++){
            if (i>0) System.out.println();
            for (int j=0;j<m;j++){
                if (grid[n*i+j]) {
                    System.out.print("-");
                    System.out.print("  ");
                }
                else{
                    System.out.print("+");
                    System.out.print("  ");
                }

            }

        }


    }
}

