import java.io.*;
import java.util.*;

public class Main {
	
	static String s1, s2;
	static int num1, num2, sum; 
	static HashMap<String, Integer> dict = new HashMap<>();
	static StringBuilder roma = new StringBuilder();

//	static class Roma implements Comparable<Roma>{
//		
//		private char alphabet;
//		private int value;
//		
//		public Roma(char alphabet, int value) {
//			this.alphabet = alphabet;
//			this.value = value;
//		}
//		
//		@Override
//		public int compareTo(Roma o) {
//			
//			return o.value - this.value;
//		}
//		
//	}

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s1 = br.readLine();
		s2 = br.readLine();
		
		dict.put("I", 1);
		dict.put("V", 5);
		dict.put("X", 10);
		dict.put("L", 50);
		dict.put("C", 100);
		dict.put("D", 500);
		dict.put("M", 1000);
		dict.put("IV", 4);
		dict.put("IX", 9);
		dict.put("XL", 40);
		dict.put("XC", 90);
		dict.put("CD", 400);
		dict.put("CM", 900);
		
		if(s1.length() == 1) {
			num1 += dict.get(String.valueOf(s1.charAt(0)));
		}
		else {
			for(int i=0; i<s1.length()-1; i++) {
				//인덱스 기준 두 글자 파악 
				StringBuilder sb = new StringBuilder();
				sb.append(s1.charAt(i)).append(s1.charAt(i+1));
				
				
				if(dict.containsKey(sb.toString())) {
					num1 += dict.get(sb.toString());
					i++;
					if(i == s1.length()-2) {
						num1 += dict.get(String.valueOf(s1.charAt(i+1)));
					}
				}
				else {
					//한글자만 
					num1 += dict.get(String.valueOf(s1.charAt(i)));
					if(i == s1.length()-2) {
						num1 += dict.get(String.valueOf(s1.charAt(i+1)));
					}
				}
				
			}
			
		}
		
		
		if(s2.length() == 1) {
			num2 += dict.get(String.valueOf(s2.charAt(0)));
		}
		else {
			
			for(int i=0; i<s2.length()-1; i++) {
				//인덱스 기준 두 글자 파악 
				StringBuilder sb = new StringBuilder();
				sb.append(s2.charAt(i)).append(s2.charAt(i+1));
				
				
				if(dict.containsKey(sb.toString())) {
					num2 += dict.get(sb.toString());
					i++;
					if(i == s2.length()-2) {
						num2 += dict.get(String.valueOf(s2.charAt(i+1)));
					}
				}
				else {
					//한글자만 
					num2 += dict.get(String.valueOf(s2.charAt(i)));
					if(i == s2.length()-2) {
						num2 += dict.get(String.valueOf(s2.charAt(i+1)));
					}
				}
				
			}
			
		}
		

		
		sum = num1+num2;
		
		System.out.println(sum);
		
		//로마자로 바꾸기 
		
		//1. 천의 자리가 있는지 확인
		if(sum/1000 > 0) {
			for(int i=0; i<sum/1000; i++) {
				roma.append("M");
			}
			sum -= 1000*(sum/1000);
		}
		
		//2. 백의 자리 
		int div = sum /100;
		
		if(div > 0) {
			
			if(div == 9) {
				roma.append("CM");
				sum -= 900;
			}
			else if(div == 4) {
				roma.append("CD");
				sum -= 400;
			}
			else if(div >= 5) {
				roma.append("D");
				sum -= 500;
			}
			
			div = sum / 100;
			
			for(int i=0; i<div; i++) {
				roma.append("C");
			}
			sum -= div*100;
			
		}
		
		// 십의 자리 
		
		div = sum /10;
		
		if(div > 0) {
			
			if(div == 9) {
				roma.append("XC");
				sum -= 90;
			}
			else if(div == 4) {
				roma.append("XL");
				sum -= 40;
			}
			else if(div >= 5) {
				roma.append("L");
				sum -= 50;
			}
			
			div = sum / 10;
			
			for(int i=0; i<div; i++) {
				roma.append("X");
			}
			
			sum -= div*10;
			
		}
		
		//일의 자리 

		div = sum;
		
		if(div > 0) {
			
			if(div == 9) {
				roma.append("IX");
				sum -= 9;
			}
			else if(div == 4) {
				roma.append("IV");
				sum -= 4;
			}
			else if(div >= 5) {
				roma.append("V");
				sum -= 5;
			}
			
			div = sum ;
			
			for(int i=0; i<div; i++) {
				roma.append("I");
			}
			
		}
		
		System.out.println(roma);
		
		
		
	}//main
	
	
	

}
