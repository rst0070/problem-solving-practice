import java.io.*;
import java.util.*;

public class Main
{
    
    /**
     * https://www.acmicpc.net/problem/1167
     * 어떤 노드도 루트로 간주해도 가능하다
     * 트리로 간주하고 탐색을 할때 재귀로 진행할것.
     * 이때 직전의 노드 번호를 알려줌으로써 탐색의 역행을 막는다. 
     * 
     */
    static Node[] nodes = new Node[100001];
    static int V;
	public static void main(String[] args) throws Exception{
	    
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		V = Integer.parseInt( br.readLine() );
		for(int i = 1; i <= V; i++){
		    StringTokenizer st = new StringTokenizer( br.readLine() );
		    int nodeNum = Integer.parseInt( st.nextToken() );
		    
		    nodes[ nodeNum ] = new Node( nodeNum );
		    
		    int value;
		    while( ( value = Integer.parseInt( st.nextToken() ) ) != -1 ){
		        nodes[ nodeNum ].addPath( value, Integer.parseInt( st.nextToken() ) );
		    }
		}
		
		find( nodes[1], -1);
		int max = 0;
		for(int i = 0; i <= pointer; i++){
		    max = max > results[i] ? max : results[i];
		}
		
		System.out.println(max);
	}
	
	static int[] results = new int[100000];
	static int pointer = -1;
  /**
   * 잎-잎
   * 잎-서브트리의 루트
   */
	static int find(Node tree, int parentNum ){
	    
	    int max1 = 0;
	    int max2 = 0;
	    int subLevel;
	    try{
	        Iterator<Path> it = tree.getPathIterator();
	        while( it.hasNext() ){
	            Path p = it.next();
	            if( p.childNum == parentNum ) continue;
	        
	            subLevel = find( nodes[ p.childNum ], tree.num ) + p.weight;
	        
	            if( max1 < subLevel ){ max2 = max1; max1 = subLevel; }
	            else if( max2 < subLevel ){ max2 = subLevel; }
	        }
	    }catch(NullPointerException e){}
	    
	    
	    if( max1 == 0 ) return 0;
	    results[++pointer] = max1 + max2;
	    return max1;
	}
	
	static class Path {
	    int childNum;
	    int weight;
	    public Path(int childNum, int weight){
	        this.childNum = childNum;
	        this.weight = weight;
	    }
	}
	
	
	static class Node {
	    int num;
	    ArrayList<Path> paths = new ArrayList<Path>();
	    
	    public Node(int num){ this.num = num; }
	    
	    public void addPath(int childNum, int weight){
	        paths.add( new Path( childNum, weight ) );
	    }
	    
	    public Iterator<Path> getPathIterator(){
	        return paths.iterator();
	    }
	}
}
