import java.io.*;
import java.util.*;


public class Main {
	
	static int n,m;
	static boolean[] visited; 
	static int[] num;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		num = new int [m];
		visited = new boolean[n+1];
		
		dfs(0);
		
		System.out.println(sb);


	}//main 
	
	static void dfs(int index) {
		
		if(index==m) {
			for(int i: num)
				sb.append(i+" ");
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=n; i++) {
			
			if(!visited[i]) {
				num[index] = i;
				visited[i] = true;
				dfs(index+1);
				visited[i] = false;
			}
			
		}
	
		
		
	}

}
