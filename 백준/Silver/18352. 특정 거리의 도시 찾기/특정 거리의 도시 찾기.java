import java.util.*;
import java.io.*;

public class Main {
	
	
	static int N, M, K, X;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] dist;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
		}
		
		dist = new int[N+1];
		Arrays.fill(dist, -1);
		dij(X);
		
		boolean isAns = false;
		for(int i=1; i<=N; i++) {
			if(dist[i] == K) {
				System.out.println(i);
				isAns = true;
			}
		}
		
		if(!isAns) {
			System.out.println(-1);
		}
		
		
	}//main 
	
	static void dij(int start) {
		ArrayDeque<int[]> queue = new ArrayDeque<>(); //{도시번호, 거리}
		queue.add(new int[] {start,0});
		dist[start] = 0;
		
		while(!queue.isEmpty()) {
			int [] current = queue.poll();
			int curN = current[0];
			int curDist = current[1];
			for(int next : graph.get(curN)) {
				if(dist[next] == -1) {
					dist[next] = curDist + 1;
					queue.add(new int[] {next, curDist+1});
				}
			}
		}
	}

}
