import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] sizes = new int [6];
		
		for(int i=0; i<6; i++) {
			sizes[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int tNum = 0;
		
		for(int n : sizes) {
			if(n==0)
				continue;
			if(n%T == 0) {
				tNum += (n/T);
			}
			else tNum += (n/T)+1;
		}
		
		sb.append(tNum).append("\n");
		sb.append(N/P).append(" ").append(N%P);
		System.out.println(sb);
	}//main

}
