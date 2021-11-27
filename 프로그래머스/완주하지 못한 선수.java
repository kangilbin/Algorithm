import java.util.HashMap;
import java.util.Map;
class Solution {
    public String solution(String[] participant, String[] completion) {
          String answer = "";
        Map<String,Integer> map = new HashMap<String,Integer>();

        for(String result : participant) {
            map.put(result, map.getOrDefault(result, 0) + 1);
        }
        for(String result : completion) {
            map.put(result, map.getOrDefault(result, 0) - 1);
        }
        for (String key : map.keySet()) {
            if (map.get(key) > 0){
                answer = key;
            }
        }
        return answer;
    }
}
