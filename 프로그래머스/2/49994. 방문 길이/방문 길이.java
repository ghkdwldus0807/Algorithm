import java.util.*;

class Solution {
    
    static boolean [][][] visited = new boolean [11][11][4]; //y, x, 방향 
    static final int UP = 0;
    static final int DOWN = 1;
    static final int RIGHT = 2;
    static final int LEFT = 3; 
    
    public int solution(String dirs) {
        
        String [] commands = dirs.split("");
        
        int y = 5;
        int x = 5;
        
        for(int i=0; i<commands.length; i++){
            int [] coor = go(commands[i],y,x);
            y = coor[0];
            x = coor[1];
        }
        int answer = 0;
        
        for(int i=0; i<11; i++){
            for (int j=0; j<11; j++){
                for(int k=0; k<4; k++){
                    if(visited[i][j][k]){
                        //System.out.println("i : "+i + " j : "+ j + " k : " + k);
                        answer ++;
                    }
                }
            }
        }
        
        return answer/2;
    }//sol
    
    public static int[] go(String command, int y, int x){
        int nextY = y;
        int nextX = x;
        int curDir, nextDir = -1;
        
        if(command.equals("L")){
            nextX = x-1;
            curDir = LEFT;
            nextDir = RIGHT; 
        }
        else if(command.equals("R")){
            nextX = x+1;
            curDir = RIGHT;
            nextDir = LEFT;
        }
        else if(command.equals("U")){
            nextY = y-1;
            curDir = UP;
            nextDir = DOWN;
        }
        else{
            nextY = y+1;
            curDir = DOWN;
            nextDir = UP; 
        }
        
        if(isEnabled(nextY, nextX)){
            visited[y][x][curDir] = true;
            visited[nextY][nextX][nextDir] = true;
            return new int [] {nextY, nextX};
        }
        
        return new int [] {y,x};
        
    }//go 
    
    //좌표가 유효한지 아닌지 
    public static boolean isEnabled(int y, int x){
        
        if(x<0 || x>10 || y<0 || y>10){
            return false;
        }
        return true;
    }//isEnabled
    
    
}

