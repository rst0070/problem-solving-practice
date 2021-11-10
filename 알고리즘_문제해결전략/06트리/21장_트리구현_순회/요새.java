
import java.io.*;
import java.util.*;

class Main{

    static class Rampart{
        //요새내부의 성벽들(한겹만 인정)
        LinkedList<Rampart> childs = new LinkedList<Rampart>();
        public Rampart(int x, int y, int r){

        }

        void addChild(Rampart child){
            childs.add(child);
        }
    }

    static Rampart[] ramparts;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0){
            int n = Integer.parseInt(br.readLine());
            ramparts = new Rampart[n];

            StringTokenizer st;
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                ramparts[i] = new Rampart(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
        }
    }

    static void findChilds(Rampart parent){

    }
    
}