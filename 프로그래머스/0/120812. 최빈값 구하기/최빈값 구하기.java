class Solution {
    public int solution(int[] array) {
        int[] ans = new int[1000];
        
        for(int i=0; i<array.length; i++){
            ans[array[i]] +=1;
        }
        
        int count=0;
        int max=0;
        int max2=ans[0];
        int answer2=0;
        int answer3 = 0;
        
        for(int j=0; j<1000; j++) {
            if (ans[j]>max){
                max2 = max;
                max = ans[j];
                answer2 = j;
            }
        }
        int answer = 0;
        
        for (int j=0; j<1000;j++){
            if (j==answer2){
                continue;
            }else {
                if(ans[j]==ans[answer2]){
                    answer=-1;
                    break;
                }
                
            }
        }
        
        if (answer!=-1){
            answer =answer2;
        }
        
        
        return answer;
    }
}