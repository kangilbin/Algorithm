package test;

import java.util.Arrays;

public class Main {
	static int answer = 0;
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}
	
	public static int solution(int[]numbers, int target) {
		dfs(numbers, 0, numbers.length, target);
        return answer;
    }
	public static void dfs(int[] numbers, int sum, int depth, int target) {
		if(depth == 0) { // 모든 경우의 수를 다 더한 경우
			if(sum == target) { // 더한 값이 타켓 값과 같은 경우
				answer++;
			}
			return;
		}
		int add = sum + numbers[depth];
		int minus = sum - numbers[depth];
		
		dfs(numbers, minus, depth-1, target); // 빼기
		dfs(numbers, add, depth-1, target); // 더하기
		
	}
	
}
