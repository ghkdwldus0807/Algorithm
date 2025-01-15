class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        boolean [] visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            visited[i] = true;
        }
        
        for(int i = 0; i<section.length; i++){
            visited[section[i]-1] = false;
        }
        
        for(int i=0; i<n; i++){

            if(visited[i]==false){
                for(int j=i; j<i+m && j<n; j++){
                    visited[j] = true;
                }
                answer +=1;
            }
        }
        
        return answer;
    }
}