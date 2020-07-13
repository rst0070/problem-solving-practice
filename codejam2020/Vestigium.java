package codejam2020;
import java.util.Scanner;
class Vestigium{
    static int[][] mc = new int[101][101];
    static int[] note = new int[101];
    static void clear(int n){
        for(;n > 0; n--)
            note[n] = 0;
    }
    public static void main(String args[])throws Exception{
        Scanner s = new Scanner(System.in);
        int k, r, c, i, j,n,tc = s.nextInt();
        for(int t=1; t<=tc; t++){
            n =s.nextInt();
            i=0;
            j=0;
            for(i=1; i <= n; i++)
                for(j=1; j <= n; j++)
                    mc[i][j] = s.nextInt();
            k = 0;
            r = 0;
            c = 0;
        
            for(i=1; i <= n; i++){
                k += mc[i][i];
                for(j = 1; j <= n ; j++)
                    if(note[mc[i][j]]++ > 0){
                        r++;
                        break;
                    }
                clear(n);
            }
            for(j = 1; j <= n; j++){
                for(i = 1; i <= n ; i++)
                    if(note[mc[i][j]]++ > 0){
                        c++;
                        break;
                    }
                clear(n);
            }
            System.out.println("Case #"+t+": "+k+" "+r+" "+c);
        }
        s.close();
    }
}