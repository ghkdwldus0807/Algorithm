import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [] nums = new int[N+1];
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int [] ps = new int [N+1]; //처음부터 nums[i]까지의 누적합
		ps[0] = 0;
		
		for(int i=1; i<=N; i++) {
			ps[i] = ps[i-1] + nums[i];
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(String.valueOf(ps[b]-ps[a-1])).append("\n");
		}
		
		System.out.println(sb);

	}

}
