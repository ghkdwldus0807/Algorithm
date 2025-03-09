import java.io.*;
import java.util.*;

public class Main {
	
	static int N; 
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i= 0; i<N ; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		
		long sum = 0; // 누적합 
		long answer = 0 ; //진짜 정답 
		
		for(int i=0; i<N; i++) {
			sum += pq.poll();
			answer += sum;
		}
		
		System.out.println(answer);
		
	}

}
