class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        //1. left 일 경우 
        if (direction.equals("left")){
            for(int i=0; i<numbers.length; i++){
                if(i==numbers.length-1)
                    answer[numbers.length-1] = numbers[0];
                else
                    answer[i] = numbers[i+1];
            }
        }else{ //2. right 일 경우 
            for(int i=0; i<numbers.length; i++){
                if(i==0)
                    answer[i] = numbers[numbers.length-1];
                else
                    answer[i] = numbers[i-1];
            }
            
        }
        
        return answer;
    }
}