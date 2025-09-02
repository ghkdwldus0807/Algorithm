import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0 ; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			long K = Integer.parseInt(st.nextToken());
			
			int count = 0;
			
			int [] houses = new int[N]; //집 배열
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<N; i++) {
				houses[i] = Integer.parseInt(st.nextToken());
			}
			
			
			//슬라이딩 윈도우
			long wd = 0;
			
			//맨 처음 윈도우 크기 구하기 
			for(int i=0; i<M; i++) {
				wd += houses[i];
			}
			
			if(wd < K) {
				count ++;
			}
			
			if(N==M) {
				sb.append(count).append("\n");
				continue;
			}
			else {
				//인덱스 1부터 N까지 슬라이딩 윈도우 
				for(int i=1; i<N; i++) {
					
					wd -= houses[i-1];
					
//					if (i > N-M) {
//						wd += houses[i-(N-M)-1];
//					}
//					else {
//						wd += houses[i+M-1];
//					}
					
					wd += houses[(i+M-1)%N];
					
					
					if(wd < K) {
						count ++;
					}
					
				}
			}
			
			sb.append(count).append("\n");
			
		}//testcase
		
		System.out.print(sb);
	}

}
