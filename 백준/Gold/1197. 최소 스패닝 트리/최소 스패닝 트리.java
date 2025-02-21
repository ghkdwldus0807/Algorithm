import java.io.*;
import java.util.*;

public class Main {
	
	
	static class Node implements Comparable<Node> {

		int a, b, weight;
		
		public Node(int a, int b, int weight) {
			this.a = a;
			this.b = b;
			this.weight = weight;
		}
		
		
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
		
	}

	
	static int v, e; 
	static int [] parent; 
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static int ans = 0 ;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		parent = new int [v+1];
		
		for(int i=1; i<=v; i++ ) {
			parent[i] = i;
		}
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			pq.add(new Node(a,b,w));
			
		}
		
		for(int i=0; i<e; i++) {
			
			Node node = pq.poll();
			
			int a = node.a;
			int b = node.b;
			int w = node.weight;
			
			
			if(isSameParent(a, b))
				continue;
			else {
				union(a,b);
				ans += w;
			}
			

		}
		
		
		System.out.println(ans);
		
		
	}//main 
	
	
	static int find(int index) {
		if(index == parent[index])
			return index;
		
		return parent[index] = find(parent[index]);
	}//find 
	
	
	static void union(int a, int b) {
		
		int pa = find(a);
		int pb = find(b);
		
		if(pa>pb)
			parent[pa] = pb;
		else 
			parent[pb] = pa;
	}//union 
	
	
	static boolean isSameParent(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa==pb)
			return true;
		
		return false;
		
	}//isSameParent

}
