import java.util.*;
import java.io.*;

/*
 * 1. 각 그래프 중에서 가장 작은 친구비를 가지고 있는 친구를 고르면 됨 
 * 2. 
 * 
 * */

public class Main {
	
	static class Friend{
		
		int cost; 
		int rootParent;
		
		public Friend(int rootParent, int cost) {
			this.rootParent = rootParent;
			this.cost = cost;
		}
		
	}
	
	static Friend [] parent;
	static int N, M, k;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		parent = new Friend[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; i++) {
			int cost = Integer.parseInt(st.nextToken());
			parent[i] = new Friend(i,cost);
		} // input
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int std1 = Integer.parseInt(st.nextToken());
			int std2 = Integer.parseInt(st.nextToken());
			
			union(std1, std2);
			
		}

		
		int [] ans = new int[N+1];
		
		for(int i = 1; i<=N; i++) {
			if(ans[find(parent[i].rootParent)]==0)
				ans[find(parent[i].rootParent)] =  parent[i].cost;
			else 
				ans[find(parent[i].rootParent)] = Math.min(ans[find(parent[i].rootParent)], parent[i].cost);
		}
		
//		for(int i = 1; i<=N; i++) {
//			System.out.println(parent[i].rootParent + " : " +parent[i].cost);
//		}
		int sum = 0;
		
		for(int num : ans) {
			sum += num;
		}
		
		if(sum>k)
			System.out.println("Oh no");
		else 
			System.out.println(sum);
		

		
		
	}
	
	
	static int find(int index) {
		if(index == parent[index].rootParent)
			return index;
		
		return parent[index].rootParent = find(parent[index].rootParent);
	}
	
	static void union(int a, int b) {
		
		int ap = find(a);
		int bp = find(b);
		
		if(parent[ap].rootParent>parent[bp].rootParent) {
			parent[ap].rootParent = parent[bp].rootParent;
		
		}
		else {
			parent[bp].rootParent = parent[ap].rootParent;
			
		}
	}
	
	static boolean isSameParent(int a, int b) {
		int ap = find(a);
		int bp = find(b);
		
		if(parent[ap].rootParent == parent[bp].rootParent)
			return true;
		
		return false;
		
	}

}
