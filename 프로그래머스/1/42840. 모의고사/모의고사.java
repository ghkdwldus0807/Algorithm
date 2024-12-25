import java.math.*;
import java.util.*;

class Solution {
    
    public int[] max(int answer1, int answer2, int answer3){
        ArrayList<Integer> ans = new ArrayList<>();
        int max = Math.max(answer1,answer2);
        max = Math.max(max,answer3);
        
        if(answer1==max)
            ans.add(1);
        if(answer2==max)
            ans.add(2);
        if(answer3==max)
            ans.add(3);
        
        int len = ans.size();
        
        int [] result = new int [len]; 
        
        if(len != 0){
            for(int i = 0; i<len; i++){
                result[i] = ans.get(i);
        }
            
        }

        return result;
    }
    public int[] solution(int[] answers) {
        int[] supo1 = {1,2,3,4,5};
        int[] supo2 = {2,1,2,3,2,4,2,5};
        int[] supo3 = {3,3,1,1,2,2,4,4,5,5};
        int index1 = 0; // index1 = index % 5;
        int index2 = 0; // index2 = index2 % 8
        int index3 = 0; // index3 = index3 % 10;
        int answer1 = 0;
        int answer2 = 0;
        int answer3 = 0; 
        
        //1. answers (문제개수) 알기 
        int answerNum = answers.length;
        //2. 각 수포자의 index를 기억하고 저장하면서 반복문 돌리기, 정답일 경우 카운트 
        for(int i=0; i<answerNum; i++){
            index1 = i%5;
            index2 = i%8;
            index3 = i%10;
            
            if(answers[i] == supo1[index1])
                answer1 +=1;
            if(answers[i] == supo2[index2])
                answer2+=1;
            if(answers[i] == supo3[index3])
                answer3+=1;
            
        }
        
        //3. 점수 비교 후 answer에 넣기 
        int [] answer = max(answer1,answer2,answer3);
        
        return answer;
    }
}