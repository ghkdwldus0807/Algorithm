import java.io.*;
import java.util.*;

public class Main {
	
	static int N, ans, ans2;
	static char[][] map, map2; //색약 X, 색약 O
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		map2 = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
			map2[i] = str.toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map2[i][j] == 'G')
					map2[i][j] = 'R';
			}
		}
		//input
		
		//색약 X 
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]!='X'){
					bfs(map,i,j);
					ans ++;
				}
			}
		}
		
		//색약 O
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map2[i][j]!='X'){
					bfs(map2,i,j);
					ans2 ++;
				}
			}
		}
		
		sb.append(ans).append(" ").append(ans2);
		
		System.out.println(sb);
		
		
		
	}//main
	
	
	static void bfs(char [][] map, int y, int x) {
		
		Queue<int []> queue = new ArrayDeque <>();
		
		char color = map[y][x];
		queue.add(new int[] {y,x});
		map[y][x] = 'X';
		
		while(!queue.isEmpty()) {
			
			int [] current = queue.poll();
			int curY = current[0];
			int curX = current[1];
			
			for(int i=0; i<4; i++) {
				int nextY = curY + dy[i];
				int nextX = curX + dx[i];
				
				if(nextY<0 || nextY>=N || nextX<0 || nextX>=N)
					continue;
				
				int nextColor = map[nextY][nextX];
				
				if(nextColor==color) {
					queue.add(new int[] {nextY,nextX});
					map[nextY][nextX] = 'X';
				}
				
			}
			
		}

		
	}//bfs
	

}
