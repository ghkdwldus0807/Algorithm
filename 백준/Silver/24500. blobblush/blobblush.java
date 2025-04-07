import java.io.*;
import java.util.*;

public class Main {
	

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		
		//N의 비트 개수 구하기 
		long bitCount = Long.toBinaryString(N).length();
		
		//bitCount개의 최대 카드 만들기 
		long card = (1L<<bitCount)-1;

		
		if(card<=N) {
			System.out.println(1);
			System.out.println(card);
			return;
		}
		else {
			System.out.println(2);
			System.out.println(card-N);
			System.out.println(N);
				
		}
		
	}

}
