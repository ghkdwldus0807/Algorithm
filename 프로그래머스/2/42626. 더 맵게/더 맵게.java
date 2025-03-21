import java.util.*;

class Solution {
    
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        
        for(int n : scoville){
            pq.add(n);
        }
        
        while (!pq.isEmpty()){
            int size = pq.size();
            
            if(size == 1){
                if(pq.poll()>=K)
                    return answer;
                else 
                    return -1;
            }

            int n1 = pq.poll();
            int n2 = pq.poll();
            
            if(n1>= K){
                break;
            }
            
            if(n2/2>=K){
                answer ++;
                break;
            }
            
            pq.add(n1+n2*2);
            answer++;
            
        }
        
        return answer;
    }
}