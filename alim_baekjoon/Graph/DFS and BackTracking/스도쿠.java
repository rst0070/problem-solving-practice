import java.io.*;
import java.util.*;

public class 스도쿠 {
    static int[][] board = new int[9][9];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfZero = 0;
 
        for(int r = 0; r < 9; r++){
            char[] str = br.readLine().toCharArray();
            for(int c = 0; c < 9; c++){
                board[r][c] = (int)(str[c] - '0');
                if(board[r][c] == 0)
                    numOfZero++;
            }
        }


        dfs(0, 0, numOfZero);
    }

    static boolean dfs(int r, int c, int numOfZero) throws Exception{
        if(numOfZero == 0){
            for(r = 0; r < 9; r++){
                for(c = 0; c < 9; c++)  bw.write(board[r][c] + (int)'0');
                bw.write('\n');
            }
            bw.flush();
            return true;
        }
        if(c > 8){  r++; c = 0;}
        if(r > 8) return  false;
        if(board[r][c] != 0) return dfs(r, c+1, numOfZero);


        for(int num = 1; num < 10; num++)
            if(check(r, c, num)){
                board[r][c] = num;
                if(dfs(r, c + 1, numOfZero - 1))    return true;
                board[r][c] = 0;                
            }
        
        return false;
    }

    static boolean check(int r, int c, int num){
        for(int i = 0; i < 9; i++)
            if(board[r][i] == num || board[i][c] == num) return false;
        
        r = r / 3 * 3;
        c = c / 3 * 3;
        for(int i = r; i < r + 3; i++)
            for(int j = c; j < c + 3; j++)
                if(board[i][j] == num) return false;
        
        return true;        
    }
}
