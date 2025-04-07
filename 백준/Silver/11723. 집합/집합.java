import java.io.*;
import java.util.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		int M, S = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			if(command.equals("add")) {
				int x = Integer.parseInt(st.nextToken());
				S = add(S,x);
			}
			else if(command.equals("remove")) {
				int x = Integer.parseInt(st.nextToken());
				S = remove(S,x);
			}
			else if(command.equals("check")) {
				int x = Integer.parseInt(st.nextToken());
				if(check(S,x)){
					sb.append(1+"\n");
				}
				else 
					sb.append(0+"\n");
			}
			else if(command.equals("toggle")) {
				int x = Integer.parseInt(st.nextToken());
				if(check(S, x)) {
					S = remove(S, x);
				}
				else
					S = add(S,x);
			}
			else if(command.equals("all")) {
				S = all(S);
			}
			else {
				S = 0;
			}
		}
		
		System.out.println(sb);

	}//main;
	
	static int add(int S, int x) {
		return S |(1<<(x-1));
	}
	
	static int remove(int S, int x) {
		return S &~(1<<(x-1));
	}
	
	static boolean check (int S, int x) {
		
		if((S & 1<<(x-1)) == 0) {
			return false;
		}
		
		return true;
	}
	
	static int all (int S) {
		return (1<<20)-1;
	}
}
