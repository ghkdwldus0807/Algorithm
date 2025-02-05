import java.io.*;
import java.util.*;

public class Main {
	
	//pseudo code
	//1.재귀횟수 입력받기 
	//2. 횟수만큼 반복하여 답변 (함수1)
	//2-1. 답변 반복할때마다 언더바 늘어남
	//3. 라고답변하였지~ 메아리 함수 (함수2)
	
	static String [] ans;
	static int num; //반복횟수

			
	//함수 1 : 횟수만큼 반복 + 언더바 
	public static void repeatAns(int n) {
		
		ans = new String[4];
		
		ans[0] = "\"재귀함수가 뭔가요?\"";
		ans[1] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		ans[2] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		ans[3] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		
		if(n!=num) {
			for(int i=0; i<4; i++) {
				System.out.println("_".repeat(n*4)+ans[i]);
			}
			n +=1;
			repeatAns(n);
		}
		else if(n==num) {
			System.out.println("_".repeat(n*4)+"\"재귀함수가 뭔가요?\"");
			System.out.println("_".repeat(n*4)+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
		}
	
	}
	
	//함수 2 : 메아리 함수 ("~라고 답변하였지")

	public static void echoAns(int n) {
		if(n>=0) {
			System.out.println("_".repeat(n*4)+"라고 답변하였지.");
			n-=1;
			echoAns(n);
		}

	}

	public static void main(String[] args) throws IOException{
		
		//1.재귀횟수 입력받기 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		
		//2. 횟수만큼 반복하여 답변 (함수1)
		repeatAns(0);
		//3.라고답변하였지~ 메아리 함수 (함수2)
		echoAns(num);
		
	}

}
