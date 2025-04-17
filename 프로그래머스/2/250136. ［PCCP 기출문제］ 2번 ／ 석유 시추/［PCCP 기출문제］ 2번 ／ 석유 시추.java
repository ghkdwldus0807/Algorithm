import java.util.*;
import java.io.*;

class Solution {
    
    static int [] oilNum;
    static boolean [] rowVisited;
    static boolean [][] visited; 
    static int [] dx = {0,0,-1,1};
    static int [] dy = {1,-1,0,0};
    static int W, H;
    
    public int solution(int[][] land) {
        W = land[0].length;
        H = land.length;
        rowVisited = new boolean [W];
        visited = new boolean[H][W];
        oilNum = new int[W];

        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                
                if(!visited[i][j] && land[i][j] == 1 ){
                    int secNum = bfs(i,j,land);
                    for(int k=0; k<W; k++){
                        if(rowVisited[k]){
                            oilNum[k] += secNum;
                        }
                    }
                    
                    Arrays.fill(rowVisited, false);
                }
                
            }
        }//bfs
        
        int answer = -1;
        
        for(int n: oilNum){
            answer = Math.max(answer,n);
        }
        
        return answer;
    }
    
    //bfs 
    public int bfs(int y,int x, int [][] land){
        int num = 0;
        
        Queue<int []> queue = new ArrayDeque<>();
        
        visited[y][x] = true; 
        rowVisited[x] = true;
        queue.add(new int[]{y,x});
        
        while(!queue.isEmpty()){
            
            int [] current = queue.poll();
            int curY = current[0];
            int curX = current[1];
            
            num++;
            
            for(int i=0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                
                if(nextX>=0 && nextX<W && nextY>=0 && nextY<H){
                    
                    if(visited[nextY][nextX])
                        continue;
                    
                    if(land[nextY][nextX] == 1){
                        queue.add(new int[] {nextY, nextX});
                        visited[nextY][nextX] = true;
                        rowVisited[nextX] = true;
                    }
                    
                }
                
            }
            
        }
        
        return num;
        
    }//bfs
}