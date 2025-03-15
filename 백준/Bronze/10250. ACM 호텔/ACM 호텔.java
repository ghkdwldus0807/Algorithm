import java.io.*;
import java.util.*;

public class Main {
	
	static int T, H,W,N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			int floor = 0;
			int room = 0; 
			
			if(N%H == 0) {
				floor = H;
				room = N/H;
			}
			else {
				floor = N%H;
				room = N/H + 1; 
			}
			
			if(room/10<1) {
				sb.append(floor).append(0).append(room);
			}
			else 
				sb.append(floor).append(room);
			sb.append("\n");
		
		}//test case 
		
		System.out.println(sb);
	}//main

}
