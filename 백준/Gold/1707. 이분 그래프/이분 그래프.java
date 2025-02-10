import java.io.*;
import java.util.*;

//pseudo code

/*
 * 1. 정점을 순회하며 자신과 연결된 정점에 flag를 부여한다.
 * 1-1. 한 번 부여된 flag는 다음번에는 다른 flag로 바뀐다. (T-F-T-F-T-F ...)
 * 2. 순회하는 도중, 자신과 연결된 정점의 flag가 자신과 같으면 NO, 다르면 YES 
 * */

public class Main {
	
	static ArrayList<ArrayList<Integer>> graphs;
	static int vertexNum, edgeNum;
	static boolean flag;
	static int [] visited; //정점 방문 여부 -1, 0 , 1 (0은 색깔 x)
	static boolean answer;


	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine());
		
		//test case 별 탐색 수행
		for(int i=0; i<testNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			vertexNum = Integer.parseInt(st.nextToken());
			edgeNum = Integer.parseInt(st.nextToken());
			graphs = new ArrayList<ArrayList<Integer>>();
			visited = new int[vertexNum+1];
			answer = false;
			
			for (int j=0; j<=vertexNum; j++) {
				graphs.add(new ArrayList<Integer>());
			}
			
			for(int j=1; j<=edgeNum; j++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2= Integer.parseInt(st.nextToken());
				
				graphs.get(n1).add(n2);
				graphs.get(n2).add(n1);
				
			}
			
			
			
			for(int j=1; j<=vertexNum; j++) {
				if(visited[j]==0) {
					answer = bfs(j);
					if(answer == false)
						break;
				}
			}
			
			if(!answer)
				System.out.println("NO");
			else
				System.out.println("YES");
			
		}
		
		

	}// main 
	
	static boolean bfs(int start) {
		
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = 1;
		
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			
			for(int i=0; i<graphs.get(node).size();i++) {
				int temp = graphs.get(node).get(i);
				
				if(visited[node] == visited[temp]) {
					return false;
				}
				
				if(visited[temp]==0) {
					visited[temp] = visited[node]*-1;
					queue.add(temp);
				}
			}
		}
		
		return true;
		
	}

}
	