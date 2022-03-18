import java.io.*;
import java.util.*;

public class 문자열_폭발 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        char[] exp = br.readLine().toCharArray();
        Stack<Character> result = new Stack<Character>();
        Stack<Character> tmp = new Stack<Character>();

        for(int i = 0; i < str.length; i++){
            result.push(str[i]);
            
            for(int j = exp.length - 1; j > -1; j--){
                if(result.isEmpty() || !result.peek().equals(exp[j]))break;
                tmp.push(result.pop());
            }

            if(tmp.size() == exp.length) tmp.clear();

            while(!tmp.isEmpty())
                result.push(tmp.pop());
        }
        
        String ans = getResult(result).toString();
        if(ans.length() < 1) ans = "FRULA";

        System.out.println(ans);

    }

    static StringBuilder getResult(Stack<Character> stack){
        if(stack.isEmpty()) return new StringBuilder();
        char c = stack.pop();
        return getResult(stack).append(c);
    }
}
