import java.util.*;
import java.io.*;

/*
 * dp[i] = 1 (i<3);
 * dp[i] = dp[i-3]+dp[i-2]; (i>3)
 * 
 * */

public class Main {
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		for(int a=0; a<num; a++) {
			int n = Integer.parseInt(br.readLine());
			
			long [] dp = new long[n+1];
			
			dp[1] = 1;
			
			if(n>=2) {
				dp[2] = 1;
			}
			
			if(n>=3) {
				for(int i=3; i<=n; i++) {
					dp[i] = dp[i-3] + dp[i-2];
				}
			}
			
			System.out.println(dp[n]);
			
		}//for
	}

}
