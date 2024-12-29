import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        
        //1. 스택에 넣기
        Stack<Integer> boxes = new Stack<>();
        
        for(int num : score){
            boxes.push(num);
        }
        
        //2. 스택에서 m개씩 뺀 후, 상자의 점수를 구하기 
        int minScore = 10;
        int top = 0;
        while(boxes.size()>=m){
            for(int i=0; i<m; i++){
                top = boxes.pop();
                if(minScore>top)
                    minScore = top;
            }
            answer += minScore*m;
        }
        
        //3. 스택에 남은 요소가 m개 미만일 때까지 반복
        
        return answer;
    }
}