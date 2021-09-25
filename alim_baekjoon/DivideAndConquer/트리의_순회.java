import java.util.Scanner;

public class 트리의_순회 {
    //백준 2263번 메모리 초과해결.
    // String으로 출력을 저장하지 않고 바로 print하니 해결됨.
    static int[] in = new int[100000];
    static int[] post = new int[100000];
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for(int i = 0; i < n; i++)  in[i] = s.nextInt();
        for(int i = 0; i < n; i++)  post[i] = s.nextInt();
        s.close();

        preorder(0, n-1, 0, n-1);
        System.out.println();
        
    }


    static void preorder(int ih, int it, int ph, int pt){
        if( ih > it || ph > pt) return;

        int rootValue = post[pt];

        int left = 0;
        while(in[ih+left] != rootValue)left++;

        System.out.print(rootValue+" ");
        preorder(ih, ih + left - 1, ph, ph + left - 1);
        preorder(ih + left + 1, it, ph + left, pt - 1);
        
    }
}
