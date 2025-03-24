import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m;
	static ArrayList<Node>[] graph; 
	static int[] prev;
	static int[] dist;
	static StringBuilder sb = new StringBuilder();
	
	static class Node implements Comparable<Node> {
		private int v;
		private int w;
		
		public Node (int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			
			if(this.w == o.w)
				return this.v - o.v;
			
			return this.w - o.w;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n+1];

		prev = new int[n+1];
		dist = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}//init
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[n1].add(new Node(n2,w));
			graph[n2].add(new Node(n1,w));
			
		}//input
		
		for(int i=1; i<=n; i++) {
			Arrays.fill(dist, Integer.MAX_VALUE);
			dij(i);
			
			for(int j=1; j<=n; j++) {
				if(i==j)
					sb.append("- ");
				else
					sb.append(prev[j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
		

	}//main 

	
	static void dij(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		dist[start] = 0;
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			
			Node current = pq.poll();

			
			if(dist[current.v]<current.w)
				continue;
			
			for(Node next : graph[current.v]) {
				
				int newDist = dist[current.v] + next.w;
				
				if(dist[next.v]>newDist) {
					
					dist[next.v] = newDist;
					pq.add(new Node(next.v, newDist));
					
					if(current.v == start ) {
						prev[next.v] = next.v;
					}
					else 
						prev[next.v] = prev[current.v];
				}
				
			}
			
			
		}
		
	}

}
