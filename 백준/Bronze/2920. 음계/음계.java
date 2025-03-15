import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] as = {1,2,3,4,5,6,7,8};
	static int[] de = {8,7,6,5,4,3,2,1};
	static int[] input = new int[8];
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<8; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		if(Arrays.equals(input, as))
			System.out.println("ascending");
		else if(Arrays.equals(input, de))
			System.out.println("descending");
		else 
			System.out.println("mixed");

	}

}
