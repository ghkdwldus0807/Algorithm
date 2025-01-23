import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] arr = br.readLine().split("");
		
		for(int i=0; i<arr.length; i++) {
			
			if(i!=0 && i%10==0) {
				System.out.println();
				System.out.print(arr[i]);
			}else {
				System.out.print(arr[i]);
			}

		}
	}
}