import java.io.*;
import java.util.*;


public class Main {

	
	static class Node implements Comparable<Node>{
		
		private int v; //이어진 정점 
		private long w; //가중치 
		
		public Node(int v, long w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o1) {
			
			if(this.w == o1.w)
				return this.v - o1.v;
			
			return Long.compare(this.w, o1.w);
		}
		
	}//Node
	
	
	static int N, M; //도시 개수, 도로 개수 
	static long answer;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static boolean [] visited; 
	static long [] dist;
	static Node [] prev; //dp배열, prev[i] = j 이면 i번째 노드의 이전 노드는 j이다. 
	static int [] childNodeNum; //childNodeNum[i] = n ; 정점 i 자기 자신을 포함한 자식 노드의 개수는 n이다. 
	static long [] bestParentCost; //i번째 노드로 오기 위해 사용한 경로에서 직전 노드까지의 누적비용 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		dist = new long[N+1];
		childNodeNum = new int[N+1];
		prev = new Node[N+1];
		bestParentCost = new long[N+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(bestParentCost, -1);
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Node>());
		}//initialize
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			//양방향 연결 
			graph.get(a).add(new Node(b,c));
			graph.get(b).add(new Node(a,c));
			
		}
		//input
		
		prev[1] = new Node(0,0); // 출발지 초기화
		
		dij(); 
		

		//다익스트라 이후 트리 구성하기 (prev 배열 참고)
		
		List<Integer>[] tree = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			tree[i] = new ArrayList<>(); 
		}
		
		for(int i=2; i<=N; i++) {
			tree[prev[i].v].add(i);
		}
		
		
		//위의 트리를 기준으로 DFS 이용하여 자식 노드 개수 구하기
		dfs(1,tree);

		
		//최종 비용 계산하기
		for(int i=2; i<=N; i++) {
			
			answer += (9*childNodeNum[i]+1)*prev[i].w/10;
		}
		System.out.println(answer);
		

	}//main
	
	
	//Dfs
	static int dfs(int node, List<Integer>[] tree) {
		int count = 1; 
		for(int child : tree[node]) {
			count += dfs(child,tree);
		}
		
		childNodeNum[node] = count;
		return count;
		
	}
	
	
	//다익스트라 메서드 
	static void dij() {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[1] = 0; //출발지는 무조건 1
		pq.add(new Node(1,0));
		
		while(!pq.isEmpty()) {
			
			Node current = pq.poll();
			
			if(visited[current.v])
				continue;
			
			visited[current.v] = true;

			for(Node next : graph.get(current.v)) {
				long newCost = dist[current.v] + next.w;
				
				if(dist[next.v] > newCost) {
					
					dist[next.v] = newCost;
					prev[next.v] = new Node(current.v,next.w);
					bestParentCost[next.v] = dist[current.v]; // 부모 누적 비용 저장
					pq.add(new Node(next.v, newCost));

				}
				else if(dist[next.v] == newCost) {
                    if (bestParentCost[next.v] == -1 || dist[current.v] > bestParentCost[next.v]) {
                        prev[next.v] = new Node(current.v, next.w);
                        bestParentCost[next.v] = dist[current.v];
                    }
				}
				
			}
		}
		
		
	}//dij
	
	

}