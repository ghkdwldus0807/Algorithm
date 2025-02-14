import java.math.*;
import java.util.*;

class Solution {
    public String solution(String s) {

        StringTokenizer st = new StringTokenizer(s);
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        while(st.hasMoreTokens()){
            int i = Integer.parseInt(st.nextToken());
            max = Math.max(max,i);
            min = Math.min(min,i);

        }
        
        
        String answer = min + " "+ max;
        return answer;
    }
}