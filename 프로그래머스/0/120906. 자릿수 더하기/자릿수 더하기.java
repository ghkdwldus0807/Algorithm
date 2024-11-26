import java.math.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int len = (n+"").length()-1;
        int i = (int)Math.pow(10,len);
        int result = 1;
        while(i!=0){
            result = n/i;
            n = n - (result*i);
            answer += result;
            i = i/10;
        }
        
        return answer;
    }
}