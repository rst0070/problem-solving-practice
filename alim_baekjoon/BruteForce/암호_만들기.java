import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class 암호_만들기
{
    //암호 만들기 1759번
    /**
     * 조합을 재귀호출을 이용해서 만드는 방법을 익히기 좋은 문제.
     * 처음에 자음2개 모음2개 조건이 주어져서 초기에 이 조건을 만들어 놓고 시작하려했으나
     * 그냥 조합을 다 만들어 본 다음에 최초조건이 맞는지 확인하는 방법 또한 시간이 오래걸리지
     * 않는다는것을 알게됨.
     */
     
    //최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());//뽑아야할 문자의 수
		int C = Integer.parseInt(st.nextToken());//암호에 들어갈 수 있는 문자들 개수
        
        String tmp = "";
        st = new StringTokenizer(br.readLine());
        for(int i=0; i < C; i++){
            char c = st.nextToken().charAt(0);
            tmp += c;
        }
        
        char[] str = tmp.toCharArray();
        Arrays.sort(str);
        
        find(str, C, L, -1, "");
	}
	//cCl
	static void find(char[] str, int c, int l, int prevNum, String list){
	    if(l == 0){
	        int moNum = 1;
	        int zaNum = 2;
	        char[] listA = list.toCharArray();
	        for(int i = 0; i < listA.length; i++){
	            switch(listA[i]){
	                case 'a':
	                    moNum--;break;
	                case 'i':
	                    moNum--;break;
	                case 'e':
	                    moNum--;break;
	                case 'o':
	                    moNum--;break;
	                case 'u':
	                    moNum--;break;
	                default:
	                    zaNum--;break;
	            }
	        }
	        
	        if(moNum <= 0 && zaNum <= 0){
	            System.out.println(list);
	        }
	        return;
	    }
	    
	    for(int i = prevNum+1;  i < c; i++){
	        find(str, c, l-1, i, list+str[i]);
	    }
	}
	
}



