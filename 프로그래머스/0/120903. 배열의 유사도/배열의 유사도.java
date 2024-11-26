import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        int s1_len = s1.length;
        int s2_len = s2.length;
        //1. 두 배열을 set로 만든다음 합친다. 
        Set<String> set1 = new HashSet<>(Arrays.asList(s1));
        Set<String> set2 = new HashSet<>(Arrays.asList(s2));
        
        Set<String> set = new HashSet<>();
        set.addAll(set1);
        set.addAll(set2);
        
        //2. set의 길이와 배열의 길이를 비교해서 중복 원소의 개수를 찾는다. 
        int set_size = set.size();
        answer = (s1_len+s2_len) - set_size;
        
        return answer;
    }
}