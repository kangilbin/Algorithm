import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int result : priorities) {
        	queue.add(result);
        }
        while(!queue.isEmpty()) {
        	for (int i = 0; i < priorities.length; i++) {
        		 if (priorities[i] == queue.peek()) {
        			 if(location == i) {
        				 answer++;
        				 return answer;
        			 }
        			 answer++;
        			 queue.poll();
        		 }
        	}
        }
        return answer;
    }
}