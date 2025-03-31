import java.util.*;
import java.io.*;

public class Solution {
	
	/*
	 * N = 사탕의 개수 
	 * M = 한 가방 안에 들어야하는 사탕의 수 
	 * */
	static StringBuilder sb = new StringBuilder();
	static long T,M;
	static int N;
	static long [] candies; //각 캔디의 개수

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Long.parseLong(st.nextToken());
			candies = new long[N];
			st = new StringTokenizer(br.readLine());
			
			long max = -1;
			
			for(int i=0; i<N; i++) {
				long num = Long.parseLong(st.nextToken());
				candies[i] = num;
				max = Math.max(max, num);
			}
			

			long left = 1;
			long right = max ;
			long ans = 0;
			
			while(left<=right) {
				
				long mid = left+(right-left)/2;
				
				if(getCount(mid)<M)
					right = mid - 1;
				else {
					ans = mid;
					left = mid + 1;
				}
					
				
			}
			
			sb.append("#"+t+" "+ans).append("\n");
			
		}//test case
		
		System.out.println(sb);

	}//main 
	
	
	//가방 개수가 x개 일 때, 한 가방에 들어가는 사탕의 수 cnt 반환 
	
	static long getCount(long x) {
		long cnt = 0;
		
		for(int i=0; i<N; i++) {
			cnt+=candies[i]/x;
		}
		
		return cnt;
	}//getCount
	

}
