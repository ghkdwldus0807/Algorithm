import java.util.*;

class Solution {
    public String solution(String polynomial) {
        String answer = "";
        String[] result = polynomial.split(" ");
        
        int lc = 0; //일차항 계수
        int cs = 0; //상수
        
        for(String str:result){
            if(str.endsWith("x")){
                str = str.replaceAll("[^0-9]","");
                if(str.isEmpty()){
                    lc += 1;
                }else
                    lc += Integer.parseInt(str);
            }else if(str.equals("+")){
                continue;
            }else
                cs += Integer.parseInt(str);
        }
        
       //answer 반환 조건
        //1. 일차항이 >1, 1일때, 없을때,
        //2. 일차항이 없고 상수만 있을 경우, 일차항만 있을 경우 
        
        if(lc !=0){
            if(lc ==1){
                answer+="x";
            }else
                answer += lc+"x";
        }
        
        
        if(cs>0){
            if(answer.isEmpty()){
                answer+=cs;
            }else{
                answer+=" + "+cs;
            }
        }
        

        return answer;
    }
}