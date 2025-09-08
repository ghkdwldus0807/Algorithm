import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int [] child = new int [N];
		int [] dp = new int [N];
		
		for(int i=0; i<N; i++) {
			child[i] = Integer.parseInt(br.readLine());
		}
		
		//dp
		
		Arrays.fill(dp, 1);
		int ans = 0; 
		
		for(int i=1; i<N; i++) {
			int max = -1;
			int cur = child[i];
			for(int j=0; j<i; j++) {
				int prev = child[j];
				max = Math.max(max, prev);
				
				if(prev<cur) {
					dp[i] = Math.max(dp[j]+1, dp[i]);
				}
			}
			ans = Math.max(ans, dp[i]);
		}

		System.out.println(N-ans);
		
	}

}
