class Solution {
    public int[] solution(int brown, int yellow) {
        		int[] answer = new int[2];
		int num = brown + yellow;

		
		for (int i = 1; i <= num; i++) {
			int arr[] = new int[2];
			if (num % i != 0) continue;
			
			arr[0] = i;
			arr[1] = num / i;
			
			if ((arr[0] - 2) * (arr[1] - 2) == yellow) {
				answer[0] = arr[0];
				answer[1] = arr[1];
			}
		}
		return answer;
    }
}