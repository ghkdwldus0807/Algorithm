class Solution {
    
    public int min(int a,int b){
        if(a>b)
            return b;
        else
            return a;
    }
    
    public int max(int a,int b){
        if(a>b)
            return a;
        else 
            return b;
    }
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while((min(wallet[0],wallet[1])<(min(bill[0],bill[1])))||(max(wallet[0],wallet[1])<(max(bill[0],bill[1])))){
            if(bill[0]>bill[1]){
                bill[0] = bill[0]/2;
            }else{
                bill[1]=bill[1]/2;
            }
            answer +=1;
        }
        return answer;
    }
}