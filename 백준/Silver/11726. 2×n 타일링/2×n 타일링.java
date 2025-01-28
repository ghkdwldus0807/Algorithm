
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
		// 2x2 = 2 
		//2x3 = 2+1=3 / dp[2]+dp[1]
		//2x4 = 1+3+1=5 
		//2x5 = 4+3+1 = 8 
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3; i<=n;i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
		System.out.println(dp[n]);
		
	}//main method
}
