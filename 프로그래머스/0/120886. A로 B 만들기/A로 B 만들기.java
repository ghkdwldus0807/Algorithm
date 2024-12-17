class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        
        for(int i=0; i<before.length();i++){
            after = after.replaceFirst(String.valueOf(before.charAt(i)),"");
        }
        
        if(after.isEmpty())
            answer = 1;
        
        return answer;
    }
}