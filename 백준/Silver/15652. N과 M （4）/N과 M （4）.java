import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m;
	static int [] num;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		num = new int [m];
		
		set(1,0);
		
		System.out.println(sb);

		
	}
	
	static void set(int start, int index) {
		
		if(index == m) {
			for(int i: num)
				sb.append(i+" ");
			sb.append("\n");
			return;
		}
		
		for(int i =start ; i<=n; i++) {
			
			num[index] = i;
			set(start,index+1);
			start++;
		}
		
		
		
	}

}
