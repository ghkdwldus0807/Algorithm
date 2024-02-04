class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        s=s.toLowerCase();
        
        int p_count = 0;
        int y_count = 0;
        
        for (int i = 0 ; i<s.length(); i++){
            if(s.charAt(i) == 'p'){
                p_count+=1;
            }else if(s.charAt(i)=='y'){
                y_count +=1;
            }
        }
        
        if(p_count!=y_count){
            answer=false;
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(answer);

        return answer;
    }
}