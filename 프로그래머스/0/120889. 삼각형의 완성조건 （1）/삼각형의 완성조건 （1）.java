import java.util.*;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);
        int max = sides[2];
        int others = sides[0]+sides[1];
        
        if(max<others)
            answer = 1;
        else 
            answer = 2;
        
        return answer;
    }
}