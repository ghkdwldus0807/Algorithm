import java.util.*;

class Solution {
    public int solution(String my_string) {
        String result = my_string.replaceAll("[^0-9]"," ");
        String [] arr = result.split(" ");
        int answer = 0;
        
        
        if(arr.length > 0){
            for(String str: arr){
                if(!str.isEmpty())
                    answer += Integer.parseInt(str);
            }
            
        }

        return answer;
    }
}