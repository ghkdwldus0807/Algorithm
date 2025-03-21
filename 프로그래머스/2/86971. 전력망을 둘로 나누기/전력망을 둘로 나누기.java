import java.util.*;


class Solution {
    
    static boolean [] visited;
    static ArrayList<Integer> [] tree ;
    static Queue<Integer> queue = new ArrayDeque<>();
    static int count = 0; 
    
    public int solution(int n, int[][] wires) {
        
        int answer = Integer.MAX_VALUE;
        tree = new ArrayList[n+1];
        visited = new boolean[n+1];
        
        for(int t=0; t<n-1; t++){
            
            for(int i=1; i<=n; i++){
                tree[i] = new ArrayList<Integer>();
            } // tree 초기화
            
            Arrays.fill(visited,false); //visited 초기화
            queue.clear();
            
            for(int i=0; i<n-1; i++){
                if(i == t) continue; //t번째 wire는 연결하지 않기 
                
                int v1 = wires[i][0];
                int v2 = wires[i][1];
                // 양방향 연결 
                tree[v1].add(v2);
                tree[v2].add(v1);
                
                
            }//tree 연결 
            
            for(int i=1; i<=n; i++){

                
                if(visited[i])
                    continue;
                else {
                    count = 0;
                    dfs(i);
                    queue.add(count);
                    
                }
                
            }//dfs 수행 
            
            int n1 = queue.poll();
            int n2 = queue.poll();
            answer = Math.min (Math.abs(n1-n2), answer);
            
        }

        
        return answer;
        
    }//메인
    
    
    //dfs 
    
    public void dfs(int start){
        
        visited[start] = true; 
        count ++; 
        
        for(int node : tree[start]){
            if(!visited[node]) 
                dfs(node);
        }
        

    }
    
    
    
}