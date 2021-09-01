import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class 주사위_윷놀이{
    /**
     * 주사위 윷놀이
     * 17825번
     * 2(0,0)     도착(0,4)
     * 4(1,0)           40 38 36
     * 6           35          34
     * 8           30          32
     * 10 13 16 19 25 26 27 28 30
     * 12          24          28
     * 14          22          26
     *       16 18 20 22 24
     * 일차원적으로 지점별 번호매김.
     * board[i][0]: 점수
     * board[i][1]: i를 경유할때 다음위치
     * board[i][2]: i에서 시작할때 다음위치
     */
    static int[][] board = new int[33][3];
    static{
        
        for(int i = 0; i < 21; i++){
            board[i][0] = 2*i;
            board[i][1] = i+1;
            board[i][2] = i+1;
        }
        board[5][2] = 22;
        board[10][2] = 28;
        board[15][2] = 30;
        
        board[21][0] = 0;//도착지점
        
        board[22][0] = 13;
        board[23][0] = 16;
        board[24][0] = 19;
        board[25][0] = 25;
        board[26][0] = 30;
        board[27][0] = 35;
        for(int i = 22; i < 27; i++){board[i][1] = i+1;board[i][2] = i+1;}
        board[27][1] = 20; board[27][2] = 20;
        
        board[28][0] = 22; board[28][1] = 29; board[28][2] = 29;
        board[29][0] = 24; board[29][1] = 25; board[29][2] = 25;
        board[30][0] = 28; board[30][1] = 31; board[30][2] = 31;
        board[31][0] = 27; board[31][1] = 32; board[31][2] = 32;
        board[32][0] = 26; board[32][1] = 25; board[32][2] = 25;
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dice = new int[10];
        for(int i = 0; i < 10; i++) dice[i] = Integer.parseInt(st.nextToken());
            
        int[] position = {0, 0, 0, 0};
        int[] isOn = new int[33];
        isOn[0] = 4;
        for(int i=1; i < 33; i++) isOn[i] = 0;
        
        System.out.println(solve(dice, 0, position, isOn));
        br.close();
    }
    
    static int solve(int[] dice, int turn, int[] position, int[] isOn){
        if(turn > 9) return 0;
        
        boolean onDestination = true;
        for(int i=0; i < 4; i++)
            if(position[i] != 21){onDestination = false; break;}
        if(onDestination) return 0;
        
        int max = 0;
        for(int i = 0; i < 4; i++){
            if(position[i] == 21) continue;//도착지점에선 이동불가
            
            int test = move(position[i], dice[turn]);
            if(test != 21 && isOn[ test ] > 0)continue; //도착지점이 아닌곳에 다른 말이 있으면 해당위치로 이동불가.
            
            //위치변경
            int prevP = position[i];
            position[i] = test;
            
            //이동
            isOn[ prevP ]--;
            isOn[ test ]++;
            
            int result = board[ position[i] ][0] + solve(dice, turn+1, position, isOn);
            max = max > result ? max : result;
            
            //원상복귀
            position[i] = prevP;
            isOn[ prevP ]++;
            isOn[ test ]--;
        }
        return max;
    }
    
    static int move(int startPosition, int diceNumber){
        int next = board[startPosition][2];
        diceNumber--;
        while(diceNumber-- > 0){
            if(next == 21) break;//도착지점에선 이동불가
            next = board[next][1];
        }
        return next;
    }
    

}
