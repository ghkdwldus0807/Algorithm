class Solution {
    public int solution(String A, String B) {
        int answer = -1;
        int count = 0;
        if(A.equals(B))
            answer = 0;
        else{
            for(int i = 1; i<=A.length(); i++){
                if(A.equals(B))
                    break;
                else {
                    A = A.substring(A.length()-1)+A.substring(0,A.length()-1);
                    System.out.println(A);
                    answer = i ;
                }
            }
        }
        
        if(answer==A.length())
            answer = -1;
        
        return answer;
    }
}