import java.util.*;
import java.io.*;


public class Main {
	
	//pseudo code 
	//1. 입력을 받는다. 탐색 시 경계조건 확인을 생략하기 위하여 범위 +2로 맵을 확장한다. 
	//2. bfs 함수를 정의
	//2-1. bfs 함수 내부에 새로운 bfs 로직이 시작될 시 지금 까지 카운트한 단지의 수를 list에다가 추가 후 count 초기화
	//3. list 오름차순 후 출력

	static int [][] map;
	static ArrayList<Integer> counts = new ArrayList<>();
	static int n;
	static int [] dx = {0,0,1,-1};
	static int [] dy = {-1,1,0,0};
	static Queue<int[]> queue = new LinkedList<>();
	static boolean[][] visited;
	
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n+2][n+2];
		visited = new boolean [n+2][n+2];
		
		for(int i=1; i<=n; i++) {
			String str = br.readLine();
			String [] arr = str.split("");
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(arr[j-1]);
			}
		}
		
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					counts.add(bfs(j,i));
					
				}
			}
		}
		
		Collections.sort(counts);
		
		System.out.println(counts.size());
		for(int cnt:counts) {
			System.out.println(cnt);
		}
		
		
	}//main 
	
	
	
	
	//bfs 
	static int bfs(int x, int y) {
		
		int count = 1;
		queue.add(new int[] {x,y});
		visited[y][x] = true;
		
		while(!queue.isEmpty()) {
			
			int [] complex = queue.poll();
			for(int i = 0 ; i<4; i++ ) {
				int curX = complex[0]+dx[i];
				int curY = complex[1]+dy[i];
				
				if(!visited[curY][curX] && map[curY][curX]==1) {
					visited[curY][curX] = true; 
					queue.add(new int[] {curX,curY});
					count++;
				}
			}
			
		}
		
		return count;
		
	}

}
