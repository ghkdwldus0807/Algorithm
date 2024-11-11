import java.math.*;

class Solution {
    public int gcd(int a,int b){
            if(b==0)
                return a;
            else 
                return gcd(b,a%b);
            
        }
        
    public int solution(int n) {
        

        int answer = 0;
        
        //1. n과 6의 최소공배수 구하기 a*b/gcd 
        int piece = (n*6)/gcd(n,6);
        
        //2. 최소공배수 / 6 
        answer = piece/6;
        
        return answer;
    }
}