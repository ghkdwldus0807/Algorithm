import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
	
	/*
	 * 1. 요리를 선택하는 모든 경우의 수를 구하면서.
	 * 1-2. 각 경우마다 신맛,쓴맛을 계산한다. 
	 * 2. 차이가 가장 작으면 min값을 update
	 * 
	 * */
	
	static int n; //재료의 개수
	static int [][] arr; //각 재료의 신맛, 쓴맛 저장 
	static ArrayList<Integer> subset; //경우의 수 임시 저장소(arr의 index를 저장)
	static boolean[] isSelected; 
	static int minDiff;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		isSelected = new boolean[n];
		subset = new ArrayList<>();
		arr = new int [n][2];
		minDiff = Integer.MAX_VALUE;
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		genSubset(0);
		
		System.out.println(minDiff);
		
		
	}
	
	
	//모든 경우의 수를 구하면서, 그 인덱스에 해당하는 재료들의 차이 구하기 
	
	static void genSubset(int index) {
		if(index==n) {
			for(int i=0; i<n; i++) {
				if(isSelected[i] )
					subset.add(i);
			}
			
			if(!subset.isEmpty())
				minDiff = Math.min(minDiff, calDiff(subset));
			
			subset.clear();
			return;
		}
		
		isSelected[index] = true;
		genSubset(index+1);
		isSelected[index] = false;
		genSubset(index+1);
		
		
	}
	
	
	//재료들의 차이 구하기 
	static int calDiff(ArrayList<Integer> subset) {
		int diff = 0;
		int sour = 1;
		int bitter = 0;
		
		for(int i=0; i<subset.size(); i++) {
			sour*=arr[subset.get(i)][0];
			bitter+=arr[subset.get(i)][1];
		}
		
		diff = Math.abs(sour-bitter);
		
		return diff;
		
	}

}
