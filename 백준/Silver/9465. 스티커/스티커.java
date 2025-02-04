import java.io.*;
import java.util.*;
import java.math.*;

public class Main  {
	
	//dp[i][j] = [i,j] 좌표에 위치한 스티커의 최대 점수 합
	//규칙
	//dp[0][i] += dp[1][i-1] 또는 +=dp[1][i-2] 중에 큰 값을 더한다.
	//dp[1][i] += dp[0][i-1] 또는 +=dp[0][i-2] 중에 큰 값을 더한다.
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testNum = Integer.parseInt(br.readLine());
		
		for(int i=0; i<testNum; i++) {
			int n = Integer.parseInt(br.readLine());
			int [][] stickers = new int [2][n+1];
			long [][] dp = new long [2][n+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringTokenizer st2= new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				stickers[0][j] = Integer.parseInt(st.nextToken());
				stickers[1][j] = Integer.parseInt(st2.nextToken());
			}
			
			dp[0][0] = stickers[0][0];
			dp[1][0] = stickers[1][0];
			dp[0][1] = dp[1][0] + stickers[0][1];
			dp[1][1] = dp[0][0] + stickers[1][1];
			
			if(n!=1) {
				for(int j=2; j<n; j++) {
					dp[0][j] = stickers[0][j] + Math.max(dp[1][j-1], dp[1][j-2]);
					dp[1][j] = stickers[1][j] + Math.max(dp[0][j-1], dp[0][j-2]);
				}
			}
			
			System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
			
		}
		
		
	}//main method
}
