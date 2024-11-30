import java.util.*;
import java.math.*;
class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int width1,width2 = 0;
        int height1, height2 = 0;
        //1. set로 지정해서 가로 세로 길이 구하기 
        Set<Integer> w = new HashSet<>();
        Set<Integer> h = new HashSet<>();
        
        for(int[] dot : dots){
            w.add(dot[0]);
            h.add(dot[1]);
        }
        
        List<Integer> wlist = new ArrayList<>(w);
        List<Integer> hlist = new ArrayList<>(h);
        
        answer = Math.abs(wlist.get(0)-wlist.get(1))*Math.abs(hlist.get(0)-hlist.get(1));
        
        return answer;
    }
}