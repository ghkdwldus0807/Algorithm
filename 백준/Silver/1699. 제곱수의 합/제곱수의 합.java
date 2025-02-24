import java.util.*;
import java.io.*;
import java.math.*;

/*
 * dp[i] = 자연수 i를 제곱수들의 합으로 표현할 때에 그 항의 최소 개수 
 * 
 * 분기 
 * 1. i가 제곱수 일 때 (1,4,9,16 ... )
 * 2. i가 제곱 수의 배수 일 때 (8, 12, 32, 18 등..)
 * 3. 그 외 ) dp [i] = dp[i-j] + dp[j];
 * 3-1. j = i보다 작은 제곱 수 
 * 
 * */

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int [] dp = new int [num+1];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=1; i<=num; i++) {

			for(int j=1; j*j<=i; j++) {
				if(i%(j*j)==0) {
					dp[i] = Math.min(dp[i], i/(j*j));
				}
				else
					dp[i] = Math.min(dp[i], dp[i-(j*j)]+dp[j*j]);
			}
			
		}//for - i
		
		
		System.out.println(dp[num]);

		                                                                                                      
	}//main

}
