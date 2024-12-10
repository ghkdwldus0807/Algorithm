class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int len = board.length;
        int [][] result = new int[len+2][len+2];//기존 보드의 (0,0)은 result의 (1,1)
        
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(board[i][j]==1){
                    result[i][j] = 1;
                    result[i][j+1]=1;
                    result[i][j+2]=1;
                    result[i+1][j]=1;
                    result[i+1][j+1]=1;
                    result[i+1][j+2]=1;
                    result[i+2][j]=1;
                    result[i+2][j+1]=1;
                    result[i+2][j+2]=1;
                    
                }
            }
        }
        
        //result에서 board범위 만큼만 반복문 -> 0의 개수 찾기
        
        for(int i=1; i<len+1;i++){
            for(int j=1; j<len+1 ; j++){
                if(result[i][j]==0)
                    answer+=1;
            }
        }
        
        return answer;
    }
}

//사진과 같이 [2,2]에 지뢰 매설되어있다면, 위험지역은 
//[1,1] [1,2] [1,3]
//[2,1] [2,2] [2,3]
//[3,1] [3,2] [3,3]
// 즉 열과 행에 1을 더하고 뻰 민큼의 범위가 위험지역 