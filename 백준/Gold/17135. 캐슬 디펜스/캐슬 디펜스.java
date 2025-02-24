import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
	
	static int [][] map;
	static int n,m,distLimit;
	static Queue<int[]> archers = new ArrayDeque<>(); // 궁수의 x 좌표만 저장 
	static int [] arr ; //현재 궁수 좌표들 
	//왼, 오, 위
	static int [] dx = {-1,1,0};
	static int [] dy = {0,0,-1};
	static Queue<int[]> enemys = new ArrayDeque<>(); // 공격받을 적의 좌표
	static int enemyNum = 0;
	static int copyEnemyNum = 0;
	static int max = -1;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt((st.nextToken()));
		m = Integer.parseInt((st.nextToken()));
		distLimit = Integer.parseInt((st.nextToken()));
		map = new int [n+1][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				int num= Integer.parseInt(st.nextToken());
				map[i][j] = num;
				
				if(num == 1)
					enemyNum ++;
			}
		}
		
		//랜덤 궁수 3명 입력 받기
		arr = new int[3];
		setArcher(0,0);
		
		
		while(!archers.isEmpty()) {
			
			int count = 0; 
			
			int [] coordi = archers.poll();
			int[][] copyMap = copyMap(map);
			copyEnemyNum = enemyNum;
			
			while(copyEnemyNum>0) {
				
				Set<String> set = new HashSet<>();
				for(int i=0; i<3; i++) {
					int[] enemyArr = bfs(n,coordi[i],copyMap);
					set.add(enemyArr[0]+" "+enemyArr[1]);
				}
				
				Iterator<String> iter = set.iterator();
				
				//HashSet은 배열의 경우 내용이 동일해도 동일한 객체로 인식 X,
				// 따라서 String으로 처리
				while(iter.hasNext()) {
					String nowStr = iter.next();
					st = new StringTokenizer(nowStr);
					int nowY =Integer.parseInt(st.nextToken());
					int nowX =Integer.parseInt(st.nextToken());
					
					if(nowY == -1 || nowX == -1)
						continue;
					copyMap[nowY][nowX] = 0;
					copyEnemyNum --;
					count ++;
				}
				
				changeEnemy(copyMap);
				
				
			}//while 
			
			max = Math.max(count,  max);
			
		}//while - archers Empty
		

		System.out.println(max);
		
		
	}//main 
	
	
	static void setArcher(int start, int index) {

		
		if(index == 3){
			int [] nums = new int[3];
			for(int i=0; i<3; i++) {
				nums[i] = arr[i];
			}
			archers.add(nums);
			return;
		}
		
		for(int i = start; i<m; i++) {
			arr[index] = i; 
			setArcher(i+1,index+1);
//			start ++;
		}
		
			
	}//setArcher - 모든 조합의 궁수 3명 뽑기 
	
	
	static int calDistance(int y1, int y2, int x1, int x2) {
		
		return Math.abs(y1-y2) + Math.abs(x1-x2);
	} // 궁수와 적의 거리 구하기 
	
	
	static int[][] copyMap(int [][] map){
		int [][] copy = new int [n+1][m];
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<m; j++)
				copy[i][j] = map[i][j];
		}
		return copy;
		
	}//copyMap
	
	
	static int[] bfs(int y, int x, int[][] map) {
		Queue<int []> bfsQ = new ArrayDeque<>();
		boolean [][] visited = new boolean[n+1][m];
		
		int [] attackEnemy = {-1,-1}; //공격받을 적의 좌표
		int left = 16;
		int minDistance = Integer.MAX_VALUE;

		bfsQ.add(new int[] {y,x,0});
		visited[y][x] = true;
		
		while(!bfsQ.isEmpty()) {
			
			int [] enemyCoor = bfsQ.poll();
			int curY = enemyCoor[0];
			int curX = enemyCoor[1];
			int curDist = enemyCoor[2];
			
			if(map[curY][curX]==1) {
				if(curDist < minDistance || (curDist == minDistance && curX<left)) {
					minDistance = curDist;
					left = curX;
					attackEnemy[0] = curY;
					attackEnemy[1] = curX;
				}
			}

			
			
			for(int i=0; i<3; i++) {
				int nextY = dy[i] + curY;
				int nextX = dx[i] + curX;
				
				if(nextY>=0 && nextY<=n && nextX>=0 && nextX<m) {
					if(curDist +1 <= distLimit && !visited[nextY][nextX]) {
						visited[nextY][nextX] = true;
						bfsQ.add(new int[] {nextY,nextX,curDist+1});
						
					}
				}
			}
		}
		
		return attackEnemy;
		
	}//bfs
	
	
	static void changeEnemy(int[][] map) {
		
		for(int i = n-1; i>=0; i--) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 1) {
					if(i+1 == n) {
						map[i][j] = 0; //사라짐 
						copyEnemyNum -- ;
					}
					else {
						map[i][j] = 0;
						map[i+1][j] = 1;
					}
				}
				
			}
		}
		
	}
	

}
