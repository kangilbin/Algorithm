package test;

import java.util.Arrays;

public class Main {
	static int[] parent;
	public static void main(String[] args) {
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		int n	=	4;
		System.out.println(solution(costs, n));
	}
	
	public static int solution(int[][] costs, int n) {
		int answer = 0;
		
		Arrays.sort(costs, (int[] c1, int[] c2) -> c1[2] - c2[2]);
		
		parent = new int[n];
		
		for(int i=0; i<n; i++) {
			parent[i] = i;
		}
		
		for(int[] vetcor: costs) {
			int from = vetcor[0];
			int to = vetcor[1];
			int cost = vetcor[2];
			
			int fromParent = findParent(from);
			int toParent = findParent(to);
			
			// 부모가 같으면 선택 x
			if(fromParent != toParent) {
				answer += cost;
				parent[toParent] = fromParent;
			}
		}
        return answer;
    }
	
	public static int findParent(int node) {
		if(parent[node] == node) return node;
		return parent[node] = findParent(parent[node]);
	}
}
