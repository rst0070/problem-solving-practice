package codejam2020;
import java.io.*;
import java.util.Stack;
public class PascalWalk {
    static int[][] map = new int[502][502];
    static boolean[][] visited = new boolean[502][502];
    static Stack<String> ans = new Stack<String>();
    static int value(int r, int k){
        if(r == k || k == 1)return 1;
        if(map[r][k] > 0)return map[r][k];
        return (map[r][k] = value(r-1, k-1) + value(r-1, k));
    }
    static boolean position(int n, int count, int sum, int r, int k){
        if(count > 500 || r < 1 || k < 1 || k > r || visited[r][k])return false;
        
        sum += value(r, k);
        if(sum == n){
            ans.push(r+" "+k);
            return true;
        }

        if(sum > n)return false;
        count++;
        if(position(n,count, sum, r - 1, k - 1) || position(n,count, sum, r + 1, k)
        || position(n,count, sum, r, k - 1) || position( n,count, sum, r + 1, k + 1)
        || position(n,count, sum, r - 1, k) || position(n,count, sum, r, k + 1)){
            ans.push(r+" "+k);
            return true;
        }
        return false;
    }
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, tc = Integer.parseInt(br.readLine());
        for(int t=1; t <= tc; t++){
            n = Integer.parseInt(br.readLine());
            System.out.println("Case #"+t+":");
            position(n,1, 0, 1, 1);
            while(!ans.isEmpty())System.out.println(ans.pop());
            for(int i=1; i <502; i++)
                for(int j = 1; j < 502; j++)
                    visited[i][j] = false;
        }
    }
}