import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0; 
        //1.공백 기준으로 배열로 나누기 & 첫번째 num으로 answer 초기화;
        String[] arr = my_string.split(" ");
        System.out.println(Arrays.toString(arr));
        answer = Integer.parseInt(arr[0]);
        
        //배열 index 홀수는 연산자고 짝수는 숫자라는 규칙 활용하여 계산
        for(int i=1; i<arr.length; i+=2){
            if(arr[i].equals("+")){
                answer = answer + Integer.parseInt(arr[i+1]);
            }else
                answer = answer - Integer.parseInt(arr[i+1]);
        }

        return answer;
    }
}