import java.io.*;
import java.util.*;

public class 크로아티아_알파벳 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();

        int count = 0;
        for(int i = 0; i < str.length;){
            if(i+2 >= str.length){count++; i++; continue;}
            if(str[i] == 'c'){
                if(str[i+1] == '=')i++;
                else if(str[i+1] == '-')i++;
            }else if(str[i] == 'd'){
                if(i+2 < str.length && str[i+1] == 'z' && str[i+2] == '=')i += 2;
                else if(str[i+1] == '-')i++;
            }else if(str[i] == 'l' && str[i+1] == 'j')i++;
            else if(str[i] == 'n' && str[i+1] == 'j')i++;
            else if(str[i] == 's' && str[i+1] == '=')i++;
            else if(str[i] == 'z' && str[i+1] == '=')i++;
            count++;
            i++;
        }

        System.out.println(count);
    }
}
