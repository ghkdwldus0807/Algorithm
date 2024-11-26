import java.util.*;
class Solution {
    public String[] solution(String[] quiz) {
        
        List<String> result = new ArrayList<String>();
        //1. 공백 기준으로 나눠서 배열에 저장 
        for (String str : quiz){
            String [] arr = str.split(" ");
            int int1 = Integer.parseInt(arr[0]);
            int int2 = Integer.parseInt(arr[2]);
            int int3 = Integer.parseInt(arr[4]);
            
            if(arr[1].equals("+")){
                if(int1+int2 ==int3)
                    result.add("O");
                else
                    result.add("X");  
            }else{
                if(int1-int2==int3)
                    result.add("O");
                else 
                    result.add("X");
            }
        }
        String[] answer = new String[result.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}