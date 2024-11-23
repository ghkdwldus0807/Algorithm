import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        Map<Character,Integer> count = new TreeMap<Character,Integer>(); 
        
        //1. string의 각 문자를 tree map의 key로 지정하고 value는 0으로 초기화 
        
        for (char c: s.toCharArray())
            count.put(c,0);
        
        //2. string을 순회하며 count
        for (char c: s.toCharArray()){
            count.put(c,count.get(c)+1);
        }
        
        //3. value가 1인 key만 문자열에 추가 
        for (Map.Entry<Character,Integer> entry : count.entrySet()){
            if(entry.getValue()==1)
                answer+=entry.getKey();
        }

        return answer;
    }
}