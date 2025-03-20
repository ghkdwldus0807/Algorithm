import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int len = commands.length;
        int[] answer = new int [len];
        
        for(int i=0; i<len; i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int num = commands[i][2];
            
            int [] arr = Arrays.copyOfRange(array, start-1, end);
            Arrays.sort(arr);
            answer[i] = arr[num-1];
        }

        return answer;
    }
}