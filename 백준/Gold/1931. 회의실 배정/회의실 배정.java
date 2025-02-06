import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	//pseudo code 
	//1. 종료 시간이 빠른 회의를 기준으로 정렬
	//1-1. 만약 종료시간이 같을 경우, 시작 시간이 빠른회의 순으로 정렬 
	//2. 반복문을 돌며 종료시간이 시작 시간과 같거나 빠르면 count +1 

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int meetingNum = Integer.parseInt(br.readLine());
		int [][] meetings = new int [meetingNum][2];
		
		for(int i=0; i<meetingNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meetings[i][0] = Integer.parseInt(st.nextToken());
			meetings[i][1] = Integer.parseInt(st.nextToken());	
		}
		
		Arrays.sort(meetings, new Comparator<int []>() {
			//1. 종료 시간이 빠른 회의를 기준으로 정렬
			@Override
			public int compare(int[] o1, int[] o2) {
				//1-1. 만약 종료시간이 같을 경우, 시작 시간이 빠른회의 순으로 정렬 
				if(o1[1]==o2[1])
					return o1[0]-o2[0];
				
				return o1[1]-o2[1];
			}
		});
	
		int end_time = 0;
		int count = 0;
		
		for(int i=0; i<meetingNum; i++) {
			if(end_time<=meetings[i][0]) {
				end_time = meetings[i][1];
				count++;
			}
		}
		
		System.out.println(count);
		
	}//main
	
}
