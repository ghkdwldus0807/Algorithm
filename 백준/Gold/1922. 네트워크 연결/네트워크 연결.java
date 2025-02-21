import java.util.*;
import java.io.*;

public class Main {

	static class Computer implements Comparable<Computer>{
		
		int a;
		int b; 
		int cost;
		
		public Computer(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.cost = c;
		}

		@Override
		public int compareTo(Computer o) {
			return this.cost - o.cost;
		}
		
	}
	
	static int n,m;
	static int[] parent;
	static PriorityQueue<Computer> pq = new PriorityQueue<>(); //compareTo에 따라 자동 정렬됨 
	static int ans=0;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		parent = new int[n+1];
		
		for(int i=1; i<=n; i++){
			parent[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			pq.add(new Computer(a,b,c));
			
		}//pq에 입력 및 자동 정렬 
		
		for(int i=0; i<m; i++) {
			
			Computer com = pq.poll();
			int a = com.a;
			int b = com.b;
			int cost = com.cost;
			
			if(isSameParent(a, b))
				continue;
			else {
				union(a,b);
				ans += cost;
			}
		}
		
		System.out.println(ans);
		
		
		
	}//main 
	
	
	
	static int find(int index) {
		if (index == parent[index] )
			return index;
		 
		return parent[index] = find(parent[index]);
	}//find
	
	
	static void union(int a, int b) {
		int ap = find(a);
		int bp = find(b);
		
		if(ap>=bp)
			parent[ap] = bp;
		else 
			parent[bp] = ap;
	}//union 
	
	
	static boolean isSameParent(int a, int b) {
		int ap = find(a);
		int bp = find(b);
		
		if(ap==bp)
			return true;
		
		return false; 
	}//isSameParent

}
