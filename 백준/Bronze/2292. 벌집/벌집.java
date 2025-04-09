import java.io.*;
import java.util.*;

public class Main {

	static int N; 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		if(N==1) {
			System.out.println(1);
			return;
		}
		
		int cnt = 1;
		int max = 1;
		
		while(true) {
			if(N <= max) {
				System.out.println(cnt);
				return;
			}
			else {
				max += 6*cnt;
				cnt++;
			}
		}

	}//main

}
