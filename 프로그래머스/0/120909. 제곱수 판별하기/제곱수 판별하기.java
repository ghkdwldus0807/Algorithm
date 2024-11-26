import java.math.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int sqrt = (int)Math.sqrt(n);
        
        if(n%sqrt == 0){
            answer = 1;
        }else 
            answer = 2;
        return answer;
    }
}