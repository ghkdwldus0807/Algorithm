import java.util.*;
import java.io.*;

public class Main {
	
	static int level = 2, N, ans, cnt, eatCnt; //level : 현재 아기 상어 크기 , cnt : 먹이 개수, eatCnt : 아기상어가 먹은 먹이개수
	static int startY, startX; //아기상어 시작위치
	static int [][] map;
	static boolean [][] visited;
	static int [] dx = {0,-1,1,0};//상좌우하
	static int [] dy = {-1,0,0,1};
	static PriorityQueue<Feed> pq = new PriorityQueue<>();
	
	static class Feed implements Comparable<Feed>{
		
		private int y,x,level,dist;
		
		public Feed(int y, int x, int level, int dist) {
			this.y = y;
			this.x= x;
			this.level = level;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Feed o1) {
			
			if(this.dist == o1.dist) {
				if(this.y == o1.y)
					return this.x - o1.x;
				return this.y - o1.y;
			}
			return this.dist - o1.dist;
		}
	} // class - Feed

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				if(n == 9) {
					startY = i;
					startX = j;
					map[i][j] = 0;
				}
				else if(1<=n && n<=6)
					cnt++;
				
			}
		}// input
		
		
		//bfs 
		while(true) {
			
			bfs(startY,startX);
			
			if(cnt == 0 || pq.isEmpty()) {
				break;
			}
			
			feed();
			
		}
		
		System.out.println(ans);
		
	}//main 
	
	//bfs 
	static void bfs(int startY, int startX) {
		visited = new boolean[N][N];
		pq.clear();
		Queue<int []> queue = new ArrayDeque<>();
		queue.add(new int[] {startY,startX,0});
		visited[startY][startX] = true;
		
		while(!queue.isEmpty()) {
			
			if(cnt == 0) //종료조건 2
				return;
			
			int[] current = queue.poll();
			int curY = current[0];
			int curX = current[1];
			int curDist = current[2];

			
			visited[curY][curX] = true;
			
			for(int i=0; i<4; i++) {
				int nextY = curY + dy[i];
				int nextX = curX + dx[i];
				int nextDist = curDist +1;
				
				if(nextX<0 || nextX >=N || nextY<0 || nextY >= N)
					continue;
				
				if(visited[nextY][nextX])
					continue;
				
				int feedLevel = map[nextY][nextX];
				
				if(feedLevel<=level ) {
					visited[nextY][nextX] = true;
					queue.add(new int[] {nextY,nextX,nextDist});
					if(feedLevel!=0 && feedLevel < level) {
						pq.add(new Feed(nextY,nextX,feedLevel,nextDist));
					}
				}
			}
			
		}

	}//bfs
	
	//level 검사 후 레벨 업 시키는 메서드 
	static void setLevel() {
		
		if(level == eatCnt) {
			level ++; 
			eatCnt = 0;
		}
	}//setLevel
	
	//가장 조건에 부합하는 먹이를 먹기
	static void feed() {
		while(!pq.isEmpty()) {
			Feed fish = pq.poll();
			
			if(fish.level<level) {
				ans += fish.dist;
				eatCnt ++;
				cnt --;
				startX = fish.x;
				startY = fish.y;
				map[startY][startX] = 0;
				setLevel();
				break;
			}
		}
	}//feed

}
