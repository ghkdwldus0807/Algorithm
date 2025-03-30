import java.util.*;
import java.io.*;

public class Solution {
	
	static int T, n, p;
	static int [] days;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			days = new int[n];
			for(int i=0; i<n; i++) {
				days[i] = Integer.parseInt(st.nextToken());
			}
			//input 
			
			int answer = 0;
			
			for(int i=0; i<n; i++) {
				int left = i;
				int right = n-1;
				
				while(left<=right) {
					
					int mid = left + (right-left)/2;
					int continousDays = days[mid] - days[i] + 1; //연속으로 공부한 날짜 
					int realStudyDays = mid - i + 1; //실제로 공부한 날짜
					int needDays = continousDays - realStudyDays; //추가로 체크해야하는 날짜 
					
					if(needDays<=p) {
						left = mid + 1; //left가 커져야 mid값이 커지기 때문에  
					}
					else {
						right = mid - 1;
					}
					
				}
				
				answer = Math.max(answer, left-i+p);
				
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");

			
		}//TestCase 
		
		System.out.println(sb);

	}//main
	

	

}
