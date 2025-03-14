
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		int a = 0; 
		int b = 0;
		int c = 0;
		
		String A = "";
		String B = "";
		String C = "";
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		A = br.readLine(); a = Integer.parseInt(A);
		B = br.readLine(); b = Integer.parseInt(B);
		C = br.readLine(); c = Integer.parseInt(C);
		
		System.out.println(a+b-c);
		System.out.println(Integer.parseInt(A+B)-c);

	}

}

