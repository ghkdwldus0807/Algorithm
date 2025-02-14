import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
	
	/*
	 * Reference 본 문제
	 * 
	 * dp[i] = 1부터 i번째 수까지 주어졌을 때, 가장 긴 증가하는 부분 수열의 길이 
	 * 
	 * i 번째 수가 1 ~ i-1 중 가장 작은 수 이면 dp[i] => 1 
	 * => 이건 초기값을 1로 설정하는 것으로 해결 
	 * 
	 * 만약 i번째 수가 가장 작은 수가 아니라면 
	 * dp[i] = dp[1] ~ dp[i-1] 중 가장 max + 1;
	 * 
	 * 
	 * */
	
	static int minNum = Integer.MAX_VALUE;
	static int [] dp ;
	static int [] arr ;
	

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); //수열A의 크기
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		dp = new int[n+1];
		arr = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.fill(dp, 1);
		
		for(int i=1; i<=n; i++) {
			if(arr[i]<=minNum) {
				minNum = arr[i];
				continue;
			}
			for(int j=1; j<i; j++) {
				if(arr[j]<arr[i])
					dp[i] = Math.max(dp[j]+1, dp[i]);

			}
		}

		int max = 0;
		
		for(int num : dp) {
			max = Math.max(max, num);
		}
		
		System.out.println(max);
	}

}
