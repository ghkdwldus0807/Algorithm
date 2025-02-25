import java.util.*;
import java.io.*;


public class Main {
	
	static int testNum, N, M;
	static int [] aArr, bArr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testNum = Integer.parseInt(br.readLine());
		
		for(int i=0; i<testNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			aArr = new int[N];
			bArr = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int n=0; n<N; n++) {
				aArr[n] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int n=0; n<M; n++) {
				bArr[n] = Integer.parseInt(st.nextToken());
			}
			
			int total = 0;
			
			Arrays.sort(aArr);
			Arrays.sort(bArr);
			
			for(int n=0; n<N; n++) {
				for (int m=0; m<M; m++) {
					if(aArr[n]>bArr[m])
						total++;
					else
						break;
				}
			}
			
			sb.append(total).append("\n");
			
			
		}//for - testNum
		
		System.out.println(sb);
		
	}

}
