package test;


public class Main {
	public static void main(String[] args) {
		int[] numbers = { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 };
		String hand = "left";
		System.out.println(solution(numbers, hand));
	}

	public static String solution(int[] numbers, String hand) {
		String answer = "";

		int[] leftIdx = {3, 0};
		int[] rightIdx = {3, 2};
		int[] nowIdx =  new int[2];
		for (int i = 0; i < numbers.length; i++) {
			nowIdx = chIdx(numbers[i]);
			if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				answer += "L";
				leftIdx = nowIdx;
			} else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				answer += "R";
				rightIdx = nowIdx;
			} else {
				if( Math.abs(nowIdx[0]-leftIdx[0]) + Math.abs(nowIdx[1]-leftIdx[1]) > Math.abs(nowIdx[0]-rightIdx[0]) + Math.abs(nowIdx[1]-rightIdx[1]) ) {
					answer += "R";
					rightIdx = nowIdx;
				} else if(  Math.abs(nowIdx[0]-leftIdx[0]) + Math.abs(nowIdx[1]-leftIdx[1]) == Math.abs(nowIdx[0]-rightIdx[0]) + Math.abs(nowIdx[1]-rightIdx[1]) ) {
					if(hand.equals("right")) {
						answer += "R";
						rightIdx = nowIdx;
					} else {
						answer += "L";
						leftIdx = nowIdx;
					}
				} else {
					answer += "L";
					leftIdx = nowIdx;
				}
			}
		}
		return answer;
	}

	public static int[] chIdx(int num){
		int[][] keyPad = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {11, 0, 11}};
		int[] reVal = new int[2];
		for(int i= 0; i<keyPad.length; i++) {                 
			for(int j= 0; j<keyPad[i].length; j++) {       
				if(keyPad[i][j] == num) {
					reVal[0] = i;
					reVal[1] = j;
					return reVal;
				}
			}
		}
		return reVal;
	}
}