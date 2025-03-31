import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, N; 
	static long L,M;
	static PeekTime [] times ; //피크 타임 저장 배열
	static long sum[]; //피크 타임 광고 누적 합 저장 배열 
	static StringBuilder sb = new StringBuilder();
	
	static class PeekTime{
		private long s,e;
		
		public PeekTime(long s, long e) {
			this.s = s;
			this.e = e;
		}
		
	}//inner class  - PeekTime

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			
			L = Long.parseLong(br.readLine());
			N = Integer.parseInt(br.readLine());
			times = new PeekTime[N];
			sum = new long[N+1];
			
			long s=0,e=0;
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				s = Long.parseLong(st.nextToken());
				e = Long.parseLong(st.nextToken());
				times[i] = new PeekTime(s,e);
				
				sum[i+1] = sum[i] + (e - s); 
			}//input
			
			long ans = 0;
			
			//이분탐색 
			for(int i=0; i<N; i++) {
				int left = i;
				int right = N-1;
				
				while(left<=right) {
					int mid = left + (right-left)/2;
					
					long peekTimes = times[mid].e - times[i].s; // 실제 광고 시간 
					
					if(peekTimes<=L) {
						left = mid+1;
					}
					else {
						right = mid - 1;
					}
					
				}//while
				
				
				long adTime = sum[left] - sum[i];
				
				if(left!=N) {
					adTime += Math.max(0, times[i].s+L - times[left].s);
				}
				
				ans = Math.max(ans, adTime);
				
			}//이분탐색 
			
			sb.append("#"+t+" "+ans+"\n");
			
			
		}//test case
		
		System.out.print(sb);

	}//main
	

	

}
