package codejam2020;
import java.util.*;
import java.io.*;
public class Indicium {
    static int[][] matrix = new int[51][51];  
    public static void main(String args[]) throws Exception{
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int tc = s.nextInt();
        int N, K, i, j, S, p;
        for(int t = 1; t<=tc; t++){
            N = s.nextInt(); K = s.nextInt();
            if(K%N != 0 || (N%2==0 && K == N*(N+1)/2)){System.out.println("Case #"+t+": IMPOSSIBLE"); continue;}
            S = K/N;
            for(i=1; i<=N; i++){
                p = i;
                matrix[i][i] = S;
                //System.out.print(matrix[i][i]+" ");
                for(j=1; j<N; j++){
                    p = (p+1)%N;
                    if(p==0)p=N;
                    matrix[i][p] = (S+j)%N;
                    if(matrix[i][p]==0)matrix[i][p] = N;
                    //System.out.print(matrix[i][p]+" ");
                }
                System.out.println();
                
            }
            System.out.println("Case #"+t+": POSSIBLE");
            for(i=1; i <= N; i++){
                for(j = 1; j <= N; j++)
                    System.out.print(matrix[i][j]+" ");
                System.out.println();
            }
            
        }
        s.close();
    }
}