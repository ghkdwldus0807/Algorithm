import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        int len = numbers.length; 
        
        int negative = numbers[0]*numbers[1];
        int positive = numbers[len-1]*numbers[len-2];
        
        if (negative>positive)
            answer = negative;
        else 
            answer = positive; 
        
        return answer;
    }
}