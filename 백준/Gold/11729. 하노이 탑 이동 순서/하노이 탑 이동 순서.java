
import java.io.*;


//pseudo code 

/*
 * 1. 원판의 개수 num을 입력받는다. 
 * 2. 맨 아래 원판을 제외한 나머지 원판은 중간 장대에 탑 처럼 쌓아놓아야한다.
 * 	 	예) 5개 원판을 옮겨야하는 경우 4개의 원판을 (4-3-2-1) 순서로 두 번째 장대에 옮겨야함 
 * 3. n-1개 원판을 중간에 옮긴 후 원판 n을 3번째 장대에 옮긴 후 비어있는 장대로 n-2개 원판을 옮김 .. 반복  */



public class Main {
	
	
	static StringBuilder sb= new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		//하노이 탑을 옮기는 횟수는 항상 2^num - 1 이다. 
		System.out.println((int)Math.pow(2, num)-1);
		
		move(1,3,num);
		
		System.out.println(sb);
		
	}
	
	static void move(int start, int end, int num) {
		
		
		if(num>1)
			move(start,6-start-end,num-1);
		
		sb.append(start);
		sb.append(" ");
		sb.append(end);
		sb.append("\n");
		
		
		if(num>1)
			move(6-start-end,end,num-1);
		
		
	}

}
