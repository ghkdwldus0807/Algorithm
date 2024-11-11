
class Solution {
    public String solution(String my_string, int n) {
        StringBuilder answer2 = new StringBuilder("");
        
        my_string.chars().forEach(i ->{
            answer2.append(String.valueOf((char)i).repeat(n));
        });
        
        String answer = answer2.toString();
        
        return answer;
    }
}