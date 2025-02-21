import java.util.*;
import java.io.*;

public class Main {
	
	static int [][] map;
	static boolean [][] visited;
	static int [][] dist;
	static int n;
	static StringBuilder sb = new StringBuilder();
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testNum = 1; 
		
		while(true) {
			
			n = Integer.parseInt(br.readLine());
			
			if(n == 0)
				break;
			
			map = new int[n+2][n+2];
			dist = new int[n+2][n+2];
			visited = new boolean [n+2][n+2];
			

			for(int i =0; i<n+2; i++) {
				Arrays.fill(map[i], -1);
				Arrays.fill(visited[i], true);
			}
			
			for(int i=1; i<=n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=1; j<=n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					visited[i][j] = false;
					dist[i][j] = Integer.MAX_VALUE;
				}
			}// 입력 
			
			dijkstra(1, 1);
			sb.append("Problem "+testNum+": "+dist[n][n]);
			sb.append("\n");
			testNum++;
			
			
		}//while
		
		System.out.println(sb);
		
		

	}//main
	
	
	static void dijkstra(int y, int x) {
		
		PriorityQueue<int []> pq = new PriorityQueue<>((o1,o2)->(o1[2]-o2[2]));
		
		pq.add(new int[] {y,x,map[y][x]});
		dist[y][x] = map[y][x];
		
		while(!pq.isEmpty()) {
			int [] cur = pq.poll();
			int curY = cur[0];
			int curX = cur[1];
			int curCost = cur[2];
			
			if(dist[curY][curX]<curCost)
				continue;
			
			
			for(int i=0; i<4; i++) {
				int nextY = curY+dy[i];
				int nextX = curX+dx[i];

				if(map[nextY][nextX]!=-1) {
					int nextCost = curCost + map[nextY][nextX];
					if(dist[nextY][nextX] > nextCost) {
						dist[nextY][nextX] = nextCost;
						pq.add(new int[] {nextY,nextX,nextCost});
					}
					
				}
			}
		}
		
	}
	

}
