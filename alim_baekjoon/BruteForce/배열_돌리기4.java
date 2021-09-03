import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class 배열_돌리기4{

    /**
     * 배열 돌리기 4
     * 한번 돌릴때마다 4s^2 => 2304 만큼의 연산이 들어감
     * k <= 6
     * 6! = 720
     * s <= 24
     * 
     * 브루트포스로 약 10^7 예상
     * 
     * 회전 연산은 세 정수 (r, c, s)로 이루어져 있고, 가장 왼쪽 윗 칸이 (r-s, c-s), 가장 오른쪽 아랫 칸이 (r+s, c+s)인 정사각형을 시계 방향
     * 
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N, M, K;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        int[][] matrix = new int[N][M];
        for(int h = 0; h < N; h++){
            st = new StringTokenizer(br.readLine());
            for(int w = 0; w < M; w++){
                matrix[h][w] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] operaters = new int[K][4];//[0]: r, [1]: c, [2]: s, [3]: is this operation used? if true: 1
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++) operaters[i][j] = Integer.parseInt(st.nextToken())-1;
            operaters[i][2] = Integer.parseInt(st.nextToken());
            operaters[i][3] = 0;
        }
        System.out.println(solve(matrix, operaters));
    }
    
    static int findMin(int[][] matrix){
        int result = 5001;
        for(int i = 0; i < matrix.length; i++){
            int tmp = 0;
            for(int j = 0; j < matrix[i].length; j++)
                tmp += matrix[i][j];
            result = result < tmp ? result : tmp;
        }
        return result;
    }
    static void rotate(int[][] matrix, int h1, int w1, int h2, int w2){
        if(!(h1 < h2 && w1 < w2)) return;
        int tmp = matrix[h1][w1];//왼쪽 위 임시저장
        for(int h = h1; h < h2; h++){//왼쪽
            matrix[h][w1] = matrix[h+1][w1];
        }
        for(int w = w1; w < w2; w++){//아래
            matrix[h2][w] = matrix[h2][w + 1];
        }
        for(int h = h2; h > h1; h--){//오른쪽
            matrix[h][w2] = matrix[h-1][w2];
        }
        for(int w = w2; w > w1+1; w--){//위
            matrix[h1][w] = matrix[h1][w - 1];
        }
        matrix[h1][w1+1] = tmp;
        
        rotate(matrix, h1+1, w1+1, h2-1, w2-1);
    }
    
    static void restore(int[][] matrix, int h1, int w1, int h2, int w2){
        if(!(h1 < h2 && w1 < w2)) return;
        int tmp = matrix[h1][w1];//왼쪽 위 임시저장
        for(int w = w1; w < w2; w++){//위
            matrix[h1][w] = matrix[h1][w + 1];
        }
        for(int h = h1; h < h2; h++){//오른쪽
            matrix[h][w2] = matrix[h+1][w2];
        }
        for(int w = w2; w > w1; w--){//아래
            matrix[h2][w] = matrix[h2][w - 1];
        }
        for(int h = h2; h > h1+1; h--){//왼쪽
            matrix[h][w1] = matrix[h-1][w1];
        }
        matrix[h1+1][w1] = tmp;
        restore(matrix, h1+1, w1+1, h2-1, w2-1);
    }
    
    //배열을 복사하는것 보다 재사용하는게 더 빠르다.
    static int solve(int[][] matrix, int[][] operaters){
        
        boolean allOperated = true;
        for(int i = 0; i < operaters.length; i++)
            if(operaters[i][3] == 0){allOperated = false; break;}
            
        if(allOperated) return findMin(matrix);
        
        int min = 5001;
        for(int op = 0; op < operaters.length; op++)
            if(operaters[op][3] == 0){
                operaters[op][3] = 1;

                int r = operaters[op][0];
                int c = operaters[op][1];
                int s = operaters[op][2];
                
                rotate(matrix, r-s, c-s, r+s, c+s);
                
                int result = solve(matrix, operaters);
                min = min < result ? min : result;
                
                operaters[op][3] = 0;
                restore(matrix, r-s, c-s, r+s, c+s);
            }
        return min;
    }
    
}
