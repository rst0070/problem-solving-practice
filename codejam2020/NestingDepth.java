package codejam2020;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class NestingDepth {

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i, tmp, n, status, tc = Integer.parseInt(br.readLine());
        char c;
        String S, answer;
        for(int t = 1; t <= tc; t++){
            S = br.readLine();
            answer = "";
            status = 0;
            for(i = 0; i < S.length(); i++){
                c = S.charAt(i);
                n = c-'0';
                //openning
                if(status < n)
                    for(tmp = status; tmp < n; tmp++)answer  = answer + '(';
                status = n;
                //insert number
                answer = answer + c;
                //closing
                if(i == S.length()-1){
                    for(tmp = 0; tmp < n; tmp++)answer  = answer + ')';
                    break;
                }

                tmp = c - S.charAt(i+1);
                if(tmp > 0)
                    for(; tmp > 0; tmp--)answer  = answer + ')';
            }
            System.out.println("Case #"+t+": "+answer);
        }
        br.close();
    }

}