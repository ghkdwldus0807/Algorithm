/*
dfs를 이용하여 자식 노드 수 계산하여 n과 차이를 비교  -> 해당 간선을 끊는 효과 
*/
import java.util.*;

class Solution {
    int min,N;
    ArrayList<Integer>[] tree ;
    boolean [] visited ;
    
    public int solution(int n, int[][] wires) {
        int answer = -1;
        min = n;
        N = n;
        visited = new boolean [N+1];
        
        //1. 트리 만들기
        tree = new ArrayList [n+1];
        
        for(int i=1; i<=n; i++){
            tree[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires){
            int v1 = wire[0];
            int v2 = wire[1];
            
            tree[v1].add(v2);
            tree[v2].add(v1);

        }
        
        dfs(1);
        
        return min;
    }//sol
    
    public int dfs(int node){
        int cnt  = 1; 
        visited[node] = true;
        
        for(int child : tree[node]){
            if(visited[child]) continue;
            cnt += dfs(child);
        }
        
        min = Math.min(min, Math.abs(cnt - (N-cnt)));
        
        return cnt;
    }
}