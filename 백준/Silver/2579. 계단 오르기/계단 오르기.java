import java.util.*;
import java.io.*;
import java.math.*;

/*
 * dp[i] = i번쨰 계단이 마지막 계단일 때, 최대 합 
 * 
 * dp[i] = dp[i-2] + arr[i] OXO
 * 		 = dp[i-3] + +arr[i-1] + arr[i] XOO
 * => 둘 중 max 
 * 
 * */
public class Main {

	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int [] arr = new int [n+1];
		long [] dp = new long [n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = arr[1];
		
		if(n>=2) {
			dp[2] = arr[1]+arr[2];
		}
		
		if(n>=3) {
			for(int i=3; i<=n; i++) {
				dp[i] = Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]);
			}
		}
		
		System.out.println(dp[n]);
		
	}//main

}
