import java.util.*;
import java.io.*;
import java.math.*;

/*
 * 1. start / end pointer가 있음 
 * 2. dev[start] > dev[end] 이면 end --; 아니면 start ++;
 * 3. start>end 까지 반복
 * 
 * */


public class Main {
	
	static int start, end, max, N; 
	static int[] dev;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		dev = new int[N];
		start = 0;
		end = N-1;
		max = Integer.MIN_VALUE;
		
		for(int i=0; i<N; i++) {
			dev[i] = Integer.parseInt(st.nextToken());
		}//입력
		
		for(int i=0; i<N; i++) {
			
			max = Math.max((end-start-1)*Math.min(dev[start], dev[end]), max);
			
			if(dev[start]>= dev[end])
				end--;
			else
				start ++; 
			
			if(start>end)
				break;
			
		}
		
		System.out.println(max);
	}

}
