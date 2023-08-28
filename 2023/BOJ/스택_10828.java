import java.io.*;
import java.util.StringTokenizer;

public class 스택_10828{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;// = new StringTokenizer();

        int N = Integer.parseInt(br.readLine());
        int[] stack = new int[N];
        int size = 0;

        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("top")){
                bw.write(size == 0 ? "-1\n" : stack[size - 1]+"\n");
                continue;
            }

            if(command.equals("empty")){
                bw.write(size == 0 ? "1\n" : "0\n");
                continue;
            }

            if(command.equals("size")){
                bw.write(size + "\n");
                continue;
            }

            if(command.equals("pop")){
                bw.write(size == 0 ? "-1\n" : stack[--size]+"\n");
                continue;
            }

            int num = Integer.parseInt(st.nextToken());
            stack[size++] = num;
        }
        br.close();
        bw.flush();
        bw.close();

    }
}