import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	
	/*
	 * 1. 배열 입력을 받으면서 치킨집의 좌표를 수집한다.
	 * 2. 치킨집의 좌표를 대상으로 M개를 선택하는 조합을 저장한다. 
	 * 3. 조합마다 치킨 거리의 값을 계산, 최솟값을 출력 
	 * */
	
	
	static ArrayList<int[]> chickens; //치킨 집의 좌표 
	static ArrayList<int[]> comb; // m개를 선택하는 조합(chickens의 인덱스를 저장)
	static int[] temp; //임시 조합 저장 배열
	static int minDis ; //최소 치킨 거리 (출력값)
	static int totalDis; //도시의 치킨 거리
	static int n, m; 
	static int [][] map;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		temp = new int [m];
		chickens = new ArrayList<>();
		comb = new ArrayList<>();
		minDis = 999999;
		totalDis = 0;
		
		//1. 배열 입력을 받으면서 치킨집의 좌표를 수집한다.
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int n1 = Integer.parseInt(st.nextToken());
				map[i][j] = n1;
				if(n1==2) {
					chickens.add(new int[] {i,j});
				}
			}
		}//for
		
		
		//2. 치킨집의 좌표를 대상으로 M개를 선택하는 조합을 저장한다.
		dfs(0,0);
		
		//3. 조합마다 치킨 거리의 값을 계산, 최솟값을 출력 
		
		for(int k=0; k<comb.size(); k++) {
			totalDis = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j]==1) {
						int d = calDistance(i,j,comb.get(k));
						totalDis += d;
					}
				}
			}
			minDis = Math.min(totalDis, minDis);
			
		}
		
		System.out.println(minDis);
		
	}//main
	
	
	//조합 계산 
	static void dfs(int start, int index) {
		
		if(index==m) {
			comb.add(Arrays.copyOf(temp, m));
			return;
		}
		
		for(int i=start; i<chickens.size(); i++) {
			temp[index] = i;
			dfs(i+1,index+1);
		}
		

		
	}//dfs 
	
	
	//거리 계산 
	static int calDistance(int i, int j, int[] arr) {
		
		int distance = 0;
		int minDis = 999999;
		
		for(int t=0; t<m; t++) {
			distance = Math.abs(i-chickens.get(arr[t])[0]) + Math.abs(j-chickens.get(arr[t])[1]);
			minDis = Math.min(distance, minDis);
		}

		return minDis;
	}

}
