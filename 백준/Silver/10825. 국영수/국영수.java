import java.util.*;
import java.io.*;

public class Main {

	static class Student implements Comparable<Student>{
		
		private String name;
		private int kor;
		private int eng; 
		private int math;
		
		public Student(String name, int kor, int eng, int math) {
			this.name = name; 
			this.kor = kor;
			this.eng = eng; 
			this.math = math;
		}
		
		@Override
		public int compareTo(Student o) {
			
			if(this.kor == o.kor && this.eng == o.eng && this.math == o.math) {
				return this.name.compareTo(o.name);
			}
			else if(this.kor == o.kor && this.eng == o.eng)
				return o.math - this.math;
			
			else if(this.kor == o.kor)
				return this.eng - o.eng;
			
			return o.kor - this.kor;
		}
		
	}
	
	
	static PriorityQueue<Student> pq = new PriorityQueue<>();
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			
			pq.add(new Student(name, kor, eng, math));
		}
		
		for(int i=0; i<N; i++) {
			Student st = pq.poll();
			sb.append(st.name).append("\n");
		}
		
		System.out.println(sb);
		
	}//main

}
