import java.util.*;
import java.io.*;

public class Main {

	//pseudo code 
	//1. 1~6번 연산을 하는 함수를 만든다.
	//2. 적용한다. 
	
	static int n, m, r;
	static int [][] arr;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//operations 수행
		st = new StringTokenizer(br.readLine());
		int [][] results = arr;
		for(int i=0; i<r; i++) {
			int operNum = Integer.parseInt(st.nextToken());
			
			if(operNum==1)
				results=oper1(results);
			else if(operNum==2)
				results=oper2(results);
			else if(operNum==3)
				results = oper3(results);
			else if(operNum==4)
				results = oper4(results);
			else if(operNum==5)
				results = oper5(results);
			else if(operNum==6)
				results = oper6(results);
			
		}
		
		//배열 출력
		for(int i=0; i<results.length; i++) {
			for(int j=0; j<results[0].length; j++) {
				System.out.print(results[i][j]+" ");
			}
			System.out.println();
		}
		
	}//main
	
	static int[][] oper1(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		int [][] results = new int [n][m];
		for(int i = 0 ; i<n/2; i++) {
			results[i] = arr[n-i-1] ;
			results[n-i-1] = arr[i];
		}
		return results;
	}//oper1
	
	static int[][] oper2(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		int [][] results = new int [n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m/2; j++) {
				results[i][j] = arr[i][m-j-1];
				results[i][m-j-1] = arr[i][j];
			}
		}
		return results;
	}//oper2

	
	static int[][] oper3(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		int [][] results = new int [m][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				results[j][n-i-1]=arr[i][j];
			}
		}
		
		return results;
	} //oper3
	
	static int[][] oper4(int[][] arr){
		int n = arr.length;
		int m = arr[0].length;
		int [][] results = new int[m][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				results[m-j-1][i] = arr[i][j];
			}
		}
		return results;
	}//oper4
	
	static int[][] oper5(int[][] arr){
		int n = arr.length;
		int m = arr[0].length;
		int [][]results = new int [n][m];
		
		for(int i=0; i<n/2; i++) {
			for(int j=0; j<m/2; j++) 
				results[i][j+m/2] = arr[i][j]; 
		}
		
		for(int i=0; i<n/2; i++) {
			for(int j=m/2; j<m; j++) 
				results[i+n/2][j] = arr[i][j]; 
		}
		
		for(int i=n/2; i<n; i++) {
			for(int j=m/2; j<m; j++) 
				results[i][j-m/2] = arr[i][j]; 
		}
		
		for(int i=n/2; i<n; i++) {
			for(int j=0; j<m/2; j++) 
				results[i-n/2][j] = arr[i][j]; 
		}
		
		return results;
	}//oper5
	
	static int[][] oper6(int[][] arr){
		int n = arr.length;
		int m = arr[0].length;
		int [][]results = new int [n][m];
		
		for(int i=0; i<n/2; i++) {
			for(int j=0; j<m/2; j++) 
				results[i+n/2][j] = arr[i][j]; 
		}
		
		for(int i=0; i<n/2; i++) {
			for(int j=m/2; j<m; j++) 
				results[i][j-m/2] = arr[i][j]; 
		}
		
		for(int i=n/2; i<n; i++) {
			for(int j=m/2; j<m; j++) 
				results[i-n/2][j] = arr[i][j]; 
		}
		
		for(int i=n/2; i<n; i++) {
			for(int j=0; j<m/2; j++) 
				results[i][j+m/2] = arr[i][j]; 
		}
		
		return results;
	}//oper6
}
