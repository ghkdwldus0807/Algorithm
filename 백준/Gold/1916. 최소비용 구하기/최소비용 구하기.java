import java.util.*;
import java.io.*;

public class Main {
	
	static int N,M, start, end; //도시개수, 버스 개수, 출발지, 도착지
	static ArrayList<Node> [] graph;
	static long [] dist;
	static boolean[] visited;
	
	
	static class Node implements Comparable<Node>{
		
		private int v; 
		private int w; 
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w; 
		}
		
		@Override
		public int compareTo(Node o1) {
			if(this.w == o1.w)
				return this.v-o1.v;
			
			return this.w - o1.w;
		}
		
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		dist = new long[N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<Node>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		StringTokenizer st;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[n1].add(new Node(n2, w));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		//input 
		
		dij(start);
		
		System.out.println(dist[end]);
		
		

	}//main 
	
	
	//다익스트라 
	
	static void dij(int start) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		dist[start] = 0;
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			
			Node current = pq.poll();
			
			if(visited[current.v])
				continue;
			
			visited[current.v] = true;
			
			for(Node next : graph[current.v]) {
				
				if(dist[next.v]<current.w + next.w)
					continue;
				
				dist[next.v] = current.w+next.w;
				pq.add(new Node(next.v, current.w+next.w));

			}

		}
		
		
	}//dij

}
