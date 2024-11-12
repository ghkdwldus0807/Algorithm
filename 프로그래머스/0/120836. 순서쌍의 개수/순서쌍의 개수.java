import java.math.*;

class Solution {
    public int solution(int n) {
        
        int answer = 0;
        
        //1. int n이 완전제곱수인지 확인 
        
        int sqrt = (int) Math.sqrt(n) ;

        
        //2. 완전 제곱수인 경우 제곱수보다 작은 약수 개수 *2 +1, 아닌 경우 *2
        for (int i = 1; i<=sqrt; i++){
            if(n%i==0){
                answer+=1;
            }
        }
        System.out.println(answer);
        
        if(n==sqrt*sqrt){
            answer = 2*answer-1;
        }else{
            answer*=2;
        }
        
        return answer;
    }
}