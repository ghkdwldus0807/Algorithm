import java.util.*;

class Solution {
    
    static boolean [] width;
    static boolean [] left; //왼쪽 위로 올라가는 ㅐㄷ각선 
    static boolean [] right; //오른쪽 위로 올라가는 대각선 
    static int ans;
    static int N;
    
    public int solution(int n) {
        N = n;
        
        width = new boolean [N]; 
        left = new boolean[N*2];
        right = new boolean[N*2];
        
        dfs(0);
        
        return ans;
    }//sol
    
    public static void dfs(int y){
        
        if(y==N){
            ans ++;
            return;
        }
        

        for(int i = 0; i<N; i++){
            if(width[i] || left[Math.abs(i-(N-1)) + y] || right[i+y] ){
                continue;
            }

            width[i] = true; 
            left[Math.abs(i-(N-1)) + y] = true;
            right[i+y] = true;

            dfs(y+1);
            
            width[i] = false; 
            left[Math.abs(i-(N-1)) + y] = false;
            right[i+y] = false;
            


        }
    }

}

/*
- 백트래킹

퀸은 가로 세로 대각선 움직일 수 있다.

퀸을 놓을 떼 퀸이 움직일 수 있는 대각선 파악
왼쪽 위로 올라가는 대각선 => Math.abs(i-(n-1)) + y
오른쪽 위로 올라가는 대각선 => i+y;


*/