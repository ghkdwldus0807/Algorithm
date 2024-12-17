import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        
        int len = score.length;
        Integer[] sortedResult = new Integer[len];
        int[] answer = new int [len];
        
        for(int i=0; i<len; i++){
            sortedResult[i] = score[i][0] + score[i][1];
        }
        Integer[] result = Arrays.copyOf(sortedResult,len);
        
        Arrays.sort(sortedResult,Collections.reverseOrder());
        
        for(int i=0; i<len; i++){
            answer[i] = Arrays.asList(sortedResult).indexOf(result[i])+1;
        }
    
        return answer;
    }
}