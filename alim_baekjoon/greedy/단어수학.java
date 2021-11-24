import java.io.*;
import java.util.*;
// https://www.acmicpc.net/problem/1339
class Main{

    /**
     * 수의 길이만 생각하는것이 아니라
     * 각 문자가 몇번 곱해지는지에 따라 정렬.
     */
    static int N;
    static int[] weights = new int[26];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            char[] word = br.readLine().toCharArray();
            
            for(int j = 0; j < word.length; j++){
                weights[ word[j] - 'A' ] += powOfTen(word.length - j - 1);
            }
        }
        Arrays.sort(weights);

        int result = 0;
        int mul = 9;
        for(int i = 25; mul >= 0; i--){
            result += weights[i] * mul;
            mul --;
        }

        System.out.println(result);
        br.close();
        

        
    }

    //returns 10 pow n
    static int powOfTen(int n){
        int result = 1;
        while(n > 0){
            result *= 10;
            n--;
        }
        return result;
    }


}
