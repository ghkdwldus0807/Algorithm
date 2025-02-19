import java.io.*;
import java.util.*;


public class Main {
	
	static int n,m; 
	static boolean [][] map; 
	static Queue<int[]> queue = new ArrayDeque<>();
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};
	
	static int[][] distance ; //출발지 [1][1] 부터 [i][j]까지의 거리를 저장하는 배열 
	

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new boolean[n+2][m+2];
		distance = new int[n+2][m+2];
		
		for(int i=1; i<=n; i++) {
			String [] strArr = br.readLine().split("");
			for(int j=1; j<=m;j++) {
				if(Integer.parseInt(strArr[j-1])==1)
					map[i][j] = true;
			}
		}//input
		
		bfs(1,1);
		
		System.out.println(distance[n][m]);
		
	}//main
	
	
	static void bfs(int i, int j) {
		
		queue.add(new int[] {i,j});
		map[i][j] = false;
		distance[i][j] = 1;
		
		while(!queue.isEmpty()) {
			int [] coordinate = queue.poll();
			int curY = coordinate[0];
			int curX = coordinate[1];
			
			for(int a = 0 ; a<4; a++) {
				int nextY = curY + dy[a];
				int nextX = curX + dx[a];
				
				if(map[nextY][nextX]) {
					queue.add(new int[] {nextY,nextX});
					map[nextY][nextX] = false;
					distance[nextY][nextX] = distance[curY][curX] +1;
				}
			}
			
			
		}
		
		
		
	}

}
