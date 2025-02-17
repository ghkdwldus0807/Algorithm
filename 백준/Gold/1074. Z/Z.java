
import java.util.*;
import java.io.*;
import java.math.*;

/*
 * 
 * [1][2]
 * [3][4]
 * 
 * 1사분면에 있으려면 : i<size/2; j<size/2;
 * 2사분면 : i<size/2; j>=size/2;
 * 3사분면 : i>=size/2; j<size/2;
 * 4사분면 : i>=size/2; j>=size/2;
 * 
 * 재귀호출할 때에는 r,c의 상대적인 위치를 넣어줘야함 
 * 
 * */
public class Main {
	
	static int count; 
	static int N,r,c;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int size = (int) Math.pow(2, N);

		searchZ(r,c,size);
		
		System.out.println(count);
		
		
	}//main
	
	
	public static void searchZ(int i, int j, int size) {

		if(size == 1)
			return;
		
		if(i<size/2 && j<size/2) {
			searchZ(i,j,size/2);
		}
		else if(i<size/2 && j>=size/2) {
			count += size*size/4;
			searchZ(i,j-size/2,size/2);
		}
		else if(i>=size/2 && j<size/2) {
			count += (size*size/4)*2;
			searchZ(i-size/2,j,size/2);
		}else if(i>=size/2&& j>=size/2) {
			count += (size*size/4)*3;
			searchZ(i-size/2,j-size/2,size/2);
		}

	}//search

}
