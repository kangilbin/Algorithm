package test;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		int[] a = {1,2};
		System.out.println(Arrays.stream(win_nums).anyMatch(num -> num == 31));
		//solution(lottos, win_nums);
	}
	
	public static int[] solution(int[] lottos, int[] win_nums) {
		 int[] answer = new int[2];
		 Boolean isTrue = true;
		 int maxCnt = 0;
		 int minCnt = 0;
		 for(int lotto : lottos) {
			 isTrue = Arrays.stream(win_nums).anyMatch(num -> num == lotto);
			 if(isTrue) {
				 maxCnt++;
				 minCnt++;
			 } else if(lotto == 0) {
				 maxCnt++;
			 }
		 }
		 answer[0] = maxCnt;
		 answer[1] = minCnt;
		 return answer;
	}
}
