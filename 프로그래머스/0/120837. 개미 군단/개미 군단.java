class Solution {
    public int solution(int hp) {
        int answer = 0;
        int rest = 0;
        
        //1. 장군개미 수 구하기
        answer = hp/5;
        rest = hp%5;
        //2. 병정개미 수 구하기
        answer = answer + rest/3;
        rest = rest%3;
        //3. 일개미 수 
        answer = answer + rest;
        return answer;
    }
}