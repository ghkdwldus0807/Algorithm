import java.util.*;
import java.io.*;

public class Solution {
	
	/*
	 * 종료 조건??? 
	 * 
	 * 1. 모든 좌표에 2를 곱해서 0.5초마다 1단위 이동하는 것으로 변환
	 * 2. 같은 위치에 원자가 겹치면 충돌 -> 0으로 바꿔서 없앰 
	 * 3. 모든 원자가 공간 범위를 넘어간다면 종료 ( 0 ~ 4000 ) 
	 * 
	 * 
	 * map[][] 에 있는 숫자는 각 원자 에너지
	 * 원자를 옮겼는데 거기에 0이 아닌 숫자가 있다? -> 겹친 거임 일단 에너지 더하고 원자수 -- , 충돌 좌표를 큐에 넣음 그리고 한 턴이 끝난후 큐에 들어있는 좌표값을 방출에너지에 더하고 0으로 바꿈 원자수 --(원래 있던 원자), 
	 * 원자를 옮겼는데 -2001 , 2001이다? 그냥 없앰 ㅋ 원자 수 -- 하기 
	 * */
	
//	static int [][] map = new int [4001][4001];
	static int T,N;
	static Queue<int []> atoms = new ArrayDeque<>(); //원자 정보 저장 {y,x,energy,move};
	static ArrayList<int[]> nextAtoms = new ArrayList<>(); //이동 후 원자 정보 저장 
	static StringBuilder sb = new StringBuilder();
	static int answer; 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T  = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			
			N = Integer.parseInt(br.readLine());
			answer  = 0;
			for(int n=0; n<N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken())*2;
				int y = Integer.parseInt(st.nextToken()) *2 ;
				int move = Integer.parseInt(st.nextToken());
				int energy = Integer.parseInt(st.nextToken());
				
//				map[y][x] = energy;
				atoms.add(new int [] {y, x, energy,move});
			}// 초기 원자 입력
			
			bfs();
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
			
			
		}// test case 반복 
		
		System.out.println(sb);
		
	}//main 
	
	
	//원자가 충돌 할 때 까지 OR 원자가 공간 범위를 벗어날 때 까지 이동 시키는 메서드 
	static void bfs() {
		
		
		
		while(!atoms.isEmpty()) {
			
			int len = atoms.size();
			
			for(int i=0; i<len; i++) {
				
				int [] current = atoms.poll();
				int curY = current[0];
				int curX = current[1];
				int curEnergy = current[2];
				int curMove = current[3];
				
				int nextY = moveY(curY, curMove);
				int nextX = moveX(curX, curMove);
				
				if(nextX<-2000 || nextX>2000 || nextY<-2000 || nextY>2000) { //공간 범위 넘어가는 경우 
					continue;
				}
				
				nextAtoms.add(new int[] {nextY,nextX,curEnergy,curMove});
				
				
			}
			
			checkDup();
			
			nextAtoms.clear();

			
		}
		
		
	}//bfs
	
	
	//옮긴 후 좌표가 다른 원자들이랑 겹치는지 확인하는 메서드
	
	static void checkDup() {
		Collections.sort(nextAtoms, new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				if(o1[1] == o2[1])
					return o1[0] - o2[0];
				
				return o1[1] - o2[1];
			}
		});
		
		int len = nextAtoms.size();
		
		if(len==0)
			return;
		
		int standardY = nextAtoms.get(0)[0];
		int standardX = nextAtoms.get(0)[1];
		int standardE = nextAtoms.get(0)[2];
		int standardM = nextAtoms.get(0)[3];
		int count = 1; 
		int tempEnergy = standardE;
		
		for(int i=1; i<len; i++) {
			int [] current = nextAtoms.get(i);
			
			if((current[0] != standardY || current[1] != standardX) && count == 1) { //중복 X 
				atoms.add(new int[] {standardY, standardX, standardE, standardM});
				count = 1; 
				standardY = current[0];
				standardX = current[1];
				standardE = current[2];
				standardM = current[3];
				tempEnergy = standardE;
			}
			else if((current[0] != standardY || current[1] != standardX) && count >1) { //중복이지만 바뀔 떄 
				count = 1; 
				answer += tempEnergy;
				standardY = current[0];
				standardX = current[1];
				standardE = current[2];
				standardM = current[3];
				tempEnergy = standardE;
			}
			else if (current[0] == standardY && current[1] == standardX) { //겹칠 때 
				count ++;
				tempEnergy += current[2];
			}
		}
		
		if(count == 1) {
		    atoms.add(new int[] {standardY, standardX, standardE, standardM});
		} else {
		    answer += tempEnergy;
		}

		
	}//checkDup
	
	//move 변수에 따라 Y 좌표 이동시키는 메서드 
	static int moveY(int curY, int command) {
		int nextY = 0;
		
		if(command == 0) 
			nextY = curY + 1;
		else if(command==1)
			nextY = curY - 1;
		else {
			nextY = curY;
		}
		
		return nextY;
		
	}//moveY
	
	
	//move 변수에 따라 X 좌표 이동시키는 메서드 
	static int moveX(int curX, int command) {
		int nextX = 0;
		
		if(command == 2)
			nextX = curX - 1;
		else if (command == 3)
			nextX = curX + 1;
		else 
			nextX = curX;
		
		return nextX;
	}


}
