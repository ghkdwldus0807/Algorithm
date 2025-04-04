import java.io.*;
import java.util.*;

public class Main {

	
	static int T,N,len, answer; //len : 수열 길이 / answer : 수열
	static StringBuilder sb = new StringBuilder();
	static HashSet<Integer> XORsubset = new HashSet<>(); //XOR 했을 떄 0이 되는 3개의 수를 저장하는 set

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		

		for(int t=1; t<=T; t++) {
			
			N = Integer.parseInt(br.readLine());
			XORsubset.clear();
			len = 0;
			answer = 0;
			
			if(N==1) {
				sb.append(1+"\n"+1+"\n");
			}
			else { 
				genXOR(N);
				
				//모든 조합 탐색 
				for(int i = 1; i<(1<<N); i++) {
					if(len>= Integer.bitCount(i))
						continue;
					
					if(isEnabled(i)) {
						continue;
					}
					else {
						answer = i;
						len = Math.max(len, Integer.bitCount(answer));
					}
				}
				
				sb.append(len).append("\n");
				
				//다시 10진수로 변환해서 출력 
				for(int i=0 ; i<N; i++) {
					if((answer & (1<<i)) != 0){
						sb.append(i+1).append(" ");
					}
				}
				sb.append("\n");
				
			}//if - else
			
			
		}//testcase
		
		System.out.println(sb);

	}//main
	
	//조합 중 3개를 뽑아서 XORsubset에 포함되는지 확인 하는 메소드 
	static boolean isEnabled(int subset) {
		
		ArrayList<Integer> index = new ArrayList<>(); //1인 인덱스를 저장하는 배열
		
		for(int i=0; i<N; i++) {
			if((subset & (1<<i)) !=0) {
				index.add(i);
			}
		}
		
		int size = index.size();
		
		//index 배열에 저장된 수 중에 3개를 뽑아서 XORsubset과 비교 
		for(int i=0; i<size; i++) {
			for(int j=i+1; j<size; j++) {
				for(int k=j+1; k<size; k++) {
					
					int set = (1<<index.get(i)) | (1<<index.get(j)) | (1<<index.get(k));
					
					if(XORsubset.contains(set)) {
						return true;
					}
				}
			}
		}
		return false;
	}//isEnabled
	
	// 1~N 중에 3개를 뽑아서 XOR한 결과 0이 되는 조합 찾는 메소드
	static void genXOR(int N) {
		
		for(int i=1; i<=N; i++) {
			for(int j=i+1; j<=N; j++) {
				for(int k=j+1; k<=N; k++) {
					
					if((i^j^k) == 0) {
						int bit = (1<<(i-1)) | (1<<(j-1)) | (1<<(k-1));
						XORsubset.add(bit);
					}
				}
			}
		}
		
	}//genXOR
	
}
