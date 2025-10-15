import java.util.*;
import java.io.*;

public class Main {
	
	static int [][] student;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		student = new int[N][M];
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int w = Integer.parseInt(st.nextToken());
				student[i][j] = w;
			}
		}
		
		for(int i=0; i<N; i++) {
			Arrays.sort(student[i]);
		}
		
		int [] index = new int[N];
		int min = Integer.MAX_VALUE;
		
		
		while(true) {
			
			int[] temp = getMinClass(index,N);
			if((temp[2]-temp[1]) < min){
				min = temp[2]-temp[1];
			}
			
			if((index[temp[0]]+1) == M) {
				break;
			}
			
			index[temp[0]] += 1 ;
			
		}

		System.out.println(min);

	}//main
	
	
	//가장 최소 값의 학급 번호 
	static public int[] getMinClass (int [] index, int N) {
		
		int minIdx = 0;
		int minValue = Integer.MAX_VALUE;
		
		int maxValue = Integer.MIN_VALUE;
		
		for(int i=0; i<index.length; i++) {
			
			if(minValue>student[i][index[i]]) {
				minValue = student[i][index[i]];
				minIdx = i;
			}
			
			if(maxValue<student[i][index[i]]) {
				maxValue = student[i][index[i]];
			}

		}
		
		return new int[] {minIdx,minValue,maxValue};
	}

}
