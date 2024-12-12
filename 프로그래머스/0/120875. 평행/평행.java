import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        double x1,y1;
        int x2,y2 = 0;
        double d1,d2 = 0; //기울기 
        //경우의 수는 3가지가 있다. 
        //dots 배열에서 [1,2] [3,4] or [1,3] [2,4] or [1,4] [2,3]
        //나머지는 고려하지 않아도 된다. 
        Arrays.sort(dots,(a,b) -> Integer.compare(a[0],b[0]));
        int len = dots.length;
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                x1 = (double)dots[i][0];
                y1 = (double)dots[i][1];
                x2 = dots[j][0];
                y2 = dots[j][1];
                d1 = (y2-y1)/(x2-x1);
                
                for(int k=0; k<len; k++){
                    if(k==i || k==j)
                        continue;
                    for(int l=k+1; l<len; l++){
                        if(l==i || l==j)
                            continue;
                        x1 = (double)dots[k][0];
                        y1 = (double)dots[k][1];
                        x2 = dots[l][0];
                        y2 = dots[l][1];
                        d2 = (y2-y1)/(x2-x1);
                        
                        if(d1==d2){
                            answer = 1;
                        }
                    }
                        
                }
            }

        }
    
        return answer;
    }
}