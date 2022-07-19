import java.io.*;
import java.util.*;

class 친구_네트워크4195{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            solve();
        }
        bw.flush();
    }

    //name to id
    static HashMap<String, Integer> idMap;

    static int[] parent;
    static int[] size;

    static void solve() throws Exception{
        idMap = new HashMap<String, Integer>();
        int F = Integer.parseInt(br.readLine());

        parent = new int[2*F]; 
        size = new int[2*F];
        for(int i = 0; i < 2*F; i++){parent[i] = i;size[i] = 1;}

        int id = 0;
        while(F-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
    
            int aId = id;
            int bId = id;
            
            if(idMap.containsKey(a)) aId = idMap.get(a);
            else{
                idMap.put(a, aId);
                bId = ++id;
            }

            if(idMap.containsKey(b)) bId = idMap.get(b);
            else{
                idMap.put(b, bId);
                ++id;
            }

            bw.write(union(aId, bId)+"\n");
        }
        
    }

    static int find(int node){
        if(parent[node] == node) return node;
        return find(parent[node]);
    }

    static int union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return size[a];

        //연결이 안된경우만 연결
        parent[b] = a;
        return (size[a] += size[b]);
    }

    
}