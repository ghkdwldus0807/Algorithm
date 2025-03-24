import java.util.*;
import java.io.*;

public class Main {

	static int start, end; 
	static int [] dist = new int [100001];

	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		bfs(start,end);
		
		System.out.println(dist[end]);
		
	}//main 
	
	//0-1 bfs
	static void bfs(int start, int end) {
		
		Deque<Integer> dq = new ArrayDeque<>();
		
		dist[start] = 0;
		dq.add(start);
		
		while(!dq.isEmpty()) {
			
			int current = dq.poll();
			
			if(current == end)
				return;
			
			if(current*2 <= 100000 && dist[current*2] > dist[current]) {
				dist[current*2] = dist[current];
				dq.addFirst(current*2);
			}
			
			if(current+1 <= 100000 && dist[current+1] > dist[current]+1) {
				dist[current+1] = dist[current]+1;
				dq.addLast(current+1);
				
			}
			
			
			if(current-1 > -1 && dist[current-1] > dist[current]+1) {
				dist[current-1] = dist[current] + 1;
				dq.addLast(current-1);
				
			}
			

		}
		
	}//bfs
	
	
}
