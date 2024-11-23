import java.util.*;

class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        //1. 인덱스에 해당하는 char로 저장 
        char ch1 = my_string.charAt(num1);
        char ch2 = my_string.charAt(num2);
        
        //2. my_string을 char array로 바꿔서 swap 
        char[] arr = my_string.toCharArray();
        arr[num1] = ch2;
        arr[num2] = ch1;
        
        //3. arr를 문자열로 변환 
        answer = String.valueOf(arr);
        return answer;
    }
}