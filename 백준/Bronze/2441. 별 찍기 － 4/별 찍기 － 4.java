
import java.util.*;
import java.io.*;

public class Main  {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		String str = "*";
		String blank = " ";
		
		for(int i=0; i<num; i++) {
			System.out.print(blank.repeat(i));
			System.out.println(str.repeat(num-i));
		}
		
	}//main method

}
