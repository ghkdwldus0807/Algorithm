import java.io.*;

public class Main {

	static int N,cnt;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		int series = 666;
		
		while(true) {
			String str = String.valueOf(series);
			if(str.contains("666")) {
				cnt++;
			}
			
			if(cnt == N) {
				System.out.println(series);
				return;
			}
			
			series++;
			
		}
		
	}//main

}
