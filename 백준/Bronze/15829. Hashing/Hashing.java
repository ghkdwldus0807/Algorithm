import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

	static BigInteger num = BigInteger.valueOf(0); 
	static int L;
	static final BigInteger mod = BigInteger.valueOf(1234567891);
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L = Integer.parseInt(br.readLine());
		String str = br.readLine();
	
		
		for(int i=0; i<str.length(); i++) {
			num = num.add(BigInteger.valueOf((int)(str.charAt(i)-'a')+1).multiply(BigInteger.valueOf(31).pow(i)));
		}
		System.out.println(num.mod(mod));
		
		
	}//main

}
