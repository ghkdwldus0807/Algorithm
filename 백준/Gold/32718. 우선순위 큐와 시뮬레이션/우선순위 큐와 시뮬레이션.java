import java.util.*;
import java.io.*;

public class Main {
	
	static int N,K,T, delta;
	static int[] pq ; 
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		pq = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			pq[i] = Integer.parseInt(st.nextToken())%K;
		}
		
		
		st = new StringTokenizer(br.readLine());
		
		Arrays.sort(pq);
		
		for(int t=0; t<T; t++) {
			
			int a = Integer.parseInt(st.nextToken());
			delta = (delta+a)%K;
			int target = K - delta;
			int idx = binarySearch(target);
			
			int candi1 = -1, candi2 = -1;
			
			//idx가 음수가 아닌 경우 ( == target 이하의 값이 존재하는 경우)
			if(idx>=0)
				candi1 = pq[idx] + delta;
			
			//idx< N-1 인 경우 (== target 값 이상의 원소가 있는 경우)
			if(idx < N-1) {
				candi2 = pq[N-1] + delta - K;
			}
			
			sb.append(Math.max(candi1, candi2)).append(" ");

		}
		
		System.out.println(sb);
		
	}//main
	
	//이분탐색 
	static int binarySearch(int target) {
		
		int left = 0;
		int right = N-1;
		
		while(left<=right) {
			int mid = (left+right)/2;
			
			if(pq[mid]<target) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		
		return right;
	}


}
