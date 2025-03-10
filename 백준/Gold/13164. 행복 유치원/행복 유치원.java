import java.io.*;
import java.util.*;

/*
 * 
 * priority queue에 인접 어린이들간의 키 차이를 넣어줌
 * 제일 큰 distance를 뺌 => K-1 번 빼줌 => 즉 집합에 들어갈 원소를 빼기 
 * 
 * */

public class Main {

	static int N,K,cost;
	static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}
	});
	
	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int left = 0;
		int right = 0;
		
		st = new StringTokenizer(br.readLine());
		left = Integer.parseInt(st.nextToken());
		for(int i=0; i<N-1; i++) {
			right = Integer.parseInt(st.nextToken());
			pq.add(right-left);
			left = right;
		}

//		while(!pq.isEmpty()) {
//			System.out.println(pq.poll());
//		}
		
		for(int i=1; i<K; i++) {
			pq.poll();
		}
		
		for(int i=0; i<N-K; i++) {
			cost += pq.poll();
		}
		
		System.out.println(cost);
		
	}//main 


}
