import java.io.*;
import java.util.*;

public class Main {
	
	static int T,k,n;
	static int [][] dp ; //dp[i][j] : i층 j호에 사는 사람의 수 
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			
			dp = new int[k+1][n+1];
			
			for(int i=0; i<=n; i++) {
				dp[0][i] = i;
			} //init
			
			for(int i=1; i<=k; i++) {
				for(int j=1; j<=n; j++) {
					dp[i][j] = getP(i, j);
				}
			}
			
			sb.append(dp[k][n]).append("\n");
		}//test case
		
		System.out.println(sb);
		
	}//main 
	
	//사는 사람 구하는 메서드 
	static int getP(int k, int n) {
		int sum=0;
		
		for(int i=1; i<=n; i++) {
			sum += dp[k-1][i];
		}
		
		return sum;
	}

}
