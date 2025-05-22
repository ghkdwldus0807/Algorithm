import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			long command = Long.parseLong(br.readLine());
			if(command == 0) {
				if(pq.isEmpty()) {
					sb.append(0).append("\n");
				}
				else {
					sb.append(pq.poll()).append("\n");
				}
			}
			else {
				pq.add(command);
			}
		}
		
		System.out.println(sb);
		
	}

}
