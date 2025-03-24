import java.io.*;
import java.util.*;

public class Main {

	static int V, E, P;
	static ArrayList<Node>[] graph; 
	static long [] dist;
	static String ans = "GOOD BYE";
	
	static class Node implements Comparable<Node>{
		
		private int v; 
		private long w;
		
		public Node(int v, long w) {
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			
			if(this.w == o.w)
				return this.v - o.v;
			
			return Long.compare(this.w, o.w);
		}

	}//Node

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		dist = new long [V+1];
		
		graph = new ArrayList[V+1];
		
		for(int i=1; i<=V; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[n1].add(new Node(n2,w));
			graph[n2].add(new Node(n1,w));
			
		}//input 
		

		long oneToV = dij(1,V);
		long oneToP = dij(1,P);
		long PtoV = dij(P,V);
		
		if(oneToV == oneToP + PtoV)
			ans = "SAVE HIM";
		
		System.out.println(ans);
		

		
	}//main 
	
	
	//다익스트라 
	
	public static long dij(int start, int end) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		dist[start] = 0;
		
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			
			Node current = pq.poll();
			
			if(current.v == end)
				return dist[end];
			
			if(current.w > dist[current.v])
				continue;
			
			for(Node next  : graph[current.v]) {
				
				long newDist =  dist[current.v] + next.w;
				
				if(newDist<dist[next.v]) {
					dist[next.v] = newDist;
					pq.add(new Node(next.v,newDist));
				}
				
			}
			
		}
		
		return dist[end];

	}//dij

}
