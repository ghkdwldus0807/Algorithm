import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static ArrayList<int []> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.add(new int[] {x,y});
			
		}
		
		Collections.sort(list, new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])
					return o1[0] - o2[0];
				
				return o1[1]-o2[1];
			}
			
		});
		
		
		for(int i=0; i<N; i++) {
			
			int[] dot = list.get(i);
			
			sb.append(dot[0]).append(" ").append(dot[1]).append("\n");
			
		}
		
		System.out.println(sb);
		
	}

}
