import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	
	static int N,cnt;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(n==1)
				continue;
			if(isPrime(n))
				cnt++;
		}
		
		System.out.println(cnt);

	}//main
	
	static boolean isPrime(int n) {
		int sq = (int)Math.sqrt(n);
		
		for(int i=2; i<=sq; i++) {
			if(n%i == 0)
				return false;
		}
		return true;
	}

}
