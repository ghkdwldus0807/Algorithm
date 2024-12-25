class Solution {
    
    public int[] max(int[][] sizes){
        int max_w = 0;
        int max_h = 0;
        
        for(int i=0; i<sizes.length; i++){
            if(max_w<sizes[i][0])
                max_w = sizes[i][0];
            
            if(max_h<sizes[i][1])
                max_h = sizes[i][1];
            
        }
        int [] ans ={max_w,max_h} ;
        return ans;
    }
    
    public int solution(int[][] sizes) {
        int answer = 0;
        //1.인덱스 0 = 긴 길이, 인덱스 1 = 짧은 길이
        for(int i=0; i<sizes.length; i++){
            int temp = 0;
            if(sizes[i][0]<sizes[i][1]){
                temp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = temp;
            }
        
        }
        int [] result = max(sizes);
        
        answer = result[0]*result[1];
        
        return answer;
    }
}