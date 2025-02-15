import java.util.*;
import java.io.*;
import java.math.*;

/*
 * dp[i] : 1~i번째 수까지 주어졌을 때 합이 가장 큰 부분 수열의 합 
 * 
 * */


public class Main {
	
	static int [] dp;
	static int [] arr;
	

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //수열의 크기 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		dp = new int[n+1];
		arr = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
			
		}
		
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<i; j++) {
				if(arr[j]<arr[i]) {
					dp[i] = Math.max(dp[i], dp[j]+arr[i]);
				}
				
			}
		}
		
		int max = 0;
		
		for(int num : dp) {
			max = Math.max(num,max);
		}
		
		System.out.println(max);
		

	}

}
