class Solution {
    public int solution(int n) {
        int answer = 0;
        while(true){
            answer+=1;
            if(n<=answer*7)
                break;
        }
        return answer;
    }
}