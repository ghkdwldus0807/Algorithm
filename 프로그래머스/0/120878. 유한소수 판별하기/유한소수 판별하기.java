

class Solution {
    public int gcd (int a, int b){
        if( b == 0)
            return a;
        else 
            return gcd(b, a%b);
    }
    
    public int solution(int a, int b) {
        int answer = 0;
        int gcdNum = gcd(a,b);
        int parents = b/gcdNum;
        int child = a/gcdNum;
        int result = parents;

        
        while(result%2==0){
            result /= 2;
        }
        while(result%5==0){
            result /= 5;
        }
        
        if(parents == 1)
            answer = 1;
        else if(child == parents)
            answer = 1;
        else if(result == 1)
            answer = 1;
        else 
            answer = 2;
        
        return answer;
    }
}