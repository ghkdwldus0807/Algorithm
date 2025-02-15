import java.io.*;
import java.util.*;
import java.math.*;

/*
 * 가장 긴 바이토닉 부분 수열 = 가장 긴 증가하는 수열 + 가장 긴 짧아지는 수열 
 * 
 * dpI = 1부터 i까지 수까지 주어졌을 때, 가장 긴 증가하는 수열의 길이 
 * dpD = i부터 n까지의 수까지 주어졌을 때, 가장 긴 짧아지는 수열의 길이 
 * 
 * answer = dpI+ dpD -1;
 * */

public class Main {
	
	static int [] dpI;
	static int [] dpD; 
	static int [] arr; 
	static int minValue = Integer.MAX_VALUE;
	static int maxValue = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		dpI = new int[n+1];
		dpD = new int[n+1];
		arr = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i =1; i<=n; i++) {
			if(arr[i]<minValue) {
				minValue = arr[i];
				dpI[i] = 1;
				continue;
			}
			
			for(int j=1; j<=i; j++) {
				if(arr[j]<arr[i]) {
					dpI[i] = Math.max(dpI[i], dpI[j]+1);
				}
			}
			
		}//dp Increase
		
		//감소하는 dp는 자기 자신부터 시작해야함 
		
		for(int i=n; i>=1; i--) {
			dpD[i] = 1;
			for(int j = n; j>i; j--) {
				if(arr[j] < arr[i]) {
					dpD[i] = Math.max(dpD[i], dpD[j]+1);
				}
			}
		}
		
		int answer = 0;
		

		for(int i=1; i<=n; i++) {
			answer = Math.max(answer, dpI[i]+dpD[i]-1);
		}
		

		System.out.println(answer);
		

	}

}
