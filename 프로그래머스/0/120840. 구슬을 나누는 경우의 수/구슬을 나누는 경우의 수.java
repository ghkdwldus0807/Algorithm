import java.math.*;

class Solution {
    public int solution(int balls, int share) {
        double answer = 1; //** double type
        
        //1. n!/m! 먼저 계산 하기 
    
        for (int i=share+1; i<=balls; i++){
            answer *= i; 
        }

        
        //2. (n-m)! 계산하기

        for (int j=2; j<=balls-share; j++){
            answer/= j;
        }

        
        return (int)Math.round(answer);
    }
}