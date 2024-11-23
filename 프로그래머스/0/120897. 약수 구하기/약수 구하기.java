import java.util.*;
import java.math.*;

class Solution {
    public int[] solution(int n) {
        
        
        //1. 가변크기인 list 만들기 
        List<Integer> result = new ArrayList<>();
        
        //2. n의 제곱근 만큼 반복문, 나머지가 0일 경우, i와 몫 둘 다 list에 저장
        //완전 제곱일 경우
        for(int i=1; i<Math.sqrt(n)+1; i++){
            if((n%i == 0)){
                result.add(i);
                if(i!=n/i){
                    result.add(n/i);
                }
            }

        }
        
        //3. list를 array로 바꾸고, 정렬 
        int[] answer = result.stream().mapToInt(i->i).toArray();
        Arrays.sort(answer);
        return answer;
    }
}