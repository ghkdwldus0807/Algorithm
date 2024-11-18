import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        
        String only_num = my_string.replaceAll("[^0-9]","");
        
        int[] answer = Arrays.stream(only_num.split(""))
                    .mapToInt(Integer::parseInt).sorted().toArray();
        
        return answer;
    }
}