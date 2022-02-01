import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        List<Integer> tmp = new ArrayList<>();
        
        for(int i=0; i<genres.length; i++) {
        	map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(((o1, o2) -> map.get(o2.getKey()) - map.get(o1.getKey())));
        
        for(Map.Entry<String, Integer> entry : entryList){
            Map<Integer, Integer> mapIdx = new HashMap<Integer, Integer>();
        	for(int i=0; i<genres.length; i++) {
        		 if(entry.getKey().equals(genres[i])) {
        			 mapIdx.put(i,plays[i]);
        		 }
        	}
        	List<Integer> keyLists = new ArrayList<>(mapIdx.keySet()); 
        	keyLists.sort((s1, s2)->mapIdx.get(s2).compareTo(mapIdx.get(s1)));
        	int j=0;
        	for(Integer val : keyLists) {
        		if(j>1) break;  
        		
        		tmp.add(val);
        		j++;
        	}

        }
        int[] answer = new int[tmp.size()];
        for(int i = 0; i< tmp.size();i++){
            answer[i] = tmp.get(i);
        }
        return answer;
    }
}