import java.util.Arrays;
class Solution {
    public int solution(int[] numbers) {
       	int answer = 0;
		int[] basicNum = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		for (int num : basicNum) {
			if (!Arrays.stream(numbers).anyMatch(s -> s == num))
				answer += num;
		}
		return answer;
    }
}