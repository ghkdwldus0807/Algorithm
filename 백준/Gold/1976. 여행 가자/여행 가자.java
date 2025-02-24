import java.io.*;
import java.util.*;

public class Main {
	
	static int [] parent; 
	static int N,M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}// root parent 초기화 
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=1; j<=N; j++) {
				int node = Integer.parseInt(st.nextToken());
				
				if(node==1)
					union(i,j);
				
			}
		}//입력 받기 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		String ans = "YES";
		for(int i=1; i<M; i++) {
			if(!isSameParent(a, Integer.parseInt(st.nextToken()))) {
				ans = "NO";
				break;
			}
				
		}
		
		System.out.println(ans);
		

	}//main 
	
	
	static int find(int index) {
		if (index == parent[index])
			return index;
		
		return parent[index] = find(parent[index]);
	}
	
	
	static void union(int a, int b) {
		
		int ap = find(a);
		int bp = find(b);
		
		if(ap>bp)
			parent[ap] = bp;
		else 
			parent[bp] = ap;
		
	}
	
	
	static boolean isSameParent(int a, int b) {
		int ap = find(a);
		int bp = find(b);
		
		if(ap==bp)
			return true;
		return false;
	}

}
