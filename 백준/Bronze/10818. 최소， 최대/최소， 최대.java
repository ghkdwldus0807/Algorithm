import java.util.*;
import java.io.*;

public class Main  {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int min = 1000001;
		int max = -1000001;
		
		for(int i=0; i<num; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			if(n>max)
				max = n;
			
			if (n<min)
				min = n;
		}
		System.out.printf("%d %d", min, max);
	}
}
