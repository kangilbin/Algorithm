package test;

import java.util.LinkedList;
import java.util.Queue;

public class Main{
   	public static void main(String[] args)  {
   		int[] prices = {1, 2, 3, 2, 3};
		System.out.println(solution(prices));

   	}
    public static int[] solution(int[] prices) {
    	int[] answer = {};
    	Queue<Integer> queue = new LinkedList<>();
    	for(int result : prices) {
    		queue.add(result);
    	}
    	int cnt = 1;
    	int num = 0;
    	while(!queue.isEmpty()) {
    		int val = queue.peek();
    		for(int i=cnt; i<prices.length;i++) {
    			if(val > prices[i]) {
    				System.out.println(i);
    				answer[num]= i;
    				queue.poll();
    				num++;
    				break;
    			} else {
    				if(i == prices.length-1) {
    					System.out.println(num+", "+i);
    					answer[num] = i;
    					num++;
    					queue.poll();
    					break;
    				}
    			}
    			cnt++;
    		}
    	}
    	
        return answer;
    }
}