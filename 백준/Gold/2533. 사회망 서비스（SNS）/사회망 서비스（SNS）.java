import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static int[][] dp; //dp[i][0] = i가 얼리어답터가 아닐 때 i의 서브트리에 필요한 얼리어답터 수 (무조건 자식은 얼리어답터)
	//dp[i][1] = i가 얼리어답터일때 
	static boolean [] visited;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<=N; i++) {
			tree.add(new ArrayList<Integer>());
		}
		
		for(int i=1; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree.get(u).add(v);
			tree.get(v).add(u);
		}
		
		dp = new int[N+1][2];
		visited = new boolean[N+1];
		dfs(1,0);
		
		System.out.println(Math.min(dp[1][0], dp[1][1]));
		
		
	}//main
	
	//트리 탐색 dfs
	public static void dfs(int child, int parent) {
		
		dp[child][0] = 0;
		dp[child][1] = 1;
		
		visited[child] = true;
		
		for(int i : tree.get(child)) {
			if(visited[i]) {
				continue;
			}
			dfs(i,child);
			dp[child][0] += dp[i][1]; 
			dp[child][1] += Math.min(dp[i][0], dp[i][1]); 
		}
	}
}
