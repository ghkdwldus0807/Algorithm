import java.io.*;

public class Main  {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		//dp[i][j] = 길이가 i이고 j로 끝나는 계단 수의 개수 
		long [][] dp = new long[n+1][10];
		
		for(int i=1; i<10;i++) {
			dp[1][i] = 1;
		}
		
		for(int i=2; i<=n; i++) {
			for(int j=0; j<10; j++) {
				if(j == 0)
					dp[i][0] += dp[i-1][1]%1000000000;
				else if(j == 9)
					dp[i][9] += dp[i-1][8]%1000000000;
				else {
					dp[i][j] += (dp[i-1][j+1]+dp[i-1][j-1])%1000000000;

				}
			}
		}
		
		long sum = 0;
		for(int i=0; i<10;i++) {
			sum+=dp[n][i];
		}
		System.out.println(sum%1000000000);
		
		//dp[0] = 0
		//dp[1] = 9 / 1,2,3,4,5,6,7,8,9 
		//dp[2] = 17 /10,12,21,23,32,34,...78,87,89,98 => 0과 9로 끝나는 수 = 2개 
		//dp[3] = 15*2+2 = 32 / 101,121,123,...,210,...,789,989 => 0과 9로 끝나는 수 = 3개 
		
		//dp[i] = dp[i-1]에서 0이나 9로 끝나는 수(i-1 개이다)는 1개로 카운트, 그 이외는 *2 
		

		
	}//main method
}
