import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int width = maps.length;
        int height = maps[0].length;
        //상하좌우
        int [] dx = {0,0,-1,1};
        int [] dy = {1,-1,0,0};
        
        boolean[][] visit = new boolean [width][height];
        
        Queue<int[]> queue = new LinkedList<>();
        //출발 x, 출발 y, 거리 
        queue.add(new int[]{0,0,1});
        visit[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            
            if(x==width-1 && y==height-1){
                return distance;
            }
            for(int i = 0 ; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                if(nx<width && ny<height && nx>=0 && ny>=0 && maps[nx][ny]==1 && !visit[nx][ny]){
                    visit[nx][ny]=true;
                    queue.add(new int[]{nx,ny,distance+1});
                }
            }
        }
        return -1;
    }
}