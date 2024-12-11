class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        
        int max,min = 0;
        
        if(sides[0]<sides[1]){
            max=sides[1];
            min=sides[0];
        }else{
            max=sides[0];
            min=sides[1];
        }

        
        //1. 가장 긴 변이 배열에 없을 때 
        //가장 긴 변은 다른 두 변의 길이의 합보다 작고, max보다 크거나 같아야한다. 
        
        answer += min;

        //2. 가장 긴 변이 배열에 있을 때 
        //될 수 있는 나머지 한 변은 max보다 작고 min보다는 커야한다.
        
        answer += (min-1);
        
        return answer;
    }
}