import java.io.*;

public class Main  {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		//dp[i][j] = 길이가 i이고 j(0 또는 1)로 끝나는 이친수의 수
		//dp[i][1] = dp[i-1][0] 
		//dp[i][0] = dp[i-1][0]+dp[i-1][1];
		long [][] dp = new long [n+1][2];
		
		dp[1][1] = 1;
		
		for(int i=2; i<=n; i++) {
			for(int j=0; j<2; j++) {
				if(j==0)
					dp[i][0] = dp[i-1][0]+dp[i-1][1];
				else
					dp[i][1] = dp[i-1][0];
			}
		}
		
		long sum = 0;
		
		for(int i=0; i<2 ; i++)
			sum += dp[n][i];
		
		System.out.println(sum);
		
	}//main method
}
