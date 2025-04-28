import java.util.*;
import java.io.*;

public class Main {
	
	static int N;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		int [] count = new int[8001]; // 
		double sum = 0;
		int max = -9000;
		int min = 9000;
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
			count[num+4000] ++;
			sum += num;
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		
		sb.append(Math.round(sum/N)).append("\n");
		Arrays.sort(arr);
		sb.append(arr[N/2]).append("\n");
		
		int maxCnt = -1;
		int dupMax = 0;
		for(int cnt : count) {
			maxCnt = Math.max(cnt, maxCnt);
		}
		int idxCnt = 0;
		int idx = 0;
		
		
		if(N==1) {
			sb.append(arr[0]).append("\n");
		}
		else {
			for(int i=0; i<8001; i++) {
				if(count[i] == maxCnt) {
					if(idxCnt  == 1) {
						idx = i - 4000;
						idxCnt++;
						break;
					}
					idxCnt++;
					idx = i - 4000;
				}
			}
			
			sb.append(idx).append("\n");
		}
		
		sb.append(max-min);
		
		System.out.println(sb);

	}

}
