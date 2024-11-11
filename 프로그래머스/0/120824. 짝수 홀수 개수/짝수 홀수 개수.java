import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        
        Arrays.stream(num_list).forEach(n->{
            if(n%2==0)
                answer[0]+=1;
            else
                answer[1]+=1;
        });
        return answer;
    }
}