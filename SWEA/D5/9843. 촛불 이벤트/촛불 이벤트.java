import java.util.*;
import java.io.*;
import java.math.*;


public class Solution {
	
	static StringBuilder sb = new StringBuilder();
	static int T;
	static long N;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Long.parseLong(br.readLine());

			long left = 1; 
			long right = 10000000000L;
			long ans = -1;
			
			while(left<=right) {
				
				long mid = left + (right-left)/2;
				
				long count = (mid*(mid+1))/2; //만들 수 있는 양초 개수
				
				if(count == N) {
					ans = mid;
					break;

				}
				
				if(count<N) {
					left = mid + 1;
				}
				else if(count > N) {
					right = mid -1; 
				}

			}
			
			sb.append("#"+t+" "+ans+"\n");
			
			
		}//testcase
		
		System.out.print(sb);

	}//main 
	
	


}
