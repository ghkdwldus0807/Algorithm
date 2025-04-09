import java.io.*;
import java.util.*;

public class Main {
	
	static int N;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int ans = 0;
		
		for(int i=1; i<N; i++) {
			if(isConstructor(i)) {
				ans = i;
				break;
			}
		}
		
		System.out.println(ans);

	}//main
	
	static boolean isConstructor(int n) {
		
		int sum = n;
		String str = String.valueOf(n);
		
		for(int i=0; i<str.length(); i++) {
			sum += (str.charAt(i) - '0');
		}
		
		if(sum == N)
			return true;
		
		return false;
	}

}
