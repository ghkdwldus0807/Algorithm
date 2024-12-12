class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        
        for(String str : dic){
            int result = 0;
            for(String sp : spell){
                if(str.indexOf(sp)==-1){
                    result += -1;
                }else{
                    result +=1;
                }
            }
            if(result==spell.length){
                answer = 1; 
                break;
            }
            
        }
        return answer;
    }
}