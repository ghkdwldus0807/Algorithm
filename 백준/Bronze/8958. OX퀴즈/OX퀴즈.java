import java.io.*;

public class Main {
	
	static int T;
	static char[] ans;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int score = 0 ;
			
			String answer = br.readLine();
			ans = answer.toCharArray();
			int count = 0;
			
			for(int i=0; i<ans.length; i++) {
				if(ans[i] == 'O') {
					count++;
					score += count;	
				}
				else if(ans[i] == 'X') {
					count = 0;
				}
				
			}
			
			System.out.println(score);
			
			
		}//test case 

	}

}
