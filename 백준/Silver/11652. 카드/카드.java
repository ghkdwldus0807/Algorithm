import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static HashMap<Long, Integer> dict = new HashMap<>();
	static long maxNum = -1;
	static int maxCount = -1;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			long num = Long.parseLong(br.readLine());
			
			dict.put(num, dict.getOrDefault(num, 0)+1);
		}
		
		for(Long key : dict.keySet()) {
			int value = dict.get(key);
			if(value>maxCount || (value==maxCount && key<maxNum)) {
				maxNum = key;
				maxCount = value;
			}
		}
		
		System.out.println(maxNum);
		
		
	}

}
