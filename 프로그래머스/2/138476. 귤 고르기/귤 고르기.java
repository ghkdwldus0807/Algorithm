import java.util.*;

class Solution {
    
    class Orange implements Comparable<Orange>{
        int size; 
        int num;
        
        public Orange(int size, int num){
            this.size = size;
            this.num = num;
        }
        
        @Override
        public int compareTo(Orange o){
            return o.num - this.num;
        }
    }
    
    static HashMap<Integer,Integer> dict = new HashMap<>(); //k:귤 사이즈, v: 귤의 개수
    static ArrayList<Orange> list = new ArrayList<>();

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        //map에다가 개수 넣기
        
        for(int i=0; i<tangerine.length; i++){
            int key = tangerine[i];
            dict.put(key, dict.getOrDefault(key,0)+1);
        }
        //map 정렬하기 (value, 내림차순)
        for(int key : dict.keySet()){ 
            list.add(new Orange(key, dict.get(key)));
        }
        
        Collections.sort(list);
        
        int sum = 0;
        
        for(int i=0; i<list.size(); i++){
            sum += list.get(i).num;
            answer ++;
            
            if(sum>=k){
                break;
            }
            
        }
        
        
        return answer;
    }
}