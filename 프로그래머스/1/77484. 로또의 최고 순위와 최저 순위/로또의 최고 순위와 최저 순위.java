class Solution {
    
    public int getZero(int[] lottos){
        int zeroNum = 0;
        for(int i : lottos){
            if(i==0)
                zeroNum+=1;
        }
        return zeroNum;
        
    }
    
    public int getRate(int num){
        if(num==0)
            return 6;
        else 
            return 7-num;
    }

    
    public int[] solution(int[] lottos, int[] win_nums) {
        int minNum = 0 ; //최소 일치하는 숫자 개수 
        
        for(int lotto : lottos){
            for(int num : win_nums){
                if(lotto==num){
                    minNum+=1;
                    break;
                }else if(lotto==0)
                    break;
            }
        }
        
        int maxNum = getZero(lottos)+minNum; //최대 일치하는 숫자 개수 
        
        int[] answer = {getRate(maxNum),getRate(minNum)};
        
        return answer;
    }
}