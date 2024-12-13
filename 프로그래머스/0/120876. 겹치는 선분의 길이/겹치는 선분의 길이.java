import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        HashMap<Integer,Integer> result = new HashMap <Integer,Integer>();
        
        for(int i=0; i<3;i++){
            for(int j=lines[i][0]; j<lines[i][1];j++){
                result.put(j,result.getOrDefault(j,0)+1);
            }
        }
        
        for(int num : result.values()){
            if(num>1){
                answer += 1;
            }
        }
        
        
        return answer;
    }
}