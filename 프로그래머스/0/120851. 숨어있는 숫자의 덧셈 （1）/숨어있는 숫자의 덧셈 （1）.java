class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String only_num = my_string.replaceAll("[^0-9]","");
        for(int i=0; i<only_num.length(); i++){
            answer += only_num.charAt(i)-'0';
        }
        return answer;
    }
}