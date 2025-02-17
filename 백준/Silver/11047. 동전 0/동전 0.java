import java.util.*;
import java.io.*;

public class Main {
	
	/*
	 *문제 조건 :  A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수
	 *위와 같은 조건이 있으므로 큰 단위를 선택하는 것이 항상 최적 해를 가져온다는 조건이 성립된다. ..
	 * */

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int [] coins = new int[n];
		
		for(int i=0; i<n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int answer = 0;
		
		//큰 단위부터 검증 
		
		for(int i=n-1; i>=0; i--) {
			if(coins[i]>k)
				continue;
			
			if(k==0)
				break;
			
			int rest = k/coins[i];
//			System.out.println("rest: " + rest);
			answer += rest;
//			System.out.println("answer :" +answer);
			
			k = k-rest*coins[i];
//			System.out.println("k : " + k);
			
		}
		
		System.out.println(answer);



		
	}

}
