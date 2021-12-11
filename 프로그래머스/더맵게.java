import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
         PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

         for(int result : scoville) {
             priorityQueue.add(result);
         }
         while(priorityQueue.peek() <= K) {
            if (priorityQueue.size() == 1) {
                return -1;
            }
             int first = priorityQueue.poll();
             int second = priorityQueue.poll();

             priorityQueue.add(first + (second * 2));
             answer++;
         }
         return answer; 
    }
}