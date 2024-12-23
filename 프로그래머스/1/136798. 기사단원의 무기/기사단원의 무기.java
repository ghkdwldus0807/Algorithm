import java.math.*;
import java.util.*;

class Solution {
    
    //약수 개수 구하기
    public int divNum(int number){
        int count = 0; 
        for(int i=1; i<=Math.sqrt(number);i++){
            if(i*i==number)
                count +=1;
            else if(number%i == 0)
                count +=2;
        }
        return count;
        
    }
    public int solution(int number, int limit, int power) {
        int answer = 0;
        //약수 개수 배열
        int [] result = new int[number];
        for(int i=1; i<number+1; i++){
            result[i-1] = divNum(i);
        }
        
        //공격력 제한 수치를 넘는지 확인
        for(int num : result){
            if(num<=limit)
                answer += num;
            else
                answer += power;
        }
        return answer;
    }
}