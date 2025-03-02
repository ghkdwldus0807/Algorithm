import java.io.*;
import java.util.*;

public class Main {
	
	static HashMap<Integer, String> pokedex = new HashMap<>();
	static HashMap<String, Integer> reversePokedex = new HashMap<>();
	static int N,M;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			String pokemon = br.readLine();
			setPokemon(i,pokemon);
		}
		
		for(int i=0; i<M; i++) {
			System.out.println(findPokemon(br.readLine()));
		}

	}
	
	
	//포켓몬 도감에 저장하는 함수 
	static void setPokemon(int num, String name) {
		pokedex.put(num, name);
		reversePokedex.put(name, num);
	}
	
	
	//포켓몬 도감에서 찾는 함수
	static String findPokemon(String pokemon) {
		
		if(isInteger(pokemon))
			return pokedex.get(Integer.parseInt(pokemon));

		else 
			return String.valueOf(reversePokedex.get(pokemon));

	}
	
	//주어진 문자가 도감 번호인지 아닌지 판단
	static boolean isInteger(String name) {
		
		return name.matches("\\d+");
		
	}

}
