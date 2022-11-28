import java.util.stream.IntStream;
 
class Solution {
    public boolean solution(int N, int[] A, int[] B) {
        return dfs(N, A, B, 3, 1);
    }
    public boolean dfs(int N, int[] A, int[] B, int sum, int cnt) {
        if(N == cnt) return true;
        
        for(int i=0; i<A.length; i++){
            if(A[i]+B[i] == sum){
                A = remove(A, i);
                B = remove(B, i);
                return dfs(N, A, B, sum+2, ++cnt);
            }
        }
        return false;
    }
    public static int[] remove(int[] a, int index) {
        if (a == null || index < 0 || index >= a.length) {
            return a;
        }
 
        return IntStream.range(0, a.length)
                        .filter(i -> i != index)
                        .map(i -> a[i])
                        .toArray();
    }
}
