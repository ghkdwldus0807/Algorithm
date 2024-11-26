import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        //1.list로 동적 할당 
        List<Integer> result = new ArrayList<>();
        
        for (int num : numlist){
            if(num%n == 0){
                result.add(num);
            }
        } 
        
        //2. list를 다시 배열로 변환 
        int[] answer = new int[result.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}