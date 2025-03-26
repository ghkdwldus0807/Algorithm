import java.util.*;
import java.io.*;

public class Main {
	
	static int N,M,sum;
	static int [] videos ;
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		videos = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int len = 0;
		int left = -1;
		for(int i=0; i<N; i++) {
			len = Integer.parseInt(st.nextToken());
			videos[i] = len;
			sum += len;
			left = Math.max(len,left);
		}//input
		
		int right = sum;
		
		//매개변수 탐색 
		
		System.out.println(binarySearch(left, right, M));
		

	}//main 
	
	
	
	//매개변수 탐색 메서드 
	static int binarySearch(int left, int right, int target) {
		
		while(left<=right) {
			
			int mid = (left+right)/2;
			
			if(getCount(mid) > target)
				left = mid + 1;
			else
				right = mid -1 ;

		}
		
		return left;
	}
	
	
	//블루레이 크기가 x인 경우, 블루레이의 개수를 구하는 메서드 
	static int getCount(int x) {
		
		int count = 1;
		int sum = 0;
		int videoLen = x; 
		
		for(int i=0; i<N; i++) {
			
			if(sum+videos[i] > videoLen) {
				sum = videos[i];
				count ++;  
			}
			else {
				sum += videos[i];
			}
		}

		return count;
	}//getCount
	
	

}
