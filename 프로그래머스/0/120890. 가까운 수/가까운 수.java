import java.util.*;
import java.math.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        //1. n과의 거리절댓값 계산
        int[] result = Arrays.stream(array).map(x->Math.abs(n-x)).toArray();
        
        //2. 제일 가까운 수 계산 
        // List<Integer> ans = new ArrayList<>();
        int index = 0; //가까운 수의 인덱스 
        for(int i=1; i<result.length; i++){
            if(result[i]<result[index]){
                index = i;
            }
        }
        
        //3. 여러 개일 경우를 대비하여 가까운 수의 인덱스 한 번 더 반복문으로 
        
        for(int i=0; i<result.length; i++){
            if((result[i]==result[index])&&(array[i]<array[index]))
                index = i;
        }
        
        answer = array[index];
        
        return answer;
    }
}