import java.util.*;
import java.io.*;

/*
 * 1. 맨 첨에는 싹 다 같은 색인지 확인
 * 2. 아니라면 n/2로 나누고 해당 크기가 싹 다 같은 색인지 화긴 
 * 3. n /= 2가 = 1 될 때까지 반복 
 * 
 * 
 * 만들어야하는거 
 * 1. 시작점, 시작점 색깔, n의 길이 => 정사각형 n이 같은 색인지 아닌지 탐색하는 함수 
 * 2. visited 배열으로 검사 안해도되는건 뛰어넘기 
 * 
 * */

public class Main {
	
	static boolean [][] visited;
	static int [][] paper; 
	static int n;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int entireLen = n;
		visited = new boolean[n][n];
		paper = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}//for
		
		Queue<int []> queue= new LinkedList<>();
		queue.add(new int [] {0,0,n}); //시작점 
		
		int whiteNum = 0 ;
		int blueNum = 0;
		
		while(!queue.isEmpty()) {
				
			int [] dot = queue.poll();
			int i = dot[0];
			int j = dot[1];
			int curSize = dot[2];
			int color = paper[i][j];
			
//			System.out.println(i+" "+j+" "+curSize+" "+color);
			
			if(!visited[i][j]) {
				
				if(isSameColor(i,j,color,curSize)) {
					setVisited(i,j,curSize);
					if(color==0) {
						whiteNum += 1;
					}
					else {
						blueNum +=1;
					}
				}else {
					
					int newSize = curSize/2;
					for(int y=i; y<i+curSize; y+=newSize) {
						for(int x=j; x<j+curSize; x+=newSize) {
							queue.add(new int[] {y,x,newSize});
//							System.out.println("y :  "+ y);
//							System.out.println("x :  "+ x);
						}
					}
				}

			}
			
		}//while
		
		
		System.out.println(whiteNum);
		System.out.println(blueNum);
		

	}
	
	
	static boolean isSameColor(int i, int j, int color, int len) {
		
		for(int y=i; y<i+len; y++) {
			for(int x=j; x<j+len; x++) {
				if(paper[y][x]!=color)
					return false;
			}
		}
		return true;
	} //isSameColor 
	
	//isSameColor == true -> 방문처리
	static void setVisited(int i, int j, int len) {
		for(int y=i; y<i+len; y++) {
			for(int x=j; x<j+len; x++) {
				visited[y][x] = true;
			}
		}
	}//setVistied

}
