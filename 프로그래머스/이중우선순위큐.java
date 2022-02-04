import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
    	PriorityQueue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder()); // 큰 값
    	PriorityQueue<Integer> minQue = new PriorityQueue<>(); 							 // 작은 값
    	
    	for(String val : operations) {
    		StringTokenizer st = new StringTokenizer(val, " "); 
    		String type = st.nextToken();
    		int num = Integer.parseInt(st.nextToken());
    		if(type.equals("I")) {
    			maxQue.add(num);
    			minQue.add(num);
    		}
    		if(!minQue.isEmpty()) {
    			if(type.equals("D")) {
    				if(num == 1) { // 최대 값
    					int max = maxQue.peek();
    					maxQue.remove(max);
    					minQue.remove(max);
    				} else {      // 최소 값
    					int min = minQue.peek();
    					minQue.remove(min);
    					maxQue.remove(min);
    				}
    			}
    		}
    	}
    	if(!minQue.isEmpty()) {
    		answer[1] = minQue.peek();
    		answer[0] = maxQue.peek();
    	}
    	
        return answer;
    }
}