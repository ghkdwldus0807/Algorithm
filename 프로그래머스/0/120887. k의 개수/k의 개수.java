class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        String result ="";
        
        for(int x=i; x<=j; x++){
            result+= x;
        }
        String k_str = String.valueOf(k);
        result = result.replaceAll("[^"+k_str+"]","");
        answer = result.length();
        return answer;
    }
}