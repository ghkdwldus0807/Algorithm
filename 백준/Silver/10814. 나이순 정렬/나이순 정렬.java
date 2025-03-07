import java.util.*;
import java.io.*;

public class Main {
	
	static class User implements Comparable<User> {
		
		private int age; 
		private String name;
		private int order;
		
		public User(int age, String name, int order) {
			this.age = age;
			this.name = name; 
			this.order = order;
		}
	
		@Override
		public int compareTo(User o) {
			if(this.age == o.age)
				return this.order - o.order;
			
			return this.age -  o.age;
		}
		
		
	}

	static PriorityQueue<User> pq = new PriorityQueue<>();
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			pq.add(new User(age,name,i));
		}
		
		for(int i=0; i<N; i++) {
			User user = pq.poll();
			sb.append(user.age).append(" ").append(user.name).append("\n");
		}
		
		System.out.println(sb);
		
	}

}
