import java.util.*;
import java.io.*;


public class Main {
	
	static int [][] map = new int[19][19]; //2 - 백, 1 - 흑
	//static boolean[][] visited = new boolean [19][19];
	static int N, count;
	
	/*
	 *바둑을 하나씩 놓으면서, 놓은 알에 해당 하는 가로 세로 대각 선만 확인 연속 5개 놓여있는지 확인 
	 *
	 *연속 바둑의 수가 무조건 5인 경우에만 true, 5보다 크면 xx 
	 * */

	public static void main(String[] args) throws IOException,ArrayIndexOutOfBoundsException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int cnt = -1;
		
		for(int i=1; i<=N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			if(i%2==1)
				map[y-1][x-1] = 1;
			else 
				map[y-1][x-1] = 2;
				
			// 바둑탐색
//			System.out.println("============ "+ i);
			boolean isEnabled = find(y-1, x-1);
			
			if(isEnabled) {
				cnt = i;
				break;
			}
			
			
		}
		
		System.out.println(cnt);
		
		
	}//main
	
	
	//바둑알 5개 연속으로 놓여있는지 확인 color : 놓은 바둑의 색깔 
	static boolean find(int startY, int startX){
		
		int count = 0;
		int color = map[startY][startX];
		boolean isFive =  false;
		
		//세로 
		for(int i=0; i<19; i++) {
			if(map[i][startX] == color)
				count ++;
			else
				count = 0;
			
			if(count == 5)
				isFive = true;
			
			if(count>5)
				isFive = false;
		}
		
		if(count==5 || isFive)
			return true;
		
//		System.out.println("세로 카운트 : "+ count);
		
		
		//가로 
		count = 0;
		isFive = false;
		
		for(int j=0; j<19; j++) {
			if(map[startY][j] == color)
				count++;
			else
				count = 0;
			
			if(count == 5)
				isFive = true;
			
			if(count>5)
				isFive = false;
		}
		
		if(count==5 || isFive)
			return true;
		
//		System.out.println("가로 카운트 : "+ count);
		
		
		//왼 대각 
		count = 0;
		isFive = false;
		
		int [] left = findLeftStart(startY, startX);
		int y = left[0]; 
//		System.out.println("왼 대각 스타트 좌표 : "+y);
		int x = left[1];
//		System.out.println("오 대각 스타트 좌표 : "+x);
		int cnt = left[2]; //반복횟수 
		
		for(int i=0; i<cnt; i++) {
			if(map[y+i][x+i] == color)
				count ++;
			else 
				count = 0;
			if(count == 5)
				isFive = true;
			
			if(count>5)
				isFive = false;
			
		}
//		System.out.println("왼대각 카운트 : "+ count);
		
		if(count==5 || isFive)
			return true;
		
		
		
		// 오 대각 
		count = 0;
		isFive = false;
		
		int [] right = findRightStart(startY, startX);
		int y2 = right[0];
		int x2 = right[1];
		int cnt2 = right[2]; //반복횟수 
		
		for(int i=0; i<cnt2; i++) {
			if(map[y2+i][x2-i] == color)
				count++;
			else 
				count = 0;
			
			if(count == 5)
				isFive = true;
			
			if(count>5)
				isFive = false;
			
		}
		
		if(count==5 || isFive)
			return true;
		
//		System.out.println("오 대각 카운트 : "+ count);

		
		return false;
	}

	
	//놓은 바둑돌의 왼쪽 대각선 시작 위치 및 탐색 횟수를 구하는 메서드 
	static int[] findLeftStart(int y, int x) {
		
		int minus = Math.min(y, x);
		
		int cnt = 18 - Math.max(y-minus, x-minus)+1;
		
		return new int[] {y-minus, x-minus,cnt};
		
	}
	
	//놓은 바둑돌의 오른쪽 대각선 시작 위치 및 탐색 횟수를 구하는 메서드 
	static int[] findRightStart(int y, int x) {
		
		int minus = Math.min(y, 18-x); 
		int cnt =  Math.min(18-y-minus+1, x+minus+1); //탐색횟수
		
		return new int[] {y-minus, x+minus,cnt};
		
	}
	
	

}
