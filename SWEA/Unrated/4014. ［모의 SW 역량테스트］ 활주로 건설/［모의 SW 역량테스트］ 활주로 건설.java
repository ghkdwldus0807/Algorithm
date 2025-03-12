
import java.io.*; 
import java.util.*;

public class Solution {
	
	static int  T, N, X, answer, maxHeight; 
	static int [][] map; 
	static List<int []> list = new ArrayList<>();


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int [N][N];
			answer = 0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // input
				
			for(int i=0; i<N; i++) {
				maxHeight = 0; 
				list.clear();
				
				countColumn(i);
				
				if(isEnabled()) {
					answer ++;
				}
				
				
			}//for - column 
			
			
			for(int j=0; j<N; j++) {
				maxHeight = 0 ;
				list.clear();
				
				countRow(j);
				
				if(isEnabled()) {
					answer ++;
				}
				
			}//for - row 
			
			
			System.out.printf("#%d %d \n",t,answer);
			
			
			
		} //test case 반복 
		
	} //main 
	
	
	/* 활주로 설치가 불가 한 경우 
	 * 1. 인접한 두 칸의 높이가 2이상 차이 나는 경우 
	 * 2. 경사로를 설치 못하는 경우 (경사로가 지형 밖으로 나가는 경우, 연속된 칸 수가 모자란 경우 등)
	 * 
	 * 
	*/
	
	
	//경사로를 설치할 수 있는지 확인
	static boolean isEnabled() {
		
		
		//인접 구간끼리 비교
		
		for(int i=0; i<list.size()-1; i++) {
			
			int [] current = list.get(i);
			int [] next = list.get(i+1);
			
			int currentH = current[0];
			int currentCount = current[1];
			
			int nextH = next[0];
			int nextCount = next[1];
			
			if(Math.abs(currentH - nextH)>1)
				return false;
			
			//내리막길 일 때
			if(nextH == currentH-1) {
				
				if(nextCount<X)
					return false; 
				
				list.get(i+1)[1] -= X; //사용한 칸 수 만큼 지우기 
			}
			
			//오르막길 일 때 
			if(nextH == currentH+1) {
				
				if(currentCount<X) {
					return false;
				}
				
				list.get(i)[1] -= X; //사용한 칸 수 만큼 지우기 
			}

			
		}
		
		
		return true; 
	}
	
	
	
	//한 행에 이어져 있는 숫자가 연속으로 몇 번 있는지 카운트 [높이, 연속으로 나온 개수]
	// [3,3,3,2,1,1] -> [3,2] [2,1] [1,2]
	static void countColumn(int i) {
		
		int standard = map[i][0];
		int count = 1;
		maxHeight = standard;
		
		for(int j=1; j<N; j++) {
			int current = map[i][j];
			
			if(current>maxHeight)
				maxHeight = current;
			
			if(current == standard)
				count ++;
			else {
				list.add(new int[] {standard, count});
				standard = current;
				count = 1;
			}
			
			
		}
		
		list.add(new int[] {standard, count});
		
		
	}//countColumn
	
	static void countRow(int j) {
		int standard = map[0][j];
		int count = 1; 
		
		for(int i=1; i<N; i++) {
			int current = map [i][j];
			
			if(current>maxHeight)
				maxHeight = current;
			
			if(current == standard)
				count ++;
			else {
				list.add(new int[] {standard, count});
				standard = current;
				count = 1;
			}
			
			
		}
		
		list.add(new int[] {standard, count});
		
	}
	

}
