package codejam2020;
import java.io.*;
public class PatternMatching {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int N, j;
        char c;
        char[] list;
        boolean check;
        String[] P;
        String p, s1, s2;
        for(int t = 1; t <= tc; t++){
            list = new char[100];
            N = Integer.parseInt(br.readLine());
            check = true;
            for(int i=0; i < N; i++){
                p = br.readLine();
                if(p.charAt(0)=='*'){
                    //if(s2.length() > p.length()){
                        
                    //}
                }
                if(p.charAt(p.length()-1)=='*'){

                }
                P = br.readLine().split("*");
                System.out.println(P.length);

            }
            /*
            if(check){
                P = "";
                for(j = 0; j < 100 && list[j]!=0; j++)P = P + list[j];
                tmp = "";
                for(j = 0; j < 100 && list[99-j]!=0; j++)tmp = list[99-j]+tmp;
                System.out.println("Case #"+t+": "+P+tmp);
            }else{
                System.out.println("Case #"+t+": *");
            }*/
            
        }
        br.close();
    }

}