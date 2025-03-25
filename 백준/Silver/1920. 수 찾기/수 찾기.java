import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0 ; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		Arrays.sort(arr);
		
		for(int i=0; i<M; i++) {
			
			int target = Integer.parseInt(st.nextToken());
			
			if(isExisted(arr, target))
				sb.append(1).append("\n");
			else
				sb.append(0).append("\n");
		}
		
		System.out.println(sb);

		
	}//main 
	
	
	//binary search
	static boolean isExisted(int[] arr, int target) {
		
		int start = 0;
		int end = arr.length - 1; 
		
		while(start<=end) {
			int mid = (start+end)/2;
			
			if(arr[mid] == target)
				return true;
			
			if(arr[mid]<target) {
				start = mid+1;
			}
			else {
				end = mid - 1; 
			}
			
		}
		
		return false;
		
		
	}
	

}
