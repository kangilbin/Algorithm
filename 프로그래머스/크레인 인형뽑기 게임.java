package test;

import java.util.ArrayList;
import java.util.List;

public class Main {
	static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		int[][] board = {
							{0,0,0,0,0},
							{0,0,1,0,3},
							{0,2,5,0,1},
							{4,2,4,4,2},
							{3,5,1,3,1}
						};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println(solution(board, moves));
	}

	public static int solution(int[][] board, int[] moves) {
		
		for(int move : moves) {
			board = callback(board, move);
		}
		return dfs(0);
	}
	public static int dfs(int cnt) {
		for(int i=0; i<list.size()-1; i++){
			if(list.get(i) == list.get(i+1)) {
             	list.remove(i); 
             	list.remove(i);
             	cnt += 2;
             	
             	return dfs(cnt);
             } 
	    }
		return cnt;
	}
	public static int[][] callback(int[][] board, int num) {
			
		for(int i=0; i<board.length; i++) {
			if(board[i][num-1] != 0) {
				list.add(board[i][num-1]);
				board[i][num-1] = 0;
				
				return board;
			}
		}
		return board;
	}
}