
import java.io.*;
import java.util.*;

//pseudo code 
//1. n,m 입력 받기
//1-1. 그래프 초기화
//2. dfs를 이용해서 탐색을 진행한다. 
//3. 탐색이 멈추면 count +1 을 하고, visited 배열을 이용하여 false인 vertex에 대해서 다시 dfs 순회 
//4. 2~3의 과정을 마지막 노드까지 반복 한다. 
//5. count를 출력


public class Main  {
	
	static int vertexNum;
	static int edgeNum;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean [] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		vertexNum = Integer.parseInt(st.nextToken());
		edgeNum = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<=vertexNum; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<edgeNum; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			graph.get(n1).add(n2);
			graph.get(n2).add(n1);
		}
		
		visited = new boolean[vertexNum+1];
		
		int count = 0;
		
		for(int i=1; i<visited.length;i++) {
			if(!visited[i]) {
				count+=1;
				dfs(i);
			}
		}
		
		System.out.println(count);
	
		
	}//main method
	
	
	public static void dfs(int n) {
		visited[n] = true;
		
		for(int node : graph.get(n)) {
			if(!visited[node]) {
				dfs(node);
			}
		}
	}

}
