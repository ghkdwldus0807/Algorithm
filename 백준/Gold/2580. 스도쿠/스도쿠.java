import java.util.*;
import java.io.*;

/*
 * 1. 빈칸이 하나 밖에 없어서 가로, 세로, 3x3 탐색으로 인해서 바로 확정이 나는 경우
 * -> 그냥 그 값 지정 
 * 2. 만약 빈칸이 여러개라 가로, 세로, 3x3 탐색으로도 경우의 수가 여러 개 나온다면
 * -> 경우의 수를 바탕으로 해당 경우의 수를 돌면서 답이 되는지 안되는지 확인 
 * 3. 
 * 
 * p.446
 * 
 * */

/*
 * 가로, 세로, 3x3 탐색하는 함수 
 * -> 위 세가지 탐색을 다 해보고 경우의 수 ArrayList 로 반환 
 * 
 * 스토쿠 칸에서 빈칸이 있는지 없는지 확인 -> 빈칸 나오면 그 해당 좌표를 return하고 다 채워지면 {-1,-1}반환
 * 
 * */

public class Main {

	static int [][] stk = new int[9][9];//스토쿠 판

	static List<int []> emptyCases = new ArrayList<>();
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				int n= Integer.parseInt(st.nextToken());
				stk[i][j] = n;

			}
		}//스토쿠 초기화 
		

		getEmpty(stk);

		findStk(0);
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				sb.append(stk[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

		
	}//main 
	
	//백트래킹 ** 재귀 
	static boolean findStk(int index) {
		
		if(index == emptyCases.size()) 
			return true;
		
		int [] coordinate = emptyCases.get(index);
		int i = coordinate[0]; int j = coordinate[1];
		
		List<Integer> set = getCase(coordinate, stk);
		
		for (int n: set) {
			stk[i][j] = n; 
			
			if(findStk(index+1))
				return true;
			
			stk[i][j]=0; //백트래킹
		}
		
		return false;
	}

	
	
	static void getEmpty(int[][] stk) {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(stk[i][j]==0)
					emptyCases.add(new int[] {i,j});
			}
		}
		
	} //getEmpty : 스토쿠에서 빈칸 좌표 확인 
	
	
	
	static List<Integer> getCase(int[] coordinate, int[][] stk) {
	    int i = coordinate[0], j = coordinate[1];

	    // 1~9까지 모든 숫자를 리스트에 저장
	    List<Integer> candidates = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

	    // 가로, 세로 방향에서 제거
	    for (int a = 0; a < 9; a++) {
	        candidates.remove((Integer) stk[i][a]); // 가로
	        candidates.remove((Integer) stk[a][j]); // 세로
	    }

	    // 3x3 정사각형에서 제거
	    int startH = (i / 3) * 3, startW = (j / 3) * 3;
	    for (int a = startH; a < startH + 3; a++) {
	        for (int b = startW; b < startW + 3; b++) {
	            candidates.remove((Integer) stk[a][b]);
	        }
	    }
	    
	    //교집합

	    return candidates; 
	} // 모든 경우의 수 

	
	

}
