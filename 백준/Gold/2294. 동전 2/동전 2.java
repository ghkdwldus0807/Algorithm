import java.io.*;
import java.util.*;
import java.math.*;

/*
 * dp[i] = 가치 합 i를 만들기 위해 필요한 동전 최소 개수 
 * 
 * pseudo code 
 * 1. 동전 가치를 오름차순으로 정렬 
 * 2. i가 각 동전 가치의 배수인지 확인 => 배수이면 dp[i] = 몫               
 * 3. 배수가 아니라면? dp[i-동전가치 합] == -1 인지 확인 
 * 3-1. 반복문 끝까지 돌았는데도 == -1 이라면 -1,, 
 * 3-2. dp[i-동전가치] != -1 이라면 dp[i] = dp[i-동전가치] + 1 
 * 
 * */

public class Main {
	
	static int [] dp; 
	static int [] coins; 
	static int n,k;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dp = new int[k+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		coins = new int[n];
		
		for(int i=0; i<n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}//입력 
		
		
		Arrays.sort(coins);
		
		
		dp[0] = 0;
		
		for(int coin: coins) {
			for(int i=coin; i<=k; i++) {
				if(dp[i-coin]!=Integer.MAX_VALUE)
					dp[i] = Math.min(dp[i], dp[i-coin]+1);
				
			}
			
		}//dp 점화식 
		
		if(dp[k] == Integer.MAX_VALUE)
			System.out.println(-1);
		
		else System.out.println(dp[k]); 
		
		
	}

}
