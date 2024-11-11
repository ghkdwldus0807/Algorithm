class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        double totalSum = 0;
        for (int i=0; i<numbers.length; i++){
            totalSum+=numbers[i];
        }
        answer = totalSum/numbers.length;
        return answer;
    }
}