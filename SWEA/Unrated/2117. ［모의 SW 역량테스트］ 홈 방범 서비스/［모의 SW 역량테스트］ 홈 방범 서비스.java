
import java.util.*;
import java.io.*;
import java.math.*;
public class Solution {
	

	/*
	 * 1. K와 마름모 중심(x,y)를 가지고 마름모 영역 계산하는 메서드
	 * 1. 운영 비용 계산하는 메서드 
	 * 
	 * 2. 집을 마름모 중심으로 가지고 K를 1부터 늘림, K>N 이면 break 
	 * 
	 * */
	
	static int T,N,M;
	static int [][] map;
	static int [] dx = {0,0,-1,1};
	static int [] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			int max = Integer.MIN_VALUE;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j=0; j<N; j++) {
					int n = Integer.parseInt(st.nextToken());
					map[i][j] = n;
				}
			}// 입력 
			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++){
					int y = i;
					int x = j;
					int k = 1;
					
					while(true) {
						if(k > N+1)
							break;
						
						int result = getServiceArea(k, y, x);
						
						
						max = Math.max(max, result);
						k++;
					}
					
				}
			}
			
			System.out.printf("#%d %d \n",t,max);
			
		}//test case 반복 
		
	}//main 
	
	
	
	//서비스 최대 영역 찾기
	static int getServiceArea(int k, int y, int x) {
		
		
		int houseNum = getDiamond(k, y, x);
		int operationCosts = getCosts(k);//운영비용
		int serviceCosts = houseNum * M; //수익 
		
		if(operationCosts<=serviceCosts)
			return houseNum;
		else
			return -1;
		
	}

	
	
	//마름모 영역 구하면서 영역에 해당하는 집의 개수 구하는 메서드 
	static int getDiamond(int k, int y, int x) {
		
		int houseNum = 0;
		if(map[y][x] == 1)
			houseNum = 1;
		Queue<int []> queue = new ArrayDeque<>();
		boolean [][] visited = new boolean[N][N];
		queue.add(new int[] {y,x,0});
		visited[y][x] = true;
		
		while(!queue.isEmpty()) {
			int [] current = queue.poll();
			
			int curY = current[0];
			int curX = current[1];
			int curDistance = current[2];
			
			for(int i=0; i<4; i++) {
				int nextY = curY + dy[i];
				int nextX = curX + dx[i];
				int nextDistance = curDistance+1;
				
				if(nextY>=0 && nextY<N && nextX>=0 && nextX<N && !visited[nextY][nextX] && nextDistance<k ) {
					if(map[nextY][nextX] == 1) {
						houseNum ++;
					}
					
					queue.add(new int[] {nextY, nextX, nextDistance});
					visited[nextY][nextX] = true;
					
				}
			}
			
			
		}
		
		
		return houseNum;
		
	}//getDiamond
	
	
	//운영 비용 계산 
	static int getCosts(int k) {
		
		return k*k + (k-1)*(k-1);
	}
	

}
