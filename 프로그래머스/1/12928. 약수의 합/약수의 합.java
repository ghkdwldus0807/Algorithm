class Solution {
    public int solution(int n) {
        int sum = 0;
        for(int i = 1; i<n+1/2; i++){
            if(n%i == 0 ){
                sum = sum + i;
            }
        }
        int answer = sum+n;
        return answer;
    }
}