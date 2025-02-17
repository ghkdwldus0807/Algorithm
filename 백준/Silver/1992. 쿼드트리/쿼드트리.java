
import java.util.*;
import java.io.*;

/*
 * [1][2]
 * [3][4]
 * 
 * 조건 1) 2*2 크기 까지 탐색 
 * 1-1) 만약 그래도 합칠 수 없다면 1-2-3-4 순으로 출력 
 * 
 * 
 * 1. 압축이 가능한지 안 가능한지 판단하는 함수 
 * 2. 재귀함수 만들기 (size = 2 까지) 
 * 
 * */

public class Main {
	

	static int[][] video;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		video = new int [n][n];
		
		for(int i=0; i<n; i++) {
			String [] sArr = br.readLine().split("");
			for(int j=0; j<n; j++) {
				video[i][j] = Integer.parseInt(sArr[j]);
			}
		}
		
		
		search(0,0,n);
		
		System.out.println(sb);
		
		
	}//main
	
	
	static void search(int i, int j, int size) {
		if(size < 1) {
			sb.append(")");
			return;
		}
		
		
		if(isZip(i,j,size)) {
			if(video[i][j]==0) {
				sb.append("0");
			}
			else {
				sb.append("1");
			}
		}else {
			sb.append("(");
			search(i,j,size/2);
			search(i,j+size/2,size/2);
			search(i+size/2,j,size/2);
			search(i+size/2,j+size/2,size/2);
			sb.append(")");
		}
		
		
	}
	
	
	static boolean isZip(int i, int j, int size) {
		int color = video[i][j];
		
		for(int y=i; y<i+size; y++) {
			for(int x=j; x<j+size; x++) {
				if(video[y][x]!=color)
					return false;
			}
		}
		return true;
		
	}//isZip (압축 가능 여부)
	


}
