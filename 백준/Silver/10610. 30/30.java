import java.util.*;
import java.io.*;
import java.math.BigInteger;


/*
 * 일단 30의 배수는 0으로 끝나야함! 
 * 분기 1. 0이없으면 the end ...
 * 분기 2, 3의 배수는 모든 자리 수의 합이 3의 배수여야 함! 
 * 
 * 만약 위 조건을 모두 통과했으면
 * => 제일 큰 수 부터 맨 앞에 넣어주면 됨 
 * 
 * */
public class Main {
	
	static boolean haveZero = false;
	static int sum = 0;
	static Integer [] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		arr = new Integer [str.length()];
		int len = str.length();
		
		for(int i=0; i<len; i++) {
			int num = str.charAt(i) - '0';
			sum += num;
			if(num == 0)
				haveZero = true;
			arr[i] = num;
		}
		//입력 
		
		Arrays.sort(arr, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
			
		}) ;
		
		int answer = 0;
		if(!haveZero || sum%3 !=0) {
			answer  = -1;
			System.out.println(answer);
		}
		else {
			for(int i=0; i<arr.length; i++) {
				sb.append(arr[i]);
			}
			System.out.println(sb);
		}

	}

}
