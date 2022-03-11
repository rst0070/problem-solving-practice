import java.io.*;
import java.util.*;

public class A {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0){
            int result = 0;
            
            ArrayList<Long> list1 = new ArrayList<Long>();
            LinkedList<Long> list2 = new LinkedList<Long>();
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());

            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                long num = Long.parseLong(st.nextToken());
                list1.add(num);
            }
            Collections.sort(list1);
            int idx = 0;
            while(idx < n){
                long num = list1.get(idx);
                if(list2.isEmpty()){list2.add(num); idx++;}
                else if(list2.peek()*x == num){ list2.poll(); idx++; }
                else if(list2.peek()*x < num){ list2.poll(); result++;}
                else{list2.add(num); idx++;}
            }
            result += list2.size();
            bw.write(result+"\n");
        }
        bw.flush();
    }    
    static final int LIMIT = 1000000000;
}
