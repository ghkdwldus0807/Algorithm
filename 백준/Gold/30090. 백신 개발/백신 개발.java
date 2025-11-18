import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static String[] arr;
	static int ans = Integer.MAX_VALUE;
	static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new String[N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		//순서가 있는 모든 경우의 수
		for(int i=0; i<N; i++) {
			visited[i] = true;
			dfs(arr[i],1);
			visited[i] = false;
		}
		
		System.out.println(ans);

	}//main
	
	//dfs
	public static void dfs(String current, int n) {
		if(n == N) {
			ans = Math.min(ans, current.length());
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				String next = add(current, arr[i]);
				dfs(next, n+1);
				visited[i] = false;
			}
		}
		
		
	}//dfs
	
	//문자열 합치기
	public static String add(String s1, String s2) {
		StringBuilder sb = new StringBuilder();
		int k = 0 ;
		int min = Math.min(s1.length(), s2.length());
		
		for(int i=1; i<=min; i++) {
			if(s1.substring(s1.length() - i).equals(s2.substring(0,i))) {
				k = i;
			}
		}
		sb.append(s1).append(s2.substring(k));
		return sb.toString();
	}

}
