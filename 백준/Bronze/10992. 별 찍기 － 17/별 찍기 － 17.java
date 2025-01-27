import java.util.*;
import java.io.*;

public class Main  {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		String str = "*";
		String blank = " ";
		
		
		for(int i=1; i<=num; i++) {
			
			if(i==1) {
				System.out.print(blank.repeat(num-1));
				System.out.println(str);
			}
			else if(i==num) {
				System.out.println(str.repeat(2*num-1));
			}
			else {
				System.out.print(blank.repeat(num-i));
				System.out.print(str);
				System.out.print(blank.repeat(2*(i-1)-1));
				System.out.println(str);
			}
		}

	}//main method
}
