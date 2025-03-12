import java.util.*;
import java.io.*;

public class Main {
	
	// 1. 문제에 나온대로 사이클을 돌린다. 
	// 2. 입력과 똑같은 출력이 나올떄 까지 돌린다. 그리고 주기를 찾는다. 
	// 3. X % 주기 인게 ???? 하여튼 정답
	
	static int X;
	static LinkedList<Character> word = new LinkedList<>();
	static int cnt, length; //옮겨야하는 횟수, 단어의 길이
	static StringBuilder sb = new StringBuilder();
	static ArrayList<String> results = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		X = Integer.parseInt(br.readLine());
		String str = br.readLine(); //입력단어 
		cnt = str.length()/2;
		length = str.length();
		
		for(int i=0; i<length; i++) {
			word.add(str.charAt(i));
		} // input 
		
		
		int k = 0 ; //주기 
		
		while(true) {
			
			setForward();
			String result = getString();
			sb.setLength(0);
			results.add(result);
//			System.out.println(result);
			
			if(result.equals(str)) {
				k = results.size();
				break;
			}
			
		}
		
//		System.out.println(k);
		int index = 0;
		
		if(X%k != 0)
			index = X%k - 1;

		System.out.println(results.get(index));

	} //main 

	//다시 단어를 되돌리는 메서드
	static void setForward() {
		
		for(int i=0; i<cnt; i++) {
			
			char forward = word.remove(i+1);
			word.add(length-(i+1), forward);
		}

	}//setForward
	
	
	//LinkedList를 String으로 만드는 메서드 
	static String getString() {
		
		for(int i=0; i<length; i++) {
			sb.append(word.get(i));
		}
		
		return sb.toString();
	}
	 
}
