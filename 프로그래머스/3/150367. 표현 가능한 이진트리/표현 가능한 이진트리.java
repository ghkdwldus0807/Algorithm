import java.util.*;
import java.math.*;

/*
pseudo code 

기본 개념 : 높이가 d인 포화이진트리의 노드 수 = 2^(d+1) - 1 ; 

1. 숫자 N을 이진수로 변환했을 때의 길이가 2^(d+1)-1에 해당하는데, 만약 그 자체로 이진트리가 된다면 바로 1 
2. 이진수 길이가 포화이진트리의 노드 수에 해당하지 않는 경우, 2^(d+1)-1이면서 length 이상인 "최소"노드 개수를 구하고 
그게 되도록 앞에 0을 채워넣기... 
3. 2번에서 만든 트리가 포화이진트리가 되는지 확인 

*/

class Solution {
    
    static StringBuilder tree; //이진수 트리 저장 
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            long num = numbers[i];
            tree = new StringBuilder(); 
            tree.append(Long.toBinaryString(num));
            int len = tree.length();
            
            //(1) 초기 트리가 포화이진트리인 경우 바로 판단 
            if(isBinaryTree(num, tree)){
                answer[i] = 1; 
                continue;
            }
            
            //(2-1) 포화이진트리의 최소 노드 개수 구하기 
            long minNodeNum = getMinNodeNum(tree);
            
            //(2-2) 최소 노드 개수와의 차만큼 앞에 0 채우기 
            for(long j=0; j<minNodeNum-len; j++){
                tree.insert(0,0);
            }
            
            len = tree.length(); //update
            
            //(3) 포화이진트리가 만들어지는지 확인 
            if(isFullTree(tree,0,len-1)){
                answer[i] = 1;
            }
        }//for 
        
        return answer;
    }//main 
    
    //포화이진트리인지 확인하는 메서드 (고치기 )
    public boolean isFullTree(StringBuilder tree, int left, int right){
        //마지막 서브트리인 경우
        if(left>right)
            return true; 
        
        int mid = (left+right)/2;
        int leftMid = (left+mid-1)/2; //mid(root)의 바로 왼쪽 자식
        int rightMid = (mid+1+right)/2; //mid의 바로 오른쪽 자식 
        
        //부모 노드가 0인데 자식트리가 1인 경우 
        if(tree.charAt(mid) == '0'){
            if((left<=mid-1) && tree.charAt(leftMid) == '1' || (right>=mid+1)&&tree.charAt(rightMid) == '1'){
                return false;
            }
        }
        
        return isFullTree(tree,left,mid-1) && isFullTree(tree,mid+1,right); 
    }
    
    //포화이진트리 최소 노드 개수 구하는 메서드
    public long getMinNodeNum (StringBuilder tree){
        
        long treeLen = tree.length();
        long cnt = 0; 
        long min = 0; //최소 노드 개수
            
        while(true){
            min = (1<<cnt)-1;
            
            if(min>=treeLen)
                return min; 
            
            cnt ++;
        }
    }//getMinNodeNum
    
    //초기 이진수의 길이가 2^(d+1)-1에 해당하는지 판단하는 메서드
    public boolean isBinaryTree(long num, StringBuilder init){
        long len = init.length();
        if((len & (len+1)) == 0){ 
            if(isInitBinaryTree(num,len))
                return true;
        }
        return false;
    }//is Binary Tree
    
    //그 자체로 이진트리가 되는지 판단하는 메서드 
    public boolean isInitBinaryTree(long num, long len){
        return Long.bitCount(num) == len;
    }
}