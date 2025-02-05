import java.io.*;
import java.util.*;

public class Main  {
	
	//1-1.인접리스트 선언
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	//2-1. dfs 시작 전, 노드의 방문 여부를 기록하기 위해 visited 배열을 만들어준다. 
	static boolean [] visited;
	static int vertexNum;
	static int edgeNum;
	static int startVertex;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		vertexNum = Integer.parseInt(st.nextToken());
		edgeNum = Integer.parseInt(st.nextToken());
		startVertex = Integer.parseInt(st.nextToken());
		
		//1.그래프 구현하기 
		

		//1-2. 인접 리스트로 구성한 그래프에 또 다시 ArrayList를 넣어주며 초기화
		for(int i=0; i<=vertexNum; i++) {
			graph.add(new ArrayList<Integer>());
		}
		//1-3. 두 정점의 관계에 맞추어 graph에 노드 넣기
		for(int i=1; i<=edgeNum; i++) {
			//문제 조건에 의하면, 간선은 양방향 이므로 두 군데 다 넣어준다. 
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			graph.get(n1).add(n2);
			graph.get(n2).add(n1);
		}
		
		//1-4. ArrayList sort 
		for(int i=0; i<=vertexNum; i++) {
			Collections.sort(graph.get(i));
		}
		
		//2.dfs 수행 후 결과 출력 
		visited = new boolean[vertexNum+1];
		dfs(startVertex);
		System.out.println();

		//3. bfs 수행 후 결과 출력 
		
		visited = new boolean[vertexNum+1];
		bfs(startVertex);
		
	}//main method
	
	public static void dfs(int vertex) {
		System.out.print(vertex+" ");
		visited[vertex] = true;
		
		for(int node : graph.get(vertex)) {
			if(!visited[node]) {
				dfs(node);
			}
		}
	}
	
	public static void bfs(int vertex) {
		//1. bfs 구현을 위한 queue 선언 
		Queue<Integer> queue = new LinkedList<Integer>();
		//2. 맨 처음 정점을 큐에 추가한다. & 방문처리
		queue.offer(vertex);
		visited[vertex] = true;
		
		//3. 이 후 queue가 빌 떄까지 탐색을 반복한다. 
		while(!queue.isEmpty()) {
			//3-1. 맨 처음 노드를 꺼낸다.
			int node = queue.poll();
			System.out.print(node+" ");
			//3-2. 큐에서 꺼낸 노드와 연결된 간선들을 체크한다. 
			for(int i=0; i<graph.get(node).size(); i++) {
				int temp = graph.get(node).get(i);
				//3-3. 노드를 방문하지 않았다면 큐에 삽입 후 방문처리
				if(!visited[temp]) {
					queue.offer(temp);
					visited[temp] = true;
				}
			}
		}
		
	} 
}
