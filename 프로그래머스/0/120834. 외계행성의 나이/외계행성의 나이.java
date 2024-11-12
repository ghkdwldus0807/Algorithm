import java.util.*;

class Solution {
    public String solution(int age) {
        String answer = "";
        String programmers = "abcdefghij";
        String str_age = String.valueOf(age);
        char[] charArr = str_age.toCharArray();
        
        for (int i = 0; i<charArr.length; i++){
            answer += programmers.charAt(charArr[i]-'0');
        }

        
        return answer;
    }
}