class Solution {
    static int answer = 0;
    public int solution(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			recursive(nums[i], nums, i, 0);
		}
		return answer;
	}
	// 모든 가지의 수 구하기
	public void recursive(int num, int[] nums, int i, int cnt) {
		cnt++;
		if (cnt == 3) {
			if (isPrime(num))
				answer++;
		} else if (cnt > 3) {
			return;
		} else {
			for (int j = i + 1; j < nums.length; j++) {
				recursive(num + nums[j], nums, j, cnt);
			}
		}
	}

	public boolean isPrime(int num) { 
		if (num == 0 || num == 1)
			return false; 
		int lim = (int) Math.sqrt(num); 

		for (int i = 2; i <= lim; i++)
			if (num % i == 0)
				return false;

		return true;
	}
}