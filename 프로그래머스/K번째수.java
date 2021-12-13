import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i = 0;
        for(int[] result : commands) {
            int[] scopeArr = Arrays.copyOfRange(array, result[0]-1, result[1]); 
            Arrays.sort(scopeArr);

            answer[i] = scopeArr[result[2]-1];
            i++;
        }
        return answer;
    }
}