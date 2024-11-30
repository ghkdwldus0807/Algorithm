class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0,0};
        //1. board의 최대 최소 절댓값 구하기 
        
        int width = (board[0]-1)/2;
        int height = (board[1]-1)/2;
        
        //2. key input을 순회하며 위치 구하기, board 범위를 넘으면 무시 
        for(String key : keyinput){
            if(key.equals("left") && (answer[0]>-width)){
                answer[0] -=1;
            }else if(key.equals("right") && (answer[0]<width)){
                answer[0] +=1;
            }else if(key.equals("down") && (answer[1]>-height)){
                answer[1] -=1;
            }else if(key.equals("up") && (answer[1]<height)){
                answer[1] +=1;
            }

        }
        return answer;
    }
}