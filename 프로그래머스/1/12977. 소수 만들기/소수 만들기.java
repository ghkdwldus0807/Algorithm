import java.math.*;

class Solution {
    
    //1. 소수인지 아닌지 판별하는 함수
    
    public boolean isPrime (int num){
        for(int i =2; i<=Math.sqrt(num); i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    
    public int solution(int[] nums) {
        int answer = 0;
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1;j<nums.length-1; j++){
                for(int k=j+1;k<nums.length; k++){
                    int num = nums[i]+nums[j]+nums[k];
                    if(isPrime(num)){
                        answer +=1;
                    }
                }
            }
        }


        return answer;
    }
}