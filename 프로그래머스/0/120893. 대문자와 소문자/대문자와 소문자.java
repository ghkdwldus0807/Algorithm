import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] charArr = my_string.toCharArray();
        for(char c : charArr){
            if(Character.isLowerCase(c)){
                answer+= Character.toUpperCase(c);
            }else
                answer += Character.toLowerCase(c);
        }
        return answer;
    }
}