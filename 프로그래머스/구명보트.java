import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
       Arrays.sort(people);
		int answer = 0;
		int lst_idx = people.length-1;
		int now_idx = 0;
		while(now_idx <=lst_idx) {
			if(people[now_idx]+people[lst_idx] <= limit) {
				now_idx++;
				lst_idx--;
			} else {
				lst_idx--;
			}
			answer++;
		}
		
        return answer;
    }
}