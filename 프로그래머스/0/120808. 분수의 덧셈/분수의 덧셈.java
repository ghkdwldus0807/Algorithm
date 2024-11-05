import java.math.*;

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        
        //1.일단 통분해서 더하기
        
        int numer = numer1*denom2 + numer2*denom1;
        int denom = denom1*denom2;
        
        //2. 최대 공약수로 나누기
        
        int gcd = BigInteger.valueOf(numer).gcd(BigInteger.valueOf(denom)).intValue();
        
        numer = numer/gcd;
        denom = denom/gcd;
        
        int[] answer = {numer,denom};
        return answer;
    }
}