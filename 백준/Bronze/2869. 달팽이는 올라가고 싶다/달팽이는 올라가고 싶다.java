import java.io.*;
import java.util.*;

public class Main {
	
	static int A,B,V,days; 

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		if((V-B)%(A-B) == 0 ) {
			days = (V-B)/(A-B); 
		}
		else {
			days = (V-B)/(A-B) + 1; 
		}
		System.out.println(days);
	}

}
