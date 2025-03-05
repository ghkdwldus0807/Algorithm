
import java.util.*;
import java.util.zip.CheckedOutputStream;
import java.io.*;

/*
 * 1. bfs
 * 2. 맵을 탐색하면서, 큐에 넣을 때, 터널 구조물 타입을 확인하고, 그에 해당하는 위치만 큐에 넣기 
 * 3. 거리 <= 탈출 소요시간인 경우만 탈주범이 갈 수 있음 
 * 
 * */

public class Solution {
	
	static int[][] map; 
	static boolean [][] visited;
	static int[][] dist;
	//static Queue<int[]> queue = new ArrayDeque<>();
	static int T,N,M,R,C,L;
	static int count;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t =0 ; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			dist = new int[N][M];
			visited = new boolean [N][M];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}//입력 
			
			bfs(R,C,0);
			
			int ans = countDistance(dist);
			
//			for(int i = 0; i<N; i++) {
//				for(int j=0; j<M; j++) {
//					System.out.print(dist[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			System.out.printf("#%d %d \n",t+1,ans+1);
			
			
		}//test 
		
		
		

	} // main 
	
	
	
	//bfs
	
	static void bfs(int y, int x, int distance) {
		
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.add(new int[] {y,x,distance});
		visited[y][x] = true;
		dist[y][x] = 0;
		
		while(!queue.isEmpty()) {
			int [] current = queue.poll();
			int curY = current[0];
			int curX = current[1];
			int curDis = current[2];
			
			int [] dx = getDx(map[curY][curX]);
			int [] dy = getDy(map[curY][curX]);
			
			for(int i=0; i<dx.length; i++) {
				
				int nextY = curY + dy[i];
				int nextX = curX + dx[i];
				
				
				if(nextX>=0 && nextX<M && nextY>=0 && nextY<N && !visited[nextY][nextX] && map[nextY][nextX] != 0 && isConnected(curY, curX, nextY, nextX)) {
					
					int nextDis = curDis+1;
					
					if (nextDis>L)
						continue; 
					
					dist[nextY][nextX] = nextDis;
					queue.add(new int[] {nextY, nextX, nextDis});
					visited[nextY][nextX] = true;
					
				}
				
				
			}
			
			
		}
		
	}
	
	
	//터널 구조물 타입에 따라 다르게 dx 배열 반환
	static int[] getDx(int num) {
		
		if(num == 1) {
			return new int[] {0,0,-1,1};
		}
		else if(num == 2) {
			return new int[] {0,0};
		}
		else if(num == 3) {
			return new int[] {-1,1};
		}
		else if(num == 4) {
			return new int[] {0,1};
		}
		else if(num == 5) {
			return new int[] {0,1};
		}
		else if(num == 6) {
			return new int[] {0,-1};
		}
		else {
			return new int[] {0,-1};
		}
		
	}//getDx
	
	//터널 구조물 타입에 따라 다르게 dy 배열 반환
	static int[] getDy(int num) {
		
		if(num == 1) {
			return new int[] {-1,1,0,0};
		}
		else if(num == 2) {
			return new int[] {-1,1};
		}
		else if(num == 3) {
			return new int[] {0,0};
		}
		else if(num == 4) {
			return new int[] {-1,0};
		}
		else if(num == 5) {
			return new int[] {1,0};
		}
		else if(num == 6) {
			return new int[] {1,0};
		}
		else {
			return new int[] {-1,0};
		}
		
	}//getDy
	
	
	//L보다 작은 distance 개수 카운트
	static int countDistance(int [][] distance) {
		int count = 0 ;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(distance[i][j] != 0 && distance[i][j]<L) count ++;
			}
		}
		
		return count;
		
		
	}
	
	//현재칸과 다음칸이 이어져있는지 아닌지 확인하는 메서드
	
	static boolean isConnected(int curY, int curX, int nextY, int nextX) {
		
		int curNum = map[curY][curX];
		int nextNum = map[nextY][nextX];
		
		//current 좌표 기준 next 좌표의 위치 확인 (상하좌우); 상 0 하 1 좌 2 우 3
		int direction = findDirection(curY, curX, nextY, nextX);
		
		List<Integer> up = Arrays.asList(1,2,4,7);
		List<Integer> down = Arrays.asList(1,2,5,6);
		List<Integer> left = Arrays.asList(1,3,6,7);
		List<Integer> right = Arrays.asList(1,3,4,5);
		
		
		if(curNum == 1) {
			if(direction == 0 && down.contains(nextNum))
				return true;
			else if(direction == 1 && up.contains(nextNum))
				return true;
			else if(direction == 2 && right.contains(nextNum))
				return true;
			else if(direction == 3 && left.contains(nextNum))
				return true;
			
		}

		else if(curNum == 2) {
			if(direction == 0 && down.contains(nextNum))
				return true;
			else if(direction == 1 && up.contains(nextNum))
				return true;
		}
		else if(curNum == 3) {
			if(direction == 2 && right.contains(nextNum))
				return true;
			else if(direction == 3 && left.contains(nextNum))
				return true;
		}
		else if(curNum == 4) {
			if(direction == 0 && down.contains(nextNum))
				return true;
			else if(direction == 3 && left.contains(nextNum))
				return true;
		}
		else if(curNum == 5 ) {
			if(direction == 1 && up.contains(nextNum))
				return true;
			else if(direction == 3 && left.contains(nextNum))
				return true;
		}
		else if(curNum == 6 ) {
			if(direction == 1 && up.contains(nextNum))
				return true;
			else if(direction == 2 && right.contains(nextNum))
				return true;
		}
		else if(curNum == 7 ) {
			if(direction == 0 && down.contains(nextNum))
				return true;
			else if(direction == 2 && right.contains(nextNum))
				return true;
		}
		
		
		return false; 
		
		
	}//isConnected
	
	
	static int findDirection(int curY, int curX, int nextY, int nextX) {
		int ud = nextY - curY;
		int lr = nextX - curX;
		
		if(ud == -1 && lr == 0)
			return 0;
		else if(ud == 1 && lr == 0) {
			return 1;
		}
		else if(ud == 0 && lr == -1)
			return 2;
		else
			return 3;
		
		
	}

	
	

}
