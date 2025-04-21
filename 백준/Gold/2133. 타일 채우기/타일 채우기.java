import java.io.*;

public class Main {

	static int N;
	static int[] dp ;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		
		dp[0] = 1; 
		
		for(int i=1; i<=N; i++) {
			if(i%2==0) {
				int temp = 0; 
				temp += dp[i-2] * 3;
				
				for(int j=i-4; j>=0; j = j-2) {
					temp += dp[j] * 2;  
				}
				
				dp[i] = temp;
				
			}else {
				dp[i] = 0;
			}
		}
		
		System.out.println(dp[N]);
		
	}

}
