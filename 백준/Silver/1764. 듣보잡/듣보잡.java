import java.util.*;
import java.io.*;

public class Main {
	
	static int N,M;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		HashMap<String,Integer> map = new HashMap<>();
		ArrayList<String> names = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N+M; i++) {
			String name = br.readLine();
			map.put(name, map.getOrDefault(name,0)+1);
		}
		
		for(String key : map.keySet()) {
			if(map.get(key) == 2) {
				names.add(key);
			}
		}
		
		Collections.sort(names);
		
		sb.append(names.size()).append("\n");
		
		for(String name : names) {
			sb.append(name).append("\n");
		}
		
		System.out.println(sb);

	}

}
