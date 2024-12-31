import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        //1. 해시맵 이용 -> 각 스테이지 도전자 수 및 아직 클리어하지못한 사용자 수 카운트
        //key : stage , value : 도전자 수, 클리어 못한 사람 수 
        
        HashMap <Integer,Integer> users = new HashMap<>(); //도전자 수 
        HashMap <Integer,Integer> noClear = new HashMap<>();
        
        for(int stage : stages){
            for(int i = 1; i<=stage; i++){
                users.put(i,users.getOrDefault(i,0)+1);
            }
            noClear.put(stage,noClear.getOrDefault(stage,0)+1);
        }
        
        //2. 실패율 계산
        double[][] failure = new double[N][2];
        
        for(int i=1; i<=N; i++){
            int userCount = users.getOrDefault(i,0);
            int noClearCount = noClear.getOrDefault(i,0);
            double failureRate = (userCount == 0 ) ? 0 : (double) noClearCount/userCount;
            
            failure[i-1][0] = i;
            failure[i-1][1] = failureRate; 
        }
        
        
        //3. 각 스테이지의 번호를 실패율의 내림차순으로 정렬
        
        Arrays.sort(failure, (a,b)->{
            if(a[1]!=b[1])
                return Double.compare(b[1],a[1]);
            else 
                return Integer.compare((int)a[0],(int)b[0]);
        });
        
        //4. 스테이지 번호만 담겨있는 배열 리턴 
    
        for(int i = 0 ; i<N; i++){
            answer[i] = (int) failure[i][0];
        }
        return answer;
    }
}