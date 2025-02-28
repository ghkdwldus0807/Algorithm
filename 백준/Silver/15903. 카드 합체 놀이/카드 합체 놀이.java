import java.util.*;
import java.io.*;


public class Main {

	static PriorityQueue<Long> pq = new PriorityQueue<>();
	static int n,m;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			pq.add((long) Integer.parseInt(st.nextToken()));
		}
		
		for(int i=0; i<m; i++) {
			
			long n1 = pq.poll();
			long n2 = pq.poll();
			
			long sum = n1+n2;
			
			pq.add(sum);
			pq.add(sum);
		}
		
		long total = 0;
		
		for(long num : pq)
			total += num;
		
		System.out.println(total);

		
	}

}
