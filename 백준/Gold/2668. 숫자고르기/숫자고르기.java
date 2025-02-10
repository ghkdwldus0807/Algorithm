import java.util.*;
import java.io.*;


public class Main {

	//1. 인덱스의 집합과 value의 집합이 같아야함. 
	//2. 인덱스 1부터 돌면서 arr[i] = value, arr[value] = i이면 해당 index를 뽑는다.  
	
	static int n;
	static ArrayList<Integer> result;
	static boolean [] visited;
	static int count;
	static ArrayList<ArrayList<Integer>> graphs;
	static int start;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		graphs = new ArrayList<>();
		visited = new boolean [n+1];
		
		for(int i=0; i<=n; i++) {
			graphs.add(new ArrayList<>());
		}
		for(int i=1; i<=n; i++) {
			int n1 = Integer.parseInt(br.readLine());
			graphs.get(i).add(n1);
		}
		
		result = new ArrayList<Integer>();
		
		for(int i=1 ; i<=n; i++) {
			visited = new boolean[n+1];
			start = i;
			if(dfs(i)) {
				result.add(i);
			}

		}
		
		count = result.size();
		
		Collections.sort(result);
		
		System.out.println(count);
		for(int num: result)
			System.out.println(num);
		
		
		
	}//main
	
	
	
	static boolean dfs(int vertex) {
		
		visited[vertex] = true;
		
		for(int node : graphs.get(vertex)) {
			
			if(!visited[node]) {
				if(dfs(node))
					return true;
//				else if(node==start)
//					return true;
			}else if(node==start)
				return true;
				
		}
		return false;
		
	}
	


}
