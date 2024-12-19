class Solution {
    public String solution(String bin1, String bin2) {
        String answer = "";
        
        //1. bin1, bin2 -> 10진수로 변환 
        int a = Integer.parseInt(bin1,2);
        int b = Integer.parseInt(bin2,2);
        //2. 덧셈 후 다시 2진수로 변환 
        answer = Integer.toBinaryString(a+b);
        return answer;
    }
}