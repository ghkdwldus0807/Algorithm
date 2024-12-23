import java.util.*;

class Solution {
    //연속해서 같은 숫자가 있는지 확인하는 method
    public boolean checkCon(String str,int index){
        if(str.charAt(index)==str.charAt(index+1))
            return true;
        else 
            return false;
    }
    public int solution(String[] babbling) {
        int answer = 0;
        String[] pron = {"aya","ye","woo","ma"};
        int len = babbling.length;
        //1. babbling 반복문 돌기, -> replace 순서대로 0,1,2,3
        
        for(int i=0; i<len; i++){
            for(int j=0; j<4; j++){
                babbling[i] = babbling[i].replace(pron[j],String.valueOf(j));
            }
        }
        
        System.out.println(Arrays.toString(babbling));
        
        for(int i=0; i<len; i++){
            //문자가 포함되어있을 경우 
            if(!babbling[i].matches("\\d+"))
                continue;
            else if(babbling[i].matches("\\d+")&&babbling[i].length()==1){
                answer += 1;
                continue;
            }
            //2자 이상 정수문자열로만 이루어질 경우 
            for(int j=0;j<babbling[i].length()-1;j++){
                if(checkCon(babbling[i],j))
                    break;
                else if(!checkCon(babbling[i],j)&&j==babbling[i].length()-2)
                    answer += 1;
            }
        }
        return answer;
    }
}