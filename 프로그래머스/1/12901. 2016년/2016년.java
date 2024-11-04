import java.util.*;
class Solution {
    public String solution(int a, int b) {
        List<String> week = new ArrayList<>(Arrays.asList("FRI","SAT","SUN","MON","TUE","WED","THU"));
        List<Integer> days = new ArrayList<>(Arrays.asList(31,29,31,30,31,30,31,31,30,31,30,31));
        int total=0;
        
        for(int i=0; i<a-1; i++){
            total += days.get(i);
        }
        total += b ;
        total = total%7;
        String answer ="";
        if ((total-1)==-1){
            answer="THU";
        }else{
            answer=week.get(total-1);
        }
        
        
        return answer;
    }
}