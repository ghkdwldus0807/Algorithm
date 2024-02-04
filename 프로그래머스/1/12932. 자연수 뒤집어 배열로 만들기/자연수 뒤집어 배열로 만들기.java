class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        
        String s = String.valueOf(n);
        int count = s.length();
        
        answer = new int[count];
        int i =0;
        
        while(n>0){
            
            answer[i] = (int)(n%10);
            n = n/10;
            i++;
        }
        
        return answer;
    }
}