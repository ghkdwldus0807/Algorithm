
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		
		int [] arr = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		int sum = day;
		
		for(int i=0; i<month-1; i++) {
			sum += arr[i];
		}
		
		String date = "";
		
		switch(sum%7) {
		case 1 :
			date = "MON";
			break;
		case 2 :
			date = "TUE";
			break;
		case 3 :
			date = "WED";
			break;
		case 4 :
			date = "THU";
			break;
		case 5 :
			date = "FRI";
			break;
		case 6 :
			date = "SAT";
			break;
		case 0 :
			date = "SUN";
			break;
		}
		System.out.println(date);
		
		
	}
}
