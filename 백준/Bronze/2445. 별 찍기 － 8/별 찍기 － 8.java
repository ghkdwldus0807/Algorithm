
import java.util.*;
import java.io.*;

public class Main  {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		String str = "*";
		String blank = " ";
		
		for(int i=1; i<=num; i++) {
			System.out.print(str.repeat(i));
			System.out.print(blank.repeat(2*(num-i)));
			System.out.println(str.repeat(i));
		}
		
		for(int i=1; i<num; i++) {
			System.out.print(str.repeat(num-i));
			System.out.print(blank.repeat(2*i));
			System.out.println(str.repeat(num-i));
			
		}
		
	}//main method

}
