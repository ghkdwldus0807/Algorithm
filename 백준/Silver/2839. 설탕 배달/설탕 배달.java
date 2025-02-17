import java.util.*;
import java.io.*;

/*
 * 5는 3의 배수가 아니기 때문에 대체 할 수 없음. 모두 고려 해야함 
 * 
 * */

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int sugar = Integer.parseInt(br.readLine());
		int [] units = {3,5};
		
		int answer = 0 ;
		
		while(true) {
			
			if(sugar%5==0) {
				answer+= sugar/5;
				sugar /= 5;
				break;
			}
			
			sugar-=3;
			answer++;

			
			if(sugar<0) {
				answer = -1;
				break;
			}
		}
		
		System.out.println(answer);
	}

}
