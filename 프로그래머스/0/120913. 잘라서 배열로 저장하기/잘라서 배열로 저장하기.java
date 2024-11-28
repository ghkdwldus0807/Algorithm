import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        
        int arr_len = 0;
        
        if(my_str.length()%n ==0)
            arr_len= my_str.length()/n;
        else
            arr_len= (my_str.length()/n)+1;
        
        String[] answer = new String[arr_len];
        
        char[] ch_arr = my_str.toCharArray();
        
        for(int i=0; i<arr_len ; i++){
            String result = "";
            if(i==arr_len-1){
                for(int j=i*n; j<my_str.length(); j++){
                    result+=ch_arr[j];
                }
            }else{
                for(int j=i*n; j<(i+1)*n; j++){
                    result+=ch_arr[j];
                }
            }
            answer[i] = result;
        }
        
        return answer;
    }
}