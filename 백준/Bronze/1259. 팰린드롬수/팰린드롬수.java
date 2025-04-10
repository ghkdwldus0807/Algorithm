import java.io.*;
import java.util.*;

public class Main {
	
	static String str;
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			str = br.readLine();
			N = Integer.parseInt(str);
			StringBuilder reversed = new StringBuilder();
			
			if(N == 0)
				break;
			
			reversed.append(str);
			reversed.reverse();
			
			if(str.equals(reversed.toString())){
				sb.append("yes").append("\n");
			}
			else {
				sb.append("no").append("\n");
			}
			
		}
		
		System.out.println(sb);
		
	}//main;
	
}
