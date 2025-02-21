import java.util.*;
import java.io.*;


/*
 * 가중치가 큰 거 부터 연결?
 * -> 출발지와 목적지의 루트 부모가 같아지면 stop -> 해당 가중치 중 가장 작은 가중치가 정답? 
 * */

public class Main {
	
	
	static class Bridge implements Comparable<Bridge>{
		
		int h1;
		int h2; 
		int k; 
		
		public Bridge(int h1, int h2, int k) {
			this.h1 = h1;
			this.h2 = h2;
			this.k = k;
		}
		
		@Override
		public int compareTo(Bridge o) {
			return o.k - this.k;
			
		}
		
	}
	
	
	static int n,m,s,e;
	static int[] parent;
	static PriorityQueue<Bridge> pq = new PriorityQueue<>();
	static int min = 0;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int h1 = Integer.parseInt(st.nextToken());
			int h2 = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			pq.add(new Bridge(h1,h2,k));
		}
		
		while(!pq.isEmpty()) {
			
			Bridge bridge = pq.poll();
			int h1 = bridge.h1;
			int h2 = bridge.h2;
			int k = bridge.k;
			
			if(isSameParent(s,e))
				break;
			
			if(isSameParent(h1,h2))
				continue;
			else {
				union(h1,h2);
				min = k;
			}
			
		}
		
		if(!isSameParent(s,e))
			min = 0;
		
		
		System.out.println(min);
		
		
	}//main 
	
	
	static int find(int index) {
		if(index == parent[index])
			return index;
		
		return parent[index] = find(parent[index]);
		
	}//find
	
	
	static void union(int a, int b) {
		
		int ap = find(a);
		int bp = find(b);
		
		if(ap>bp)
			parent[ap] = bp;
		else 
			parent[bp] = ap;
	}//union
	
	
	static boolean isSameParent(int a, int b) {
		
		int ap = find(a);
		int bp = find(b);
		
		if(ap == bp)
			return true;
		return false;
	}

}
