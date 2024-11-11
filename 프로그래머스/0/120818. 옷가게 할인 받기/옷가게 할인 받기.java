class Solution {
    public int solution(int price) {
        int answer = 0;
        double sale = 0;
        
        if(price>=500000)
            sale = 0.2;
        else if(300000<=price && price<500000)
            sale = 0.1;
        else if(100000<=price && price<300000)
            sale = 0.05;

        answer = (int)(price - price*sale);

        return answer;
    }
}