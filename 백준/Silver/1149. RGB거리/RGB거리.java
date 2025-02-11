import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

	
	/*
	 * 1.dp[i][0] => 집 i가 빨간색 일떄 최소 비용 누적값 
	 * 2 dp[i][1] => 집 i가 초록색 일떄 최소 비용 누적값 
	 * 3.dp[i][2] => 집 i가 파란색 일떄 최소 비용 누적값 
	 * 
	 * dp[i][0] = dp[i-1][n] + 집 i가 빨간색비용 (n!=0)
	 * */
	
	
	static long[][] dp;
	static int[][] costs; //각 집의 비용
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		//index 1부터 시작하기 위해서 n+1
		dp = new long[n+1][3];
		costs = new int[n+1][3];
		
		//각 집의 비용 입력받기
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			costs[i][0] = Integer.parseInt(st.nextToken());
			costs[i][1] = Integer.parseInt(st.nextToken());
			costs[i][2] = Integer.parseInt(st.nextToken());
		}
		
		//dp 계산
		
		dp[1][0] = costs[1][0];
		dp[1][1] = costs[1][1];
		dp[1][2] = costs[1][2];
		
		for(int i=2; i<=n; i++) {
			dp[i][0] = costs[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
			dp[i][1] = costs[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
			dp[i][2] = costs[i][2] + Math.min(dp[i-1][0],dp[i-1][1]);
		}
		
		System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
	}

}
