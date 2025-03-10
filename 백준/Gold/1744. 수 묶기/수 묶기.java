import java.util.*;
import java.io.*;

/*
 * 음수끼리 묶으면 이득 => 작은 수부터 묶기 
 * 음수랑 양수랑 묶으면 손해 
 * 0이랑 음수랑 묶으면 이득 
 * 0이랑 양수랑 묶으면 손해 
 * 1은 묶으면 손해 
 * 나머지 양수는 큰 수부터 묶기 
 * 
 * */

public class Main {
	
	static int N, posNum=0,negNum=0, zeroNum=0, oneNum=0; 
	//posNum : 1 제외 자연수
	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			pq.add(num);
			
			if(num>1)
				posNum += 1;
			else if(num<0)
				negNum += 1;
			else if(num == 0)
				zeroNum +=1;
			else 
				oneNum +=1;
				
		} //입력
		
		long sum = 0;
		int index = 0;
		//1. 음수가 존재하는 경우 음수개수/2 만큼 묶기 
		int restNeg = 0;
		
		if(negNum !=0) {
			
			if(negNum % 2 == 0) {
				for(int i=0; i<negNum/2; i++) {
					sum += (pq.poll() * pq.poll());
				}
			}
			else {
				for(int i=0; i<negNum/2; i++) {
					sum += (pq.poll() * pq.poll());
				}
				restNeg = pq.poll();
			}
			
		}
		
		
		//2. zero가 있는 경우 1번하고 남은 음수랑 묶기 , 남은 제로가 있으면 건너뛰기
		
		if(zeroNum != 0) {
			zeroNum -= 1;
			pq.poll();
		}
		else {
			sum += restNeg;
		}
		
		if(zeroNum>0) {
			for(int i=0; i<zeroNum; i++)
				pq.poll();
		}
		
		//3. 1이 있는 만큼 건너뛰기 
		
		for(int i = 0; i<oneNum; i++) {
			sum += pq.poll();
		}
		
		//4. 양수 묶을 수 있는 만큼 묶기
		
		if(posNum%2 == 0) {
			for(int i=0; i<posNum/2; i++) {
				sum += (pq.poll() * pq.poll());
			}
		}
		else {
			int minPos = pq.poll();
			for(int i=0; i<posNum/2; i++) {
				sum += (pq.poll() * pq.poll());
			}
			sum += minPos;
			
		}
		
		System.out.println(sum);
		
	}

}
