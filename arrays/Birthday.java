public class Birthday {
    public static void main(String[] args) {
        int n =Integer.parseInt(args[0]);
        int trials=Integer.parseInt(args[1]);
        int[] birthdays=new int[n];
        int[] counts=new int [n];
        float[] fraction=new float[n];
        for (int i=0;i<trials;i++){
            for (int j=0;j<n;j++){
                int birthday=(int)(Math.random()*n);
                birthdays[j]=birthday;
                for (int k=0;k<j;k++){
                    if (birthday==birthdays[k]) {
                        counts[j]++;
                        break;
                    }
                }
            }
        }
        for (int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                fraction[i]=fraction[i]+counts[j]/(float)trials;
            }

        }
        for (int i=0;i<n;i++){
            System.out.print(i+1);
            System.out.print("\t");
            System.out.print(counts[i]);
            System.out.print("\t");
            System.out.print(fraction[i]);
            if (fraction[i]>0.5) break;
            else System.out.println();
        }
    }
}
