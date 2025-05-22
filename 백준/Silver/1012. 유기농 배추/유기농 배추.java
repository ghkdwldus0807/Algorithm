import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M, K; 
	static int [][] map;
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 
			 M = Integer.parseInt(st.nextToken());
			 N = Integer.parseInt(st.nextToken());
			 K = Integer.parseInt(st.nextToken());
			 map = new int[N][M];
			 
			 for(int i=0; i<K; i++) {
				 st = new StringTokenizer(br.readLine());
				 int m = Integer.parseInt(st.nextToken());
				 int n = Integer.parseInt(st.nextToken());
				 
				 map[n][m] = 1; 
			 }
			 
			 int ans = 0; 
			 
			 for(int i=0; i<N; i++) {
				 for(int j=0; j<M; j++) {
					 if(map[i][j] == 1) {
						 bfs(i,j);
						 ans ++;
					 }
				 }
			 }
			 sb.append(ans).append("\n");
		}//test case
		
		System.out.println(sb);

	}//main 
	
	static void bfs(int n, int m) {
		
		Queue<int []> queue = new ArrayDeque<>();
		queue.add(new int[] {n,m});
		map[n][m] = 0;
		
		while(!queue.isEmpty()) {
			
			int [] current = queue.poll();
			int curY = current[0];
			int curX = current[1];
			
			for(int i=0; i<4; i++) {
				int nextY = curY + dy[i];
				int nextX = curX + dx[i];
				
				if(nextY>=0 && nextY<N && nextX>=0 && nextX<M) {
					if(map[nextY][nextX] == 1) {
						queue.add(new int[] {nextY, nextX});
						map[nextY][nextX] = 0;
					}
				}
				
			}
			
		}
		
	}

}
