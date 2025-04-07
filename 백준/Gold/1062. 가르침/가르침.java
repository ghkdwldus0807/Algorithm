import java.util.*;
import java.io.*;

public class Main {
	
	static int N,K, max = -1; 
	static int [] words;
	static boolean [] visited = new boolean[26];
	/*word : a = 1, z = 26 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(K<5) {
			System.out.println(0);
			return;
		}
		if(K == 26) {
			System.out.println(N);
			return;
		}
		
		words = new int[N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			int bit = 0;
			for(char ch:str.toCharArray()) {
				bit |= (1<<(ch-97));
			}
			
			words[i] = bit;
			
		}//input
		
		visited[0] = true;
		visited[2] = true;
		visited[8] = true;
		visited[13] = true;
		visited[19] = true;
		
		//a,n,t,i,c를 제외한 k-5개 뽑는 모든 조합 구하기
		dfs(0,0);
		System.out.println(max);


	}//main
	
	//dfs 조합구하기 
	static void dfs(int start, int index) {
		
		if(index == K - 5) {
			int count = 0; 
			int combi = 0;
			
			for(int i =0; i<26; i++) {
				if(visited[i]) {
					combi |= (1<<i);
				}
			}
			
			for(int word : words) {
				if((word&~combi)==0) {
					count ++;
				}
			}
			
			max = Math.max(max, count);
			return;
			
		}
		
		for(int i=start; i<26; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i+1, index+1);
				visited[i] = false;
				
			}
		}
	}//dfs
}
