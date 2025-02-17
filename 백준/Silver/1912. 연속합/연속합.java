import java.util.*;
import java.io.*;
import java.math.*;

/*
 * dp[i] = i번째 원소를 포함하는 연속합의 최대 
 * 

 * */

public class Main {
	
	static int[] dp;
	static int[] arr;
	static int index=0;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int [n+1];
		arr = new int[n+1];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = -1001;

		
		for(int i=1; i<=n; i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
		}
		
		int answer = Integer.MIN_VALUE;
		
		for(int max : dp) {
			answer = Math.max(max, answer);
		}
		System.out.println(answer);
	}

}
