
import java.util.*;
import java.io.*;
import java.math.*;

public class Main  {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		int [] nums = new int[test];
		
		//dp[i] = 정수 i를 1,2,3의 합으로 나타내는 방법 
		int [] dp = new int[11];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<11;i++)
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		
		for(int i=0; i<test; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		for(int num: nums) {
			System.out.println(dp[num]);
		}
		
		//dp[2] = 1+1,2 = 2가지
		//dp[3] = 1+1+1,2+1,1+2,3 = 4가지 dp[2]+dp[1]+dp[0]
		//dp[4] = 7 = dp[3]+dp[2]+dp[1] 
		/*dp[5] = (1+4) 1+1+1+1+1 / 1+1+1+2 / 1+1+2+1 /1+2+1+1/ 1+2+2/ 1+1+3/ 1+3+1/ 
		 * (4+1) / 2+1+1+1 / 2+2+1 / 3+1+1
		 (2+3) 2+1+2 2+3 
 		(3+2) 3+2
 		dp[5] = 13 = dp[4]+dp[3]+dp[2];
 		dp[6] = 13+7+4 = 24
 		dp[7] = 24+13+7 = 44
		 * */

		
	}//main method
}
