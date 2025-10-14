import java.util.*;

class Solution {
    
    static int [][][] dp; //y,x,d
    //dp[y][x][d] = y,x 좌표에 d방향으로 접근했을 경우의 최소비용
    static int [] dx = {0,0,-1,1}; //상하 좌우
    static int [] dy = {-1,1,0,0};
    static int [] dd = {0,0,1,1};
    
    
    public int solution(int[][] board) {
        int answer = 0;
        
        dp = new int [board.length][board.length][2];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                dp[i][j][0] = Integer.MAX_VALUE;
                dp[i][j][1] = Integer.MAX_VALUE;
            }
        }
        
        dp[0][0][0] = 0;
        dp[0][0][1] = 0;
        
        
        bfs(board,0);
        bfs(board,1);
        
        int n = board.length;
        
        return Math.min(dp[n-1][n-1][0], dp[n-1][n-1][1]);
    }//main
    
    static void bfs (int[][] board, int direction){
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0,0,direction});
        
        while(!queue.isEmpty()){
            int [] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            int dir = cur[2];
            
            for(int i=0; i<4; i++){
                int nextY = y+dy[i];
                int nextX = x+dx[i];
                int nextDir = dd[i];
                
                if(nextY<0 || nextY>=board.length || nextX<0 || nextX>=board.length){
                    continue;
                }
                
                if(board[nextY][nextX] == 1){
                    continue;
                }
                
                int cost = 0;
                
                if(isChange(dir,nextDir)){
                    cost = dp[y][x][dir] + 600;
                }
                else{
                    cost = dp[y][x][dir] + 100;
                }
                
                if(cost <= dp[nextY][nextX][nextDir]){
                    dp[nextY][nextX][nextDir] = cost;
                    queue.offer(new int[]{nextY, nextX, nextDir});
                }
            }
            
        }
        
    }//bfs
    
    //방향 바꾸는지 안바꾸는지
    static boolean isChange(int dir, int nextDir){
        if(dir == nextDir){
            return false;
        }
        
        return true;
    }
    
}

/*
다익스트라? bfs??

단순 최소 경로 X 최소비용



*/