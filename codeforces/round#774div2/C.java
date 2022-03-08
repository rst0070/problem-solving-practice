import java.io.*;
import java.util.*;

public class C {
    /**
     * 펙토리얼인지 확인후 아니면 가장 가까운 power num으로 합 구하기.
     */
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        while(TC-- > 0){
            long n = Long.parseLong(br.readLine());
            int i = powerNum.size() - 1;
            long result = find(n, i);
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }
    static final long MAX = 1000_000_000_000L;
    static ArrayList<Long> powerNum = new ArrayList<Long>();
    static{
        long way1 = 1;
        while(way1 <= MAX){
            powerNum.add(way1);
            way1 *= 2;
        }

        long way2 = 6;
        for(long i = 4; way2 <= MAX; i++){
            powerNum.add(way2);
            way2 *= i;
        }

        Collections.sort(powerNum);

        Iterator<Long> it = powerNum.iterator();
        while(it.hasNext()) System.out.println(it.next());
    }
    
    static long find(long n, int idx){
        if(n == 0) return 0;
        if(idx < 0) return -1;

        long adj = powerNum.get(idx);
        while(idx > 0 && adj > n){
            adj = powerNum.get(--idx);
        }

        long result = find(n - adj, idx - 1);
        if(result == -1) return -1;

        return 1 + result;
    }


}
