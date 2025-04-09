import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long a,b,c;
		PriorityQueue<Long> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());
			c = Long.parseLong(st.nextToken()); 
			
			pq.add(a); pq.add(b); pq.add(c);
			
			if(a==0)
				break;
			
			a = pq.poll();
			b = pq.poll();
			c = pq.poll(); //제일 긴 변 
			
			if(a+b>c) {
				
				if((long)Math.pow(a, 2)+(long)Math.pow(b, 2) == (long)Math.pow(c, 2)) {
					sb.append("right").append("\n");
					continue;
				}
					
			}
			sb.append("wrong").append("\n");
			
		}
		
		System.out.println(sb);
	}
}
