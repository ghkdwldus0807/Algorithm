import java.util.*;
import java.io.*;
import java.math.*;

public class Main  {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		//dp[i] = 2xi 직사각형 만드는 방법의 경우의 수 
		int [] dp = new int[n+2];
		//2x1 = 1 
		//2x2 = 3 / dp[1]+2*dp[0]
		//2x3 = 5 / dp[2]+2*dp[1]
		//2x4 = 11 /dp[3]+2*dp[2]
	
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2; i<=n;i++) {
			dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
		}
		System.out.println(dp[n]);
		
	}//main method
}
