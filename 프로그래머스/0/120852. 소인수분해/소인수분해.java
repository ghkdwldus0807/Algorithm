import java.util.*;
import java.math.*;

class Solution {
    
    public boolean isPrime (int num){
        for(int i=2; i<=Math.sqrt(num) ; i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    
    public int[] solution(int n) {
        
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int i=2; i<=n; i++){
            if(isPrime(i) && (n%i==0)){
                set.add(i);
            }
        }
        
        int[] answer = set.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}