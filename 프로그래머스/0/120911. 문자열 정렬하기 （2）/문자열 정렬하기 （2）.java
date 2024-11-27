import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        my_string = my_string.toLowerCase();
        
        String[] result = my_string.split("");
        
        Arrays.sort(result);
        for (String str:result){
            answer += str;
        }
        
        return answer;
    }
}