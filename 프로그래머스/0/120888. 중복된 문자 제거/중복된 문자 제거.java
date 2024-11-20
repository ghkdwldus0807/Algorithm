import java.util.*;

class Solution {
    public String solution(String my_string) {
        LinkedHashSet<Character> result = new LinkedHashSet<>();
        
        for(char c : my_string.toCharArray()){
            result.add(c);
        }
        
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        for (char c : result){
            sb.append(c);
        }

        answer = sb.toString();
        
        return answer;
    }
}