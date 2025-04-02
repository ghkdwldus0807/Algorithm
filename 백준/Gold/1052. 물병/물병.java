import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K, count;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); 
		//입력
		
		while(true) {
			
			int oneCount = Integer.bitCount(N); //1의 개수 
			
			if(oneCount<=K) {
				break;
			}
			
			int idx = Integer.numberOfTrailingZeros(N);
			N += 1<<idx;
			count += 1<<idx;
			
		}
		
		System.out.println(count);

	}//main

}
