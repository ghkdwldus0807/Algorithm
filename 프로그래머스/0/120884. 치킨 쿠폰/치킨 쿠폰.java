class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int cupon = 0; //나머지 쿠폰
        while((chicken/10)!=0){
            answer += chicken/10;
            cupon = chicken%10;
            chicken = chicken/10 + cupon;
        }
        return answer;
    }
}