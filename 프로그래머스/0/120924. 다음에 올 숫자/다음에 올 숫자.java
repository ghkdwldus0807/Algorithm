class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int check = 0; //등차인 경우 1, 등비인 경우 2
        int d = 0;
        int len = common.length;
        //1. 등차 수열인지 등비 수열인지 확인
        if((common[1]-common[0]) == (common[2]-common[1])){
            check =1;
            d = common[1]-common[0];
        }else{
            check = 2;
            d = common[1]/common[0];
        }
        

        if(check==1){
            answer = common[len-1]+d;
        }else{
            answer = common[len-1]*d;
        }
        
        return answer;
    }
}