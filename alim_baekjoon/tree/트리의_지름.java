import java.io.*;
import java.util.*;

class Main
{
  /**
   * https://www.acmicpc.net/problem/1967
   * 각 각 서브트리에서 최대값을 구하여 배열에 저장
   * 모두 순회한후 배열에서 최대값탐색.
   *
   * 가장 긴 경로 구하는 방법:
   * 1. 가장 긴 깊이 두개를 잡은 다음 두개를 더한후 루트의 가중치 더하기.
   * 2. 트리의 
   */
    static class Node{
        ArrayList<Weight> paths = new ArrayList<Weight>();
        
        public void addPath(int childNum, int weight){
            paths.add( new Weight( childNum, weight ) );
        }
        
        public Iterator<Weight> iterator(){ return paths.iterator();}
    }
	
	static class Weight{
	    int childNum;
	    Node child = null;
	    final int weight;
	    public Weight(int childNum, int weight){
	        this.childNum = childNum;
	        this.weight = weight;
	    }
	    
	    public Node getChild(){
	        if( child == null ) child = map.get(childNum);
	        return child;
	    }
	}
	
	static HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	static int[] results = new int[10000];
	static int resultPointer = -1;
	
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
	    int N = Integer.parseInt( br.readLine () ) - 1;
	    
	    while( N-- > 0 ){
	        StringTokenizer st = new StringTokenizer( br.readLine() );
	        int nodeNum = Integer.parseInt( st.nextToken() );
	        int childNum = Integer.parseInt( st.nextToken() );
	        int weight = Integer.parseInt( st.nextToken() );
	        
	        Node root;
	        if( map.containsKey(nodeNum) ){ root = map.get(nodeNum); }
	        else{
	            root = new Node();
	            map.put( nodeNum, root );
	        }
	        
	        root.addPath( childNum, weight );
	    }
	    br.close();
	    
	    find( map.get(1) );
	    
	    int max = 0;
	    while( resultPointer > -1){
	        max = max > results[ resultPointer ] ? max : results[ resultPointer ];
	        resultPointer--;
	    }
	    
	    System.out.println( max );
	}
	static int find(Node root){

	    int maxDepth = 0;
	    int maxDepth2 = 0;
	    int tmp;
	    
	    try{
	        Iterator<Weight> it = root.iterator();
	    
	        while(it.hasNext()){
	            Weight w = it.next();
	            tmp = find( w.getChild() ) + w.weight;
	        
	            if( tmp > maxDepth ){ maxDepth2 = maxDepth; maxDepth = tmp;}
	            else if( tmp > maxDepth2 ){ maxDepth2 = tmp; }
	        }
	    }catch( NullPointerException e ){}
	    
	    
	    if( maxDepth == 0 ) return 0;
	    
	    if( maxDepth2 != 0){ results[ ++resultPointer ] = maxDepth + maxDepth2;}
	    else{ results[ ++resultPointer ] = maxDepth; }
	    return maxDepth;
	}
}
