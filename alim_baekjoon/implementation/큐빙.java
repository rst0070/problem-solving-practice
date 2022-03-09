import java.io.*;
import java.util.*;
public class 큐빙 {
    
    public static void main(String[] args) throws Exception{
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            Cube cube = new Cube();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(n-- > 0){
                String order = st.nextToken();
                switch(order){
                    case "L+": cube.left('+'); break;
                    case "L-": cube.left('-'); break;
                    case "R+": cube.right('+'); break;
                    case "R-": cube.right('-'); break;
                    case "U+": cube.up('+'); break;
                    case "U-": cube.up('-'); break;
                    case "D+": cube.down('+'); break;
                    case "D-": cube.down('-'); break;
                    case "F+": cube.front('+'); break;
                    case "F-": cube.front('-'); break;
                    case "B+": cube.back('+'); break;
                    case "B-": cube.back('-'); break;
                }
            }
            
            cube.print();
        }
        bw.flush();
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static class Cube{
        /**
         *       9 8 7
         *       6 5 4
         *       3 2 1
         * 7 4 1 1 2 3 3 6 9
         * 8 5 2 4 5 6 2 5 8
         * 9 6 3 7 8 9 1 4 7
         *       1 2 3
         *       4 5 6
         *       7 8 9
         *       1 2 3
         *       4 5 6
         *       7 8 9
         */
        char[] U = { ' ', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w' };
        char[] D = { ' ', 'y', 'y', 'y', 'y', 'y', 'y', 'y', 'y', 'y' };
        char[] L = { ' ', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g' };
        char[] R = { ' ', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };
        char[] F = { ' ', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r' };
        char[] B = { ' ', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o' };
        void print() throws Exception{
            for(int i = 1; i <= 7;){
                bw.write(String.format("%c%c%c\n", U[i++], U[i++], U[i++]));
            }
        }
        void rotate(Iterator<String> pos, Iterator<Character> col){
            while(pos.hasNext()){
                String position = pos.next();
                char color = col.next();

                int num = (int)(position.charAt(1) - '0');
                switch(position.charAt(0)){
                    case 'U':
                    U[num] = color; break;
                    case 'D':
                    D[num] = color; break;
                    case 'L':
                    L[num] = color; break;
                    case 'R':
                    R[num] = color; break;
                    case 'F':
                    F[num] = color; break;
                    case 'B':
                    B[num] = color; break;
                    default: break;
                }
            }
        }
        static final List<String> posUpP = List.of("R3", "R2", "R1", "F3", "F2", "F1", "L3", "L2", "L1", "B3", "B2", "B1", "U3", "U6", "U9", "U8", "U7", "U4", "U1", "U2");
        static final List<String> posUpM = List.of("L3", "L2", "L1", "B3", "B2", "B1", "R3", "R2", "R1", "F3", "F2", "F1", "U7", "U4", "U1", "U2", "U3", "U6", "U9", "U8");
        void up(char d){ 
            List<Character> color = List.of(B[3], B[2], B[1], R[3], R[2], R[1], F[3], F[2], F[1], L[3], L[2], L[1],
                U[1], U[2], U[3], U[6], U[9], U[8], U[7], U[4]);
            Iterator<String> pos = null;
            if(d == '+') pos = posUpP.iterator();
            else pos = posUpM.iterator();
            rotate(pos, color.iterator());
        }

        static final List<String> posDownP = List.of("R7", "R8", "R9", "B7", "B8", "B9", "L7", "L8", "L9", "F7", "F8", "F9", "D3", "D6", "D9", "D8", "D7", "D4", "D1", "D2");
        static final List<String> posDownM = List.of("L7", "L8", "L9", "F7", "F8", "F9", "R7", "R8", "R9", "B7", "B8", "B9", "D7", "D4", "D1", "D2", "D3", "D6", "D9", "D8");
        void down(char d){ 
            List<Character> color = List.of(F[7], F[8], F[9], R[7], R[8], R[9], B[7], B[8], B[9], L[7], L[8], L[9],
                D[1], D[2], D[3], D[6], D[9], D[8], D[7], D[4]);
            Iterator<String> pos = null;
            if(d == '+') pos = posDownP.iterator();
            else pos = posDownM.iterator();
            rotate(pos, color.iterator());
        }

        static final List<String> posLeftP = List.of("F1", "F4", "F7", "D1", "D4", "D7", "B9", "B6", "B3", "U1", "U4", "U7", "L3", "L6", "L9", "L8", "L7", "L4", "L1", "L2");
        static final List<String> posLeftM = List.of("B9", "B6", "B3", "U1", "U4", "U7", "F1", "F4", "F7", "D1", "D4", "D7", "L7", "L4", "L1", "L2", "L3", "L6", "L9", "L8");
        void left(char d){ 
            List<Character> color = List.of(U[1], U[4], U[7], F[1], F[4], F[7], D[1], D[4], D[7], B[9], B[6], B[3],
                L[1], L[2], L[3], L[6], L[9], L[8], L[7], L[4]);
            Iterator<String> pos = null;
            if(d == '+') pos = posLeftP.iterator();
            else pos = posLeftM.iterator();
            rotate(pos, color.iterator());
        }

        static final List<String> posRightP = List.of("B1", "B4", "B7", "D9", "D6", "D3", "F9", "F6", "F3", "U9", "U6", "U3", "R3", "R6", "R9", "R8", "R7", "R4", "R1", "R2");
        static final List<String> posRightM = List.of("F9", "F6", "F3", "U9", "U6", "U3", "B1", "B4", "B7", "D9", "D6", "D3", "R7", "R4", "R1", "R2", "R3", "R6", "R9", "R8");
        void right(char d){
            List<Character> color = List.of(U[9], U[6], U[3], B[1], B[4], B[7], D[9], D[6], D[3], F[9], F[6], F[3],
                R[1], R[2], R[3], R[6], R[9], R[8], R[7], R[4]);
            Iterator<String> pos = null;
            if(d == '+') pos = posRightP.iterator();
            else pos = posRightM.iterator();
            rotate(pos, color.iterator());
        }

        static final List<String> posFrontP = List.of("R1", "R4", "R7", "D3", "D2", "D1", "L9", "L6", "L3", "U7", "U8", "U9", "F3", "F6", "F9", "F8", "F7", "F4", "F1", "F2");
        static final List<String> posFrontM = List.of("L9", "L6", "L3", "U7", "U8", "U9", "R1", "R4", "R7", "D3", "D2", "D1", "F7", "F4", "F1", "F2", "F3", "F6", "F9", "F8");
        void front(char d){
            List<Character> color = List.of(U[7], U[8], U[9], R[1], R[4], R[7], D[3], D[2], D[1], L[9], L[6], L[3],
                F[1], F[2], F[3], F[6], F[9], F[8], F[7], F[4]);
            Iterator<String> pos = null;
            if(d == '+') pos = posFrontP.iterator();
            else pos = posFrontM.iterator();
            rotate(pos, color.iterator());
        }

        static final List<String> posBackP = List.of("L1", "L4", "L7", "D7", "D8", "D9", "R9", "R6", "R3", "U3", "U2", "U1", "B3", "B6", "B9", "B8", "B7", "B4", "B1", "B2");
        static final List<String> posBackM = List.of("R9", "R6", "R3", "U3", "U2", "U1", "L1", "L4", "L7", "D7", "D8", "D9", "B7", "B4", "B1", "B2", "B3", "B6", "B9", "B8");
        void back(char d){
            List<Character> color = List.of(U[3], U[2], U[1], L[1], L[4], L[7], D[7], D[8], D[9], R[9], R[6], R[3],
                B[1], B[2], B[3], B[6], B[9], B[8], B[7], B[4]);
            Iterator<String> pos = null;
            if(d == '+') pos = posBackP.iterator();
            else pos = posBackM.iterator();
            rotate(pos, color.iterator());
        }
    }
}
