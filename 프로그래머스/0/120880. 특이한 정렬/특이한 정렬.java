import java.util.*;
import java.math.*;

class Solution {
    
    public int[] bubble_sort(int[] numlist,int n){
        for(int i=0; i<numlist.length-1; i++){
            for(int j=0; j<numlist.length-i-1 ; j++){
                int diff1 = Math.abs(numlist[j]-n);
                int diff2 = Math.abs(numlist[j+1]-n);
                
                if((diff1>diff2) || (diff1==diff2) && numlist[j]<numlist[j+1]){
                    int temp = numlist[j];
                    numlist[j] = numlist[j+1];
                    numlist[j+1] = temp; 
                }
            }
        }
        return numlist;
    }
    
    public int[] solution(int[] numlist, int n) {
        
        int [] answer = bubble_sort(numlist,n);
        
        return answer;
    }
}