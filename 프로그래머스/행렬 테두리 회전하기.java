class Solution {
    static int[][] arr;
    public int[] solution(int rows, int columns, int[][] queries) {		
        arr = new int[rows][columns];
		int[] answer = new int[queries.length];

		int num = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = num;
				num++;
			}
		}

		for (int i = 0; i < queries.length; i++) {
			answer[i] = rotation(queries[i]);
		}
		return answer;
    }
    // 회전
	public static int rotation(int[] item) {

		int x1 = item[0] - 1;
		int y1 = item[1] - 1;
		int x2 = item[2] - 1;
		int y2 = item[3] - 1;

		int next = arr[x1][y1];
		int min = next;
		for (int i = x1; i < x2; i++) {
			min = Math.min(min, arr[i][y1]);
			arr[i][y1] = arr[i + 1][y1];
		}

		int back = arr[x1][y2];
		for (int i = y2; i > y1; i--) {
			min = Math.min(min, arr[x1][i]);
			arr[x1][i] = arr[x1][i - 1];
		}
		arr[x1][y1 + 1] = next;

		next = arr[x2][y2];
		for (int i = x2; i > x1; i--) {
			min = Math.min(min, arr[i][y2]);
			arr[i][y2] = arr[i - 1][y2];
		}
		arr[x1 + 1][y2] = back;

		back = arr[x2][y1];
		for (int i = y1; i < y2; i++) {
			min = Math.min(min, arr[x2][i]);
			arr[x2][i] = arr[x2][i + 1];
		}
		arr[x2][y2 - 1] = next;

		return min;
	}
}