import java.util.HashMap;
import java.util.Map;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer> map = new HashMap<String,Integer>();

        for(String[] resultA : clothes) {
            map.put(resultA[1], map.getOrDefault(resultA[1],0)+1);
        }

        for(String key : map.keySet()) {
            answer *= map.get(key) + 1; 
        }
        return answer-1;
    }
}
