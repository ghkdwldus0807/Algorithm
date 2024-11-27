import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        String result = "";
        
        for(int n:array){
            result += n+"";
        }
        
        result = result.replaceAll("[^7]","");
        answer = result.length();
        return answer;
    }
}