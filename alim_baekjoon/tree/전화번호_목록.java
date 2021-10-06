import java.io.*;
//https://www.acmicpc.net/problem/5052
class Main
{
  /**
   * 전화번호의 각 자리를 노드로 간주하여 전화번호 목록에 대한 트리를 만든다.
   * 이때 잎의 개수와 전화번호의 개수가 일치하면 서로 접두어가 되는 경우가 없는경우이다.
   */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
		int testCase = Integer.parseInt( br.readLine() );
		while(testCase-- > 0){
		    
		    int N = Integer.parseInt( br.readLine() );
		    Node root = new Node();
		    
		    //N개의 전화번호 처리
		    for(int i = 0; i < N; i++){
		        Node node = root;
		        char[] number = br.readLine().toCharArray();
		        //각 번호 자리에 대해 노드생성
		        for(int j = 0; j < number.length; j++){
		            
		            int c = number[j] - '0';
		            if( node.child[ c ] == null ) node.child[ c ] = new Node();
		            node = node.child[c];
		        }
		    }
		    
		    //트리의 잎개수 구하기
		    String result = "";
		    if( countLeap(root) == N ) result = "YES\n";
		    else result = "NO\n";
		    
		    bw.write(result, 0, result.length());
		}
	    
		br.close();
		bw.flush();
		bw.close();
	}
	
   static class Node{
       Node[] child = new Node[10];
   }
   
   static int countLeap(Node root){

        int result = 0;
        for(int i = 0; i < 10; i++)
            if(root.child[i] != null)    result += countLeap(root.child[i]);
            
        if( result == 0 ) return 1;
        return result;
   }
}
