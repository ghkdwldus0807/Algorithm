import java.io.*;
import java.util.*;

public class Main {
	
	static Queue<Integer> pointers = new ArrayDeque<>(); //라이언 인형의 인덱스(포인터) 
	static int[] dolls; 
	static int N,K;
	static int min = Integer.MAX_VALUE;
	static int start = -1;
	
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dolls = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int doll = Integer.parseInt(st.nextToken());
			dolls[i] = doll;

		}//입력
		
		int count = 0; //집합에 들어있는 인형 개수 
		
		for(int end = 0 ; end<N; end++) {
			
			if(start == -1 && dolls[end] == 1) {
				start = end;
				count++;
			}
			
			
			else if(dolls[end] == 1) {
				count ++;
				pointers.add(end);
			}
			
			if(count == K) {
				min = Math.min(end-start+1, min);
				start = pointers.poll();
				count -= 1;
			}
			
			
		}

		if(min == Integer.MAX_VALUE)
			System.out.println(-1);
		else 
			System.out.println(min);
		

		
		
	}

}
