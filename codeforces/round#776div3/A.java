import java.io.*;
import java.util.*;
public class A {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(tc-- > 0){
            char[] str = br.readLine().toCharArray();
            char c = br.readLine().charAt(0);
            String result = "NO";
            for(int i = 0; i < str.length; i++)
                if(str[i] == c && i % 2 == 0){result = "YES"; break;}
            sb.append(result + '\n');
        }
        System.out.println(sb.toString());
    }
}
