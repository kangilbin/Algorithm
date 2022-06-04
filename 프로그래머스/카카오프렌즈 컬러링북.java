class Solution {
    static int maxSizeOfOneArea ;
	static int numberOfArea;
	static int cnt;
    public int[] solution(int m, int n, int[][] picture) {
        maxSizeOfOneArea = 0;
        numberOfArea = 0;
        cnt = 0;
        
        int[][] board = new int[m][n];
        for(int i =0;i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = picture[i][j];
            }
        }
       
		int[] answer = new int[2];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != 0) {
					board = dfs(i, j, board, board[i][j]);
					maxSizeOfOneArea = Math.max(cnt, maxSizeOfOneArea);
					cnt = 0;
					numberOfArea++;
				}
			}
		}
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	public static int[][] dfs(int i, int j, int[][] board, int num) {
		int[] nX = { -1, 0, 0, 1 };
		int[] nY = { 0, -1, 1, 0 };
		board[i][j] = 0;
		cnt++;
		for (int x = 0; x < nX.length; x++) {
			int rX = nX[x] + i;
			int rY = nY[x] + j;
			if (board.length > rX && rX >= 0 && rY >= 0 && board[i].length > rY) {
				if (board[rX][rY] == num) {
					board = dfs(rX, rY, board, num);
				}
			}
		}
		return board;
	}
}