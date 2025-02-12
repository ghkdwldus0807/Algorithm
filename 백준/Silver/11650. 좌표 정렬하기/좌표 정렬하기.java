import java.io.*;
import java.util.*;


public class Main {

	
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int [][] dots = new int[n][2];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dots[i][0] = Integer.parseInt(st.nextToken());
			dots[i][1] = Integer.parseInt(st.nextToken());
		}

		
		Arrays.sort(dots,new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				
				if(o1[0]!=o2[0])
					return o1[0] - o2[0];
				else
					return o1[1] - o2[1];
			}
			
		});

		
		for(int i=0; i<n; i++) {
			sb.append(dots[i][0]);
			sb.append(" ");
			sb.append(dots[i][1]);
			sb.append("\n");
		}
		
		System.out.println(sb);

		
	}

}
