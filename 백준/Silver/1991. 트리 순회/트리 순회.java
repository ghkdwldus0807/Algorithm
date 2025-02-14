import java.util.*;
import java.io.*;

public class Main {
	
	static class Node{
		char value; //자기 자신의 노드 값 
		Node left, right; // 왼쪽 자식 노드, 오른쪽 자식 노드 
		
		
		public Node(char value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	} // Node 
	
	
	public static void addNode(Node parent, char value, char left, char right) {
		if(parent.value == value) {
			if(left != '.')
				parent.left = new Node(left, null, null);
			
			if(right != '.')
				parent.right = new Node(right,null,null);
			
		}else {
			//이 경우 탐색을 통해서 parent.value == value인 경우까지 찾아가야함 
			if(parent.left != null)
				addNode(parent.left, value, left, right);
			
			if(parent.right != null)
				addNode(parent.right, value, left, right);
		}
	}//add Node 
	
	
	//전위 순회, 중위 순회, 후위 순회 메서드 만들기 
	
	public static void preorder(Node node) {
		if(node == null)
			return;
		System.out.print(node.value);
		preorder(node.left);
		preorder(node.right);
	} // preorder 
	
	
	public static void inorder(Node node) {
		if(node == null)
			return;
		inorder(node.left);
		System.out.print(node.value);
		inorder(node.right);
	}//inorder 
	
	
	public static void postorder(Node node) {
		if(node == null)
			return;
		
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.value);
		
	}//postOrder 
	
	
	
	

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Node head = new Node('A',null,null);
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char value = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			addNode(head, value, left, right);
		}
		
		preorder(head);
		System.out.println();
		inorder(head);
		System.out.println();
		postorder(head);
		
		
	}//main

}
