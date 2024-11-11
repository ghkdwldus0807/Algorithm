class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = n/2;
        for(int i=1; i<=cnt; i++){
            answer+=2*i;
        }
        return answer;
    }
}