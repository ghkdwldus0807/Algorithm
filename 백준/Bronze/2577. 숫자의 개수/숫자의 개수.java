import java.io.*;

public class Main {
	
	static int A,B,C;
	static long  mul;
	static int[] numCount =  new int[10];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		A = Integer.parseInt(br.readLine());
		B = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());
		
		mul = A*B*C;
		
		String num = String.valueOf(mul);
		
		for(int i=0; i<num.length(); i++) {
			
			char c = num.charAt(i);
			
			if(c == '0')
				numCount[0] +=1; 
			else if(c == '1')
				numCount[1] +=1; 
			else if(c == '2')
				numCount[2] +=1; 
			else if(c == '3')
				numCount[3] +=1; 
			else if(c == '4')
				numCount[4] +=1; 
			else if(c == '5')
				numCount[5] +=1; 
			else if(c == '6')
				numCount[6] +=1; 
			else if(c == '7')
				numCount[7] +=1; 
			else if(c == '8')
				numCount[8] +=1; 
			else if(c == '9')
				numCount[9] +=1; 
			
		}
		
		for(int count : numCount)
			System.out.println(count);
		
		
	}

}
