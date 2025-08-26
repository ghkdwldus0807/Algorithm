import java.util.*;


class Solution {
    
    static ArrayList<Integer> groups = new ArrayList<>();
    static int cardsNum = 0;
    static boolean[] visited;
    static int[] cards;
    static int cardsNumByGroup = 0;
    
    public int solution(int[] cards2) {
        
        cards = cards2;
        cardsNum = cards.length;
        visited = new boolean[cardsNum];
        
        //카드 그룹핑하기
        for(int i=0; i<cardsNum; i++){
            cardsNumByGroup = 0;
            
            if(visited[i]){
                continue;
            }
            dfs(i);
        }
        
        //각 그룹의 카드 개수 구하기
        //System.out.println(groups);
        //각 그룹의 첫번째, 두번째 최대 카드 개수 곱하기
        Collections.sort(groups);
        int maxIndex = groups.size();
        if(maxIndex == 0 || maxIndex== 1){
            return 0;
        }
        else{
            int answer = groups.get(maxIndex-1) * groups.get(maxIndex-2);
            return answer;
        }

    }

    public void dfs(int cardIndex){
        
        if(visited[cardIndex]){
            groups.add(cardsNumByGroup);
            return;
        }
        
        visited[cardIndex] = true;
        cardsNumByGroup ++;
        dfs(cards[cardIndex]-1);
    }
    
}