import java.io.*;

public class Main  {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		//dp[i][j] = 길이가 i이고 j로 끝나는 오르막 수의 개수 
		//dp[i][j]는 dp[i-1][x] (x>=j) 일 때 +1 이다.
		
		long [][] dp = new long[n+1][10];
		
		for(int i=0; i<10;i++) {
			dp[1][i] = 1;
		}
		
		for(int i=2; i<=n; i++) {
			for(int j=0; j<10; j++) {
				for(int x=j; x<10; x++) {
					dp[i][x] += dp[i-1][j]%10007;
				}
			}
		}
		
		long sum = 0;
		for(int i=0; i<10;i++) {
			sum+=dp[n][i];
		}
		System.out.println(sum%10007);
		
	}//main method
}
