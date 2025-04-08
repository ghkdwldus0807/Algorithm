import java.util.*;
import java.io.*;
public class Main {
	
	static int [][] map = new int[3][3];
	static int sum; // 매직 스퀘어의 합
	static Queue<int []> emptyCoordi = new ArrayDeque<>(); //빈칸의 좌표 저장
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				int n = Integer.parseInt(st.nextToken());
				map [i][j] = n;
				if(n == 0) {
					emptyCoordi.add(new int[] {i,j});
				}
			}
		}//input
		
		//매직스퀘어 합을 먼저 찾기 
		sum = getSum();
		
		//빈칸 채우기 
		while(!emptyCoordi.isEmpty()) {
			
			int [] coordi = emptyCoordi.poll();
			int y = coordi[0];
			int x = coordi[1];
			
			if(y==1 && x==1) { //센터 칸인 경우
				map[y][x] = sum/2;
			}
			else {
				int symY = Math.abs(y-2);//대칭 y좌표
				int symX = Math.abs(x-2);//대칭 x좌표
				
				//대칭 칸도 빈칸인 경우
				if(map[symY][symX] == 0) {
					int totalSum = (sum/2)*3;
					map[y][x] = totalSum - getRowSum(y, x);
					
				}
				else {
					map[y][x] = sum - map[symY][symX];
				}
			}
			
		}
		
		for(int i=0; i<3; i++) {
			for(int j =0 ;j<3; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
		
	}//main
	
	//행, 열 탐색해서 합 구하기 
	static int getRowSum(int y, int x) {
	
		int sum = 0;
		
		//행 탐색 
		for(int i=0; i<3; i++) {
			if(i != y && map[i][x]==0) {//자신말고 빈 칸이 있을 경우
				sum = 0;
				break;
			}
			sum += map[i][x];
		}
		
		//열 탐색
		if(sum == 0) {
			for(int i=0; i<3; i++) {
				if(i != x && map[y][i]==0) {//자신말고 빈 칸이 있을 경우
					return 0;
				}
				sum += map[y][i];
			}
		}
		
		return sum;
		
	}
	
	//매직 스퀘어 합을 구하는 메서드
	static int getSum() {
		int sum = 0;
		
		for(int y=0; y<3; y++) {
			for(int x=0; x<3; x++) {
				int symY = Math.abs(y-2);//대칭 y좌표
				int symX = Math.abs(x-2);//대칭 x좌표
				
				if(y==1 && x ==1 && map[y][x] !=0) {//정가운데 칸인 경우 
					sum = map[y][x]*2;
					return sum;
				}
				
				int v = map[y][x]; //value
				int symV = map[symY][symX]; //대칭 value
				
				if (v == 0 || symV ==0)
					continue;
				else {
					sum = v+symV;
					break;
				}
			}
		}
		return sum;
	}//getSum

}
