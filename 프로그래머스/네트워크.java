package test;


public class Main {
	public static void main(String[] args) {
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int n = 3;
		System.out.println(solution(computers, n));
	}
	
	public static int solution(int[][] computers, int n) {
		boolean[] checks = new boolean[n];
		int answer = 0;
		for(int i=0; i<computers.length; i++) {
			if(!checks[i]) {
				dfs(computers, i, checks);
				answer++;
			}
		}
        return answer;
    }
	public static boolean[] dfs(int[][] computers, int i, boolean[] checks) {
		checks[i] = true;
		for(int j=0; j<computers.length; j++) {
			if(i!=j && computers[i][j] == 1 && checks[j] == false) {
				checks = dfs(computers, j, checks);
			}
		}
		return checks;
	}
	
}
