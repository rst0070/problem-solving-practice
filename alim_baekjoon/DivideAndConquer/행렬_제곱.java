import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class 행렬_제곱{

    /**
     * 행렬제곱 10830번
     * A^n
     * 1. n이 짝수 일때
     * A^n = A^(n/2) * A^(n/2)
     * = ( A^(n/4) * A^(n/4) ) * ( A^(n/4) * A^(n/4))
     * 
     * 
     * 
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int[][] matrix = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] result = getPower(matrix, B);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N-1; j++){
                System.out.print( (result[i][j] % 1000) + " ");
            }
            System.out.println( result[i][N-1] % 1000 );
        }
    }
    /**
     * matrix의 b번 거듭제곱을 구하라.
     */
    static int[][] getPower(int[][] matrix, long b){
            
        if(b == 1) return matrix;
        if(b == 2) return multiply(matrix, matrix);
        if((b % 2) == 1) return multiply( getPower(matrix, b-1), matrix);
        
        int[][] a = getPower(matrix, b/2);
        return multiply(a, a);
    }
    
    static int[][] multiply(int[][] a1, int[][] a2){
        int[][] result = new int[a1.length][a1.length];
        
        for(int i = 0; i < a1.length; i++)
            for(int j = 0; j < a1.length; j++){
                for(int k = 0; k < a1.length; k++)
                    result[i][j] += (a1[i][k] * a2[k][j]) % 1000;
                result[i][j] = result[i][j] % 1000;
            }
       
       return result;
    }

}
