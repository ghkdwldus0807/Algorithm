import java.util.*;
import java.io.*;

public class Main {
	
	static int nodeNum, edgeNum;
	static int [] parent; 

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nodeNum = Integer.parseInt(br.readLine());
		edgeNum = Integer.parseInt(br.readLine());
		
		parent = new int[nodeNum+1];
		
		for(int i=1; i<=nodeNum; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<edgeNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		int count = 0;
		
		for(int i=2; i<=nodeNum; i++) {
			if(isSame(1,i))
				count ++;
		}
		
		System.out.println(count);
		
	}
	
	
	
	static int find(int index) {
		
		if(index == parent[index])
			return index;
		
		return parent[index] = find(parent[index]);
		
	}
	
	static void union(int a, int b) {
		
		int aP = find(a);
		int bP = find(b);
		
		if(aP>bP) {
			parent[aP] = bP;
		}else {
			parent[bP] = aP;
		}
		
	}
	
	static boolean isSame(int a, int b) {
		int aP = find(a);
		int bP = find(b);
		
		if(aP==bP)
			return true;
		return false;
	}
}
