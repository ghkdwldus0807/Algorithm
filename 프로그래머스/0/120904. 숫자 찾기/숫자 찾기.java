class Solution {
    public int solution(int num, int k) {
        int answer = Integer.toString(num).indexOf(Integer.toString(k));
        
        if(answer!=-1)
            answer+=1;
        
        return answer;
    }
}