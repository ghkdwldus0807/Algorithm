import java.io.*;
import java.util.*;

public class Main {

	
	static LinkedList<String> pw ; 
	static ListIterator<String> iter;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		for(int i=0; i<num; i++) {
			
			pw = new LinkedList<>();
			iter = pw.listIterator();
			StringBuilder sb = new StringBuilder();
			
			String [] input = br.readLine().split("");
			
			for(int k=0; k<input.length; k++) {
				
				if(input[k].equals("<")){
					if(iter.hasPrevious()) {
						iter.previous();
					}
					continue;
				}
				else if(input[k].equals(">")) {
					if(iter.hasNext()) {
						iter.next();
					}
					continue;
				}
				else if(input[k].equals("-")) {
					if(iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
					
				}else {
					iter.add(input[k]);
				}
				
			}
			
			for(String str : pw) {
				sb.append(str);
			}
			
			System.out.println(sb);
			
		}
		

	}//main 
	
	

}
