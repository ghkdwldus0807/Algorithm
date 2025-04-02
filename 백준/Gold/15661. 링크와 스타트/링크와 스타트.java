import java.io.*;
import java.util.*;

public class Main {

	static int N, startExp, linkExp, min; 
	static int[][] exp;
	static ArrayList<Integer> start = new ArrayList<>(); //start 팀에 속한 사람의 num
	static ArrayList<Integer> link = new ArrayList<>(); //link 팀에 속한 사람의 num
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		exp = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				exp[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력
		
		min = Integer.MAX_VALUE;
		
		for(int i=1; i<(1<<N)-1; i++) {
			
			startExp = 0;
			linkExp = 0;
			start.clear();
			link.clear();
			
			for(int j=0; j<N; j++) {
				if((i & (1<<j)) == 0) {
					start.add(j);
				}
				else {
					link.add(j);
				}
			}
			
			//각 팀의 점수 계산
			startExp = getScore(start);
			linkExp = getScore(link);
			
			int diff = Math.abs(startExp - linkExp);
			min = Math.min(min, diff);
			
		}
		
		System.out.println(min);
		
	}//main
	
	
	//점수 계산하는 메소드 
	static int getScore(ArrayList<Integer> list) {
		int score = 0;
		
		for(int i=0; i<list.size(); i++) {
			for(int j=i;j<list.size(); j++ ) {
				score += exp[list.get(i)][list.get(j)];
				score += exp[list.get(j)][list.get(i)];
			}
		}
		
		return score;
	}//getScore

}
