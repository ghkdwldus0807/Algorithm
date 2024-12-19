import java.math.*;

class Solution {
    public int[] evenNum(int num, int total){
        int[] answer = new int[num];
        
        //1. num이 짝수일 때 
        double center = total/num;
        int side1 = (int)Math.floor(center);
        int side2 = (int)Math.ceil(center);

        int index = num/2-1;
        
        //1-1. side1기준 왼쪽 배열 채우기;
        for(int i=0; i<index; i++){
            answer[i] = side1-(index-i);
        }
        //1-2. side2기준 오른쪽 배열 채우기
        int count = 0;
        for(int i=index; i<num; i++){
            answer[i] = side2+count;
            count +=1;
        }
        
        return answer;
    }
    
    public int[] oddNum(int num, int total){
        int[] answer = new int[num];
        int center = total/num; 
        
        //1. center 값이 들어가는 index 찾기 
        int index = (num-1)/2;
        answer[index] = center;
        //2. center 기준 왼쪽 배열 채우기 
        for(int i = 0; i<index; i++){
            answer[i] = center-(index-i);
        }
        //3. center 기준 오른쪽 배열 채우기
        for(int i=index+1; i<num; i++){
            answer[i] = center+i-index;
        }
        return answer;
    }
    public int[] solution(int num, int total) {
        int[] answer = {};
        
        if(num%2==0){
            answer = evenNum(num,total);
        }else
            answer = oddNum(num,total);

        
        return answer;
    }
}