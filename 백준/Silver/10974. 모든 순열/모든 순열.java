
import java.io.*;

public class Main {

	static int [] arr;
	static boolean [] visited;
	static StringBuilder sb;
	static int num;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		num = Integer.parseInt(br.readLine());
		
		arr = new int[num];
		visited = new boolean [num+1];
		
		dfs(0);
		
		System.out.println(sb);

		
		
	}
	
	static void dfs(int index) {
		
		if(index==num) {
			for(int n : arr) {
				sb.append(n + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=num; i++) {
			if(!visited[i]) {
				arr[index] = i;
				visited[i] = true;
				dfs(index+1);
				visited[i] = false;
			}
		}

		
	}
	


}
