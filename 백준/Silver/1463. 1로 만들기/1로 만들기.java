import java.util.*;
import java.io.*;
import java.math.*;

public class Main  {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int [] dp = new int[n+1];
		//index는 정수 N을 의미한다.
		for(int i=2; i<=n;i++) {
			dp[i] = dp[i-1] + 1;
			if(i%2==0)
				dp[i] = Math.min(dp[i],dp[i/2]+1);
			if(i%3==0)
				dp[i] = Math.min(dp[i],dp[i/3]+1);
		}
		System.out.println(dp[n]);
		

	}//main method
}
