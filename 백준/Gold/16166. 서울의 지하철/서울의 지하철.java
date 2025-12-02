import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static ArrayList<int[]> lines = new ArrayList<>();
	static HashMap<Integer, ArrayList<Integer>> dict = new HashMap<>(); //k:역, v: 호선 리스트
	static int dept;
	static HashSet<Integer> visited = new HashSet<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		lines.add(new int[] {});

		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int[] temp = new int[K];
			for(int k=0; k<K; k++) {
				int station = Integer.parseInt(st.nextToken());
				temp[k] = station;
				
				if(!dict.containsKey(station)) {
					dict.put(station, new ArrayList<>());
				}
				dict.get(station).add(i);
			}
			lines.add(temp);
		}
		dept = Integer.parseInt(br.readLine());
		
		System.out.println(getNum(dept));
		

	}//main 
	
	static int getNum(int dept) {
		if(dept == 0) return 0;
		
		int ans = -1;
		int[] dist = new int[N+1]; //dist[n] = v n호선으로 가는 최소 환승횟수
		Arrays.fill(dist, -1);
		ArrayDeque<Integer> queue = new ArrayDeque<>(); //노선
		
		for(int i : dict.get(0)) {
			dist[i] = 0;
			queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			int curLine = queue.poll();
			
			for(int i : lines.get(curLine)) {
				if(i == dept) {
					ans = dist[curLine];
					return ans;
				}
			}
			
			for(int station : lines.get(curLine)) {
				if(visited.contains(station)) continue;
				visited.add(station);
				
				//역이가진 노선
				ArrayList<Integer> nextLine = dict.get(station);
				
				if(nextLine == null) continue;
				
				for(int line : nextLine) {
					if(dist[line] != -1 )continue;
					dist[line] = dist[curLine] +1;
					queue.add(line);
				}
				
			}
			
			
		}
		
		
		return -1;
	}

}

/*
 * 환승 횟수 최소 
 * 
 * 
 * */
 