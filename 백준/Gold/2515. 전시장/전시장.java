import java.util.*;
import java.io.*;

/*dp[i] = i번째 까지의 그림을 고려했을 때 최대 가격 
 * 
 * dp[i]는 두가지 경우로 나뉜다. 
 * 1. i번째 그림을 선택하지 않을 때
 * dp[i] = dp[i-1]
 * 
 * 2. i번째 그림을 선택할 때 
 * dp[i] = cost[i] + dp[i번째의 길이 - s의 인덱스] 
 * */

public class Main {
	
	static class Art implements Comparable<Art> {
		int height, cost; 
		
		Art(int height,int cost){
			this.height=height;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Art o) {
			if(this.height == o.height) {
				return o.cost - this.cost;
			}
			return this.height - o.height;
		}
		
	}
	
	static int N,S;
	static Art[] arts;
	static int [] dp ; 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer (br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arts = new Art[N];
		dp = new int[N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer (br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arts[i] = new Art(h,c);
		}
		
		Arrays.sort(arts);
		
		dp[0] = arts[0].cost;
		
		for(int i=1; i<N; i++) {
			int index = bs(arts[i].height - S);
			if(index<0) {
				dp[i] = Math.max(dp[i-1], arts[i].cost);
			}
			else {
				dp[i] = Math.max(dp[i-1], dp[index] + arts[i].cost);
			}
		}
		
		System.out.println(dp[N-1]);
		

	}//main
	
	//i-S를 만족하는 인덱스 찾기 
	
	static int bs (int height) {
		
		int low = 0; 
		int high = N-1;
		
		while(low <= high) {
			int mid = (low+high)/2;
			
			if(arts[mid].height<height) {
				low = mid+1;
			}
			else if(arts[mid].height > height) {
				high = mid - 1;
			}
			else {
				return mid;
			}
		}
		
		return high;
		
	}
	
	
	
	//i번째 그림을 선택할지 안할지
	static boolean isSelected (int index) {
		if(arts[index].height - arts[index-1].height < S) {
			return false;
		}
		return true;
	}

}


