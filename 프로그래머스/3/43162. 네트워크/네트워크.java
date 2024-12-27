class Solution {
    static boolean [] visited;
    
    public void dfs (int n, int start, int[][] computers){
        visited[start] = true;
        
        for (int i=0; i<n; i++){
            if(i==start)
                continue;
            else if(!visited[i] && computers[start][i]==1){
                dfs(n,i,computers);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean [n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(n,i,computers);
                answer ++;
            }
        }
        return answer;
    }
}