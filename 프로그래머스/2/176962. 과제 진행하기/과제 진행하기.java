import java.util.*;

class Solution {
    
    class Work implements Comparable<Work> {
        String name;
        int min, duration;
        
        public Work(String name, int min, int duration){
            this.name = name;
            this.min = min;
            this.duration = duration;
        }
        
        @Override
        public int compareTo(Work o){
            return this.min-o.min;
        }
    }
    
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        PriorityQueue<Work> pq = new PriorityQueue<>();
        Stack<Work> stack = new Stack<>(); //멈춘 과제들 
        
        for(int i=0; i<plans.length; i++){
            String name = plans[i][0];
            String [] temp = plans[i][1].split(":");
            int h = Integer.parseInt(temp[0]);
            int m = Integer.parseInt(temp[1]);
            int d = Integer.parseInt(plans[i][2]);
            pq.add(new Work(name, h*60 + m, d));
        }
        
        int currentTime = 0;
        int index = 0;
        
        while(!pq.isEmpty()){
            
            Work current = pq.poll();
            currentTime = current.min;
            Work next = pq.peek();
            if(pq.isEmpty()){
                next = new Work("last",current.min+current.duration, 0); //마지막 더미 데이터 
            }
            
            
            //다음 과제 시작 시간 전에 현재 과제를 못 끝낼 경우
            if(current.min+current.duration>next.min){
                stack.add(new Work(current.name,current.min,currentTime + current.duration - next.min));
                continue;
            }
            else if (current.min + current.duration == next.min){
                answer[index] = current.name;
                index++;
                continue;
            }
            else {
                answer[index] = current.name;
                index++;
                int remain = next.min - (current.min + current.duration) ;
                while(!stack.isEmpty() && remain>0){
                    Work paused = stack.pop();
                    
                    if(paused.duration<=remain){
                        answer[index] = paused.name;
                        index++;
                        remain -= paused.duration;
                    }
                    else{
                        paused.duration -= remain;
                        stack.add(paused);
                        remain = 0;
                    }
                }
            }
            
        }
        
        //남은 거 처리
        while(!stack.isEmpty()){
            Work w = stack.pop();
            answer[index] = w.name;
            index++;
        }
        
        
        return answer;
    }
}
