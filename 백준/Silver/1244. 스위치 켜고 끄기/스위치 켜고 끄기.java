import java.util.*;
import java.io.*;

public class Main {
	
	//pseudo code 
	//1. 스위치 개수, 스위치 상태, 학생 수 입력 받기 
	//2. 학생이 남/여 학생인지에 따라 다른 함수를 실행한다.
	//2-1. 함수 1 : 남자가 스위치를 바꿀 때 
	//2-2. 함수 2 : 여자가 스위치를 바꿀 때 
	//3. 최종 스위치의 상태를 출력 
	
	static int[] switches;
	static int switchNum;
	static int studentNum;

	public static void main(String[] args) throws IOException{
		
		//1. 스위치 개수, 스위치 상태, 학생 수 입력 받기 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		switchNum = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		switches = new int [switchNum+1];
		
		for(int i=1; i<=switchNum; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		
		studentNum = Integer.parseInt(br.readLine());
		
		//2. 학생이 남/여 학생인지에 따라 다른 함수를 실행한다.
		for(int i=0; i<studentNum; i++) {
			st = new StringTokenizer(br.readLine());
			
			int gender = Integer.parseInt(st.nextToken());
			int sw = Integer.parseInt(st.nextToken());
			
			if(gender==1) {
				ArrayList<Integer> manSwitchNum = getManSwitch(sw);
				setSwitch(manSwitchNum);
			}
			else {
				ArrayList<Integer> womanSwitchNum = getWomanSwitch(sw);
				setSwitch(womanSwitchNum);
			}
		}
		
		for(int i=1; i<=switchNum; i++) {
			System.out.print(switches[i]+" ");
			if(i%20 == 0)
				System.out.println();
		}
		

	}//main
	
	
	//남자가 바꿀 스위치의 넘버를 찾는 함수
	public static ArrayList<Integer> getManSwitch(int num) {
		int i = 1;
		ArrayList<Integer> manSwitchNum = new ArrayList<>();
		
		while(true) {
			if(num*i>switchNum)
				break;
			else {
				manSwitchNum.add(num*i) ;
				i++;
			}
		}
		return manSwitchNum;
	}//getManSwitchNum
	
	
	//여자가 바꿀 스위치의 넘버를 찾는 함수 
	public static ArrayList<Integer> getWomanSwitch(int num) {
		int i = 1;
		ArrayList<Integer> womanSwitchNum = new ArrayList<>();
		womanSwitchNum.add(num);
		
		while(num-i >0 && num+i<=switchNum) {
			if(switches[num-i]==switches[num+i]) {
				womanSwitchNum.add(num-i);
				womanSwitchNum.add(num+i);
				i++;
			}else {
				break;
			}
		}
		
		return womanSwitchNum;
	}
	
	//스위치의 상태를 바꾸는 함수
	
	public static void setSwitch(ArrayList<Integer> switchList) {
		
		for(int n : switchList) {
			if(switches[n]==0) {
				switches[n]=1;
			}
			else 
				switches[n]=0;
		}
		
	}


}
