import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
		Arrays.sort(citations);
		int h = citations.length;
		for (int result : citations) {
			if (result >= h) {
				answer = h;
				break;
			}
			h--;
		}
		return answer;
    }
}