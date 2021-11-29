package test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
public class Main{
   	public static void main(String[] args) throws IOException {
		int participant[] = {93, 30, 55};	
		int completion[] = {1, 30, 5};	
		solution(participant, completion);

   	}
    public static int[] solution(int[] progresses, int[] speeds) {
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
    	int[] answer =  new int[que.size()];
    	// 7 3 9
    	int com = 0;	//비교 값
    	boolean isTrue = true;
    	int add = 0;	
    	for(int result : que) {
    		if(isTrue) {
    			com = result;
    			isTrue = false;
    			add++;
    		}
    		if(com> result) {
    			add++;
    		} 
    		System.out.println(result);
    	}
        return answer;
    }
}


