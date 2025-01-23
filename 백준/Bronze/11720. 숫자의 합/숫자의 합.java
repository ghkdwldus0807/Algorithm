import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		int sum = 0;
		
		String [] arr = br.readLine().split("");
		
		
		for(int i=0; i<num; i++) {
			sum += Integer.parseInt(arr[i]);

		}
		
		System.out.println(sum);

	}

}
