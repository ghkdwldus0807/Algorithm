

import java.util.*;
import java.io.*;

public class Solution {
	
	static StringBuilder sb = new StringBuilder();
	static int T, D, W, K;
	static int [][] map;
	static int [][] map2;//복구용 
	static int total;
	static int [] list; //조합 임시 저장용 (row_
	static char [] listab; //조합 임시 저장용 (AB 약품)
	static char [] AB = new char [] {'A','B'};
	static ArrayList<int []> rowCombi = new ArrayList<>();
	static ArrayList<char []> abCombi = new ArrayList<>();
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			rowCombi = new ArrayList<>();
			abCombi = new ArrayList<>();
			map = new int[D][W];
			map2 = new int[D][W];
			total = 0;
			
			for(int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}//입력 
			
			map2 = copyMap();
			
			if (isSatisfiedCell(map)) {
				min = 0;
			}
			else {
				for(int i=1; i<K; i++) {
					list = new int[i];
					listab = new char[i];
					rowCombi = new ArrayList<>();
					abCombi = new ArrayList<>();
					getRowCombi(0, 0, i);
					getABCombi(0, 0, i);
					
					for(int r=0; r<rowCombi.size(); r++) {
						int [] rows = rowCombi.get(r);
						for(int ab = 0; ab<abCombi.size(); ab++) {
							char [] abs = abCombi.get(ab);
//							System.out.println("================\n"+Arrays.toString(rows));
//							System.out.println(Arrays.toString(abs));
							changeMap(rows, abs, map);
							
							if(isSatisfiedCell(map)) {
//								System.out.println("값 바뀜 , ");
								min = Math.min(min, i);
							}
							
							//row 롤백 
							rollbackMap(rows, map);
							
						}
						
						
					}
				}//for - K
				
			}

			
			if(min == Integer.MAX_VALUE)
				System.out.printf("#%d %d",t+1,K);
			else 
				System.out.printf("#%d %d",t+1,min);

			System.out.println();
		}//for - test case 반복 
	} //main
	
	
	
	//각 경우의 수를 검사하기 위한 map 복사하는 함수
	static int[][] copyMap(){
		
		int[][] copy = new int [D][W];
		
		for(int i=0; i<D; i++) {
			for(int j=0; j<W; j++)
				copy[i][j] = map[i][j];
		}
		
		return copy;
	}//copyMap 
	
	
	//성능 기준을 만족하는지 
	static boolean isSatisfiedCell(int[][] map){
		
		for(int j=0; j<W; j++) {
			int current = map[0][j];
			int start = 0;
			int end = 0; 
			int count = 0;
			
			for(int i=0; i<D; i++) {
				
				if(count == K)
					break;
				
				if(map[i][j]==current) {
					count++;
				}
				else {
					current = map[i][j];
					count = 1;
				}
			}
			
			if(count != K)
				return false;
		}
		
		return true;
		
	} // getNotSatisfiedCell
	
	
	//모든 경우의 수 찾기 - row 
	// D개 중에 1~K-1개 뽑는 모든 조합 

	static void getRowCombi(int start, int index, int k) {
		
		if(index==k) {
			int [] result = new int[k];
			for(int i=0; i<k; i++) {
				result[i] = list[i];
			}
			rowCombi.add(result);
			return;
		}
		
		for(int i=start; i<D ; i++) {
			list[index] = i; 
			getRowCombi(i+1, index+1, k);
		}
		
	}//getRowCombi
	
	
	//모든 경우의 수 찾기 - A,B
	static void getABCombi(int start, int index, int k) {
		
		if(index==k) {
			char [] result = new char[k];
			for(int i=0; i<k; i++) {
				result[i] = listab[i];
			}
			abCombi.add(result);
			return;
		}
		
		for(int i=0; i<2; i++) {
			listab[index] = AB[i];
			getABCombi(i, index+1, k);
		}
		
		
	}//getABCombi
	
	
	//조합과 ab의 경우의 수에 기반하여 map을 바꾸는 함수 
	
	static void changeMap(int [] rows, char [] abs, int [][] map) {
		
		int len = rows.length;
		for(int i=0; i<len; i++) {
			int row = rows[i];
			int ab = abs[i]-65;
			for(int j=0;j<W; j++) {
				map[row][j] = ab;
			}
		}
		
	}//changeMap 
	
	
	//row 롤백 하는 함수
	static void rollbackMap(int [] rows, int [][] map) {
		
		int len = rows.length;
		
		for(int i=0; i<len; i++) {
			int row = rows[i];
			for(int j=0; j<W; j++)
				map[row][j] = map2[row][j];
		}
	}

}
