import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int [] sort_list = emergency.clone();
        
        Arrays.sort(sort_list);
        
        int[] answer = new int[emergency.length];
        
        for(int i=0; i<emergency.length; i++){
            for(int j=0; j<sort_list.length; j++){
                if(emergency[i]==sort_list[j]){
                    answer[i] = sort_list.length - j;
                    break;
                }
            }
        }
        
        return answer;
    }
}