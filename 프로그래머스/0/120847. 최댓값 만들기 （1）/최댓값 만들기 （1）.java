import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 1;
        
        int[] sorted = Arrays.stream(numbers).sorted().toArray();
        
        answer = sorted[sorted.length-1]*sorted[sorted.length-2];
        
        
        
        return answer;
    }
}