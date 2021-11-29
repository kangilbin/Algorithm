import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> que = new LinkedList<>();
        int time;
        for(int i=0; i<progresses.length; i++) {
            int cnt=1; 
            time = 100 - progresses[i];
            while(time > 0) {
                time -= speeds[i];
                cnt++;
            }
            que.add(cnt-1);
        }
         List<Integer> result = new ArrayList<Integer>();
         int standard = que.poll();
         int add = 1;
         while(!que.isEmpty()) {
             int num = que.poll();
             if(standard >= num) {
                 add++;
             }else {
                 result.add(add);
                 add = 1;
                 standard = num;
             }
         }
         result.add(add);
         int[] answer =  new int[result.size()];
         for(int i = 0; i < answer.length; i++){
             answer[i] = result.get(i);
         }
        return answer;
    }
}
