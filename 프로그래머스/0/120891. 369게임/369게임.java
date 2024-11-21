class Solution {
    public int solution(int order) {
        int answer = 0;
        String str = String.valueOf(order);
        String result = str.replaceAll("[^369]","");
        
        answer = result.length();
        return answer;
    }
}