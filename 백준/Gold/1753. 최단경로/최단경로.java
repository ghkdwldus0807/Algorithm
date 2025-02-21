import java.io.*;
import java.util.*;


public class Main {
	
	static class Node implements Comparable<Node>{

		int vertex;
		int weight; 
		
		public Node(int v, int w){
			this.vertex = v;
			this.weight = w;
		}
		
		
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
		
		
	}
	
	
	static int[] dist; 
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int start,v,e; 
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		dist = new int[v+1];
		visited = new boolean[v+1];
		start = Integer.parseInt(br.readLine());
		
		for(int i=0; i<=v; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(n1).add(new Node(n2,w));
			
		}//인접리스트 이용하여 그래프 입력 받기 
		
		for(int i=0; i<=v; i++) {
			dist[i] = INF;
		}
		
		dijkstra(start);
		
		for(int i=1; i<=v ; i++) {
			if(dist[i] == INF)
				System.out.println("INF");
			else System.out.println(dist[i]);
		}

	}//main 
	
	
	static void dijkstra(int start) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(start,0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			
			Node nowVertex = pq.poll();
			
			if(visited[nowVertex.vertex])
				continue; 
			
			visited[nowVertex.vertex] = true;
			
			for(Node nextVertex : graph.get(nowVertex.vertex)) {
				int nextNode = nextVertex.vertex;
				int nextWeight = nextVertex.weight;
				
				if(!visited[nextNode] && dist[nextNode] > nextWeight + dist[nowVertex.vertex]) {
					dist[nextNode] = nextWeight + dist[nowVertex.vertex];
					pq.add(new Node(nextNode,dist[nextNode]));
					
				}
			}
		}
	}
	

}
