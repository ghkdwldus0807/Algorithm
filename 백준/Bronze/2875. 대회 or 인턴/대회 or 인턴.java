import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

	static int N,M,K;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		System.out.println(Math.min((N+M-K)/3, Math.min(N/2, M)));

	}

}
