import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String [] prons = {"aya","ye","woo","ma"}; //가능한 발음
        
        for(int i=0; i<babbling.length; i++){
            for(String pron : prons ){
                babbling[i] = babbling[i].replaceFirst(pron,"1");
            }
        }
        
        System.out.println(Arrays.toString(babbling));
        
        for(String str:babbling){
            for(int i = 0 ; i<str.length(); i++){
                if((str.charAt(i)-'0') != 1){
                    break;
                }else if(((str.charAt(i)-'0') == 1)&&(i==str.length()-1))
                    answer +=1;
            }
        }
        
        return answer;
    }
}