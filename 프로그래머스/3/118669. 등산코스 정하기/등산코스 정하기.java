import java.util.*;

class Solution {
    
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>(); 
    static int N;
    
    class Node implements Comparable<Node>{
        int v; // 도착지점
        int w; //가중치
        
        public Node (int v, int w){
            this.v = v;
            this.w = w;
        }
        
        @Override
        public int compareTo(Node o){
            return this.w - o.w;
        }
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        N = n;
        
        //그래프 초기화
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<paths.length; i++){
            
            int start = paths[i][0];
            int end = paths[i][1];
            int w = paths[i][2];
            
            if(isContain(start, summits)){
                graph.get(end).add(new Node(start, w));
                continue;
            }
            else if(isContain(end, summits)){
                graph.get(start).add(new Node(end, w));
                continue;
            }
            
            if(isContain(start, gates)){
                graph.get(start).add(new Node(end, w));
                continue;
            }
            else if(isContain(end, gates)){
                graph.get(end).add(new Node(start, w));
                continue;
            }
            
            graph.get(paths[i][0]).add(new Node(paths[i][1], paths[i][2]));
            graph.get(paths[i][1]).add(new Node(paths[i][0], paths[i][2]));                       
        }
        
        //게이트 -> 산봉우리 탐색 
        
        int [] visited = new int [n+1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(int gate : gates){
            pq.add(new Node(gate,0));
            visited[gate] = 0;
        }

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if (cur.w > visited[cur.v]){
                continue;
            }
            
            
            for(Node next : graph.get(cur.v)){
                int newIntensity = Math.max(cur.w, next.w);
                
                if(newIntensity < visited[next.v]){
                    visited[next.v] = newIntensity;
                    pq.add(new Node(next.v, newIntensity));
                }
            }
            
        }
        
        Arrays.sort(summits);
        
        int min = Integer.MAX_VALUE;
        int summitNum = 0;
        
        for(int summit : summits){
            if(visited[summit]<min){
                min = visited[summit];
                summitNum = summit;
            }
        }
        
        
        int[] answer = {summitNum, min};
        return answer;
    }//main 
    
    static boolean isContain(int n, int [] list){
        for(int i : list){
            if(n == i){
                return true;
            }
        }
        return false;
    }//isContain
    

}

/*
이론상 출입구에서 산봉우리로 가는 단방향만 구하면 된다 
최소 intensity, 산봉우리 번호는 최대한 낮은 숫자로
산봉우리는 한 번만 방문해야함



*/