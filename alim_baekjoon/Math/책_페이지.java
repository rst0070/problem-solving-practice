import java.util.*;
import java.io.*;

public class 책_페이지 {


    /**
     * 각 숫자의 1의 자리를 주목하면 답이 보인다.
     * 10 11 12 13 14 15 16 17 18 19
     * 20 21 22 23 24 25 26 27 28 29
     * 30 31 32 33 34 35 36 37 38 39
     * 
     * 이런식으로 숫자를 1의자리가 0부터 9까지인 것으로 정렬한다면
     * 몇행으로 위와같이 정렬할 수 있느냐에 따라 각 0부터 9까지의 숫자가 1의자리에 얼마나 나오는지 정해진다.
     * 또한 각 숫자를 /10하면 그 위의 자리수도 똑같이 구할 수 있다.
     * 이 아이디어를 이용해 숫자를 위의 형태로 만든다.
     */

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        solve(1, n, 1);

        for(int i = 0; i < 10; i++)
            System.out.print(ans[i] + " ");
    }

    static int[] ans = new int[10];

    static void solve(int start, int end, int time){
        while(start%10 != 0 && start <= end){
            solveByBrute(start, time);
            start++;
        }

        if(start > end) return;

        while(end%10 != 9 && end >= start){
            solveByBrute(end, time);
            end--;
        }

        int add = (end/10 - start/10 + 1) * time;
        for(int i = 0; i < 10; i++) ans[i] += add;
        
        solve(start / 10, end / 10, time * 10);
    }

    static void solveByBrute(int num, int time){
        while(num > 0){
            ans[num % 10] += time;
            num = num /10;
        }
    }
    
}
