package test;

import java.util.Arrays;

public class Main {
	static int[] parent;
	public static void main(String[] args) {
		int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
		System.out.println(solution(routes));
	}
	
	public static int solution(int[][] routes) {
		Arrays.sort(routes, (r1, r2) -> r1[1] - r2[1]);
		
		int answer = 0;
		int cam = Integer.MIN_VALUE;
		
		for(int[] result : routes) {
			if(cam < result[0]) {
				cam = result[1];
				answer++;
			}
		}
        return answer;
    }
	
}
