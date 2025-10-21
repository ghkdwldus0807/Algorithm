import java.io.*;
import java.util.*;

public class Main {
	
	static int [][] labtop;
	static int N, M, K; 


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		labtop = new int [N][M];
		
		//스티커 입력 받기 
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int [][] sticker = new int [n][m];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<m; j++) {
					int v = Integer.parseInt(st.nextToken());
					sticker[i][j] = v;
				}
			}
			//스티커 돌리면서 붙이기
			boolean putSt = false; 
			
			for(int r=0; r<4 &&!putSt; r++) {
				
				//회전하면 스티커의 가로세로 길이가 달라지므로 새로 계산해야한다
				int newN = sticker.length;
				int newM = sticker[0].length;
				
				for(int i = 0; i+newN <=N &&!putSt; i++) {
					for(int j=0; j+newM<=M && !putSt; j++) {
						if(isAttached(i, j, sticker)) {
							attach(i,j,sticker);
							putSt=true;
							
					}
				}
			}
				
			if(!putSt) {
				sticker = rotate(sticker);
			}
		}
			
			
	}//input
		
		//최종 스티커 칸 개수 세기
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(labtop[i][j]==1) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
		

	}//main
	
	//실제로 붙이기
	static void attach(int si, int sj, int[][]sticker) {
		int n = sticker.length;
		int m = sticker[0].length;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(sticker[i][j] == 1) {
					labtop[si+i][sj+j] = 1;
					}
				}
			}
		}

	
	//스티커 붙일 수 있는 지 검사 
	static boolean isAttached(int si, int sj, int[][] sticker) {
		int n = sticker.length;
		int m = sticker[0].length;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(sticker[i][j] == 1) {
					if(labtop[si+i][sj+j] == 1) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	
	//배열 90도 회전 
	static int[][] rotate(int[][] arr){
		
		int n = arr.length;
		int m = arr[0].length;
		int [][] results = new int [m][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				results[j][n-i-1]=arr[i][j];
			}
		}
		
		return results;
	}

}
