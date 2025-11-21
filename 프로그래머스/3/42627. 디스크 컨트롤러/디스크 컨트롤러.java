import java.util.*;
import java.io.*;

class Solution {
    
    class Disk implements Comparable<Disk>{
        int id, requestTime, duration;
        public Disk(int id, int requestTime, int duration){
            this.id = id;
            this.requestTime = requestTime;
            this.duration = duration;
        }
        
        @Override
        public int compareTo (Disk o){
            if(o.duration == this.duration){
                if(o.requestTime == this.requestTime){
                    return this.id - o.id;
                }
                return this.requestTime - o.requestTime;
            }
            return this.duration - o.duration;
        }
    }
    
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<Disk> ready = new PriorityQueue<>();
        Arrays.sort(jobs, (a,b)->(a[0]-b[0]));
        
        int currentTime = 0;
        int count = 0;
        int index = 0;
        
        while(count<jobs.length){ 
             // 1. 현재 시간까지 도착한 job들 PQ에 넣기
            while(index<jobs.length && currentTime>=jobs[index][0]){
                ready.add(new Disk(index, jobs[index][0], jobs[index][1]));
                index++;
            }
            // 2. PQ가 비어 있으면 -> 다음 요청 시간으로 점프
            if(ready.isEmpty()){
                currentTime = jobs[index][0];
                continue;
            }
            // 3. 하나만 꺼내서 처리
            Disk currentDisk = ready.poll();
            currentTime += currentDisk.duration;
            answer += (currentTime-currentDisk.requestTime);
            count++;
        }
        
    
        return answer/jobs.length;
    }
}