import java.util.*;
import java.io.*;

public class Main {
	
	static int N,M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	//이분 탐색 lower bound, upperbound => 수의 인덱스 범위 찾기 
	// 만약 lower bound == upper bound 이라면 해당 원소는 존재하지 않는다.

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i< N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			
			//lower bound (인덱스 시작 지점)
			int lowerIdx = lowerBound(arr, target);
			
			//upper bound -1  (인덱스 끝 지점)
			int upperIdx = upperBound(arr, target);
			
			if(lowerIdx == upperIdx)
				sb.append(0).append(" ");
			else
				sb.append(upperIdx-lowerIdx).append(" ");
			
		}
		
		System.out.println(sb);
		
		
	}//main 
	
	//lower bound 
	static int lowerBound(int[] arr, int target) {
		int left = 0;
		int right = arr.length;
		
		while(left<right) {
			
			int mid = left + (right-left) / 2; 
			
			if(arr[mid]<target)
				left = mid + 1;
			else
				right = mid;
			
		}
		
		return right;
	}//lower bound 
	
	static int upperBound(int[] arr, int target) {
		int left = 0 ;
		int right = arr.length;
		
		while(left < right) {
			int mid = left + (right-left) / 2;
			
			if(arr[mid]<=target)
				left = mid+1;
			else
				right = mid;
			
		}
		
		return right;
	}
	

}
