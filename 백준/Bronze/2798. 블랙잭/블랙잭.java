import java.io.*;
import java.util.*;

public class Main {

	static int N, M, minSum;
	static int [] cards;
	static boolean end;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); //총 합 
		
		cards = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0, 0);
		
		System.out.println(minSum);

	}//main
	
	//조합 구하기
	static void dfs(int start, int depth, int sum) {
		
		if(depth == 3) {
			
			if(sum<=M && sum>minSum) {
				minSum = sum;
				if(sum == M)
					end = true;
			}
			
			return;
		}
		
		for(int i = start; i<cards.length; i++) {
			dfs(i+1, depth+1,sum+cards[i]);
			if(end) return;
		}
		
	}//dfs
}
