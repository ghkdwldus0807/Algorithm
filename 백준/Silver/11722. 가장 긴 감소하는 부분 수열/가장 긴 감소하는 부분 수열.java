import java.util.*;
import java.io.*;

/*
 * dp[i] = 1~i 번째 수 까지 주어졌을 때, 가장 긴 감소하는 부분 수열의 길이
 * 
 * 만약 arr[i]가 현재 나왔던 수 중에서 가장 큰 수이면 무조건 길이 = 1
 * 
 * */

public class Main {
	
	static int [] dp;
	static int [] arr; 
	static int maxValue = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		dp = new int[n+1];
		arr = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		for(int i=1; i<=n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=1; i<=n; i++) {
			if(arr[i]>maxValue) {
				maxValue = arr[i];
				dp[i] = 1;
				continue;
			}
			for(int j=1; j<i; j++) {
				if(arr[j]>arr[i])
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
		}//for 
		
		int answer = 0 ;
		
		for(int num : dp) {
			answer = Math.max(answer, num);
		}
		
		System.out.println(answer);
	}

}
