import java.util.*;
import java.io.*;
//https://www.acmicpc.net/problem/1991
class Main
{
    static Node[] nodes;
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out) );
    	
    	int N = Integer.parseInt(br.readLine());
    	nodes = new Node[N];
    	for(int i = 0; i < N; i++){
    	    String line = br.readLine();
    	    char root = line.charAt(0);
    	    nodes[root-'A'] = new Node(root, line.charAt(2), line.charAt(4));
    	}
    	
    	System.out.println( preorder(nodes[0]) );
    	System.out.println( inorder(nodes[0]) );
    	System.out.println( postorder(nodes[0]) );
	}

    static String preorder(Node root){
        Node left = root.getLeft();
        Node right = root.getRight();
        
        String result = root.root+"";
        if(left!=null) result += preorder(left);
        if(right!=null) result += preorder(right);
        return result;
    }
    
    static String inorder(Node root){
        Node left = root.getLeft();
        Node right = root.getRight();
        
        String result = "";
        if(left!=null) result += inorder(left);
        result += root.root;
        if(right!=null) result += inorder(right);
        return result;
    }
    
    static String postorder(Node root){
        Node left = root.getLeft();
        Node right = root.getRight();
        
        String result = "";
        if(left!=null) result += postorder(left);
        if(right!=null) result += postorder(right);
        result += root.root;
        return result;
    }
    
	static class Node{
	    char root, left, right;
	    public Node(char root, char left, char right){
	        this.root = root;
	        this.left = left;
	        this.right = right;
	    }
	    public Node getLeft(){
	        if(left == '.') return null;
	        return nodes[left-'A'];
	    }
	    public Node getRight(){
	        if(right == '.') return null;
	        return nodes[right-'A'];
	    }
	}
	
}
