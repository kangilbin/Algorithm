import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main{
   	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int num = 1;
		boolean isTrue = true;
		int arr[][] = new int[N][M];
		for (int i = N - 1; 0 <= i; i--) {
			if (isTrue) {
				for (int j = M - 1; 0 <= j; j--) {
					arr[i][j] = num;
					num++;
					isTrue = false;
				}
			} else {
				for (int j = 0; j < M; j++) {
					arr[i][j] = num;
					num++;
					isTrue = true;
				}
			}
		}

		for (int[] A : arr) {
			for (int B : A) {
				System.out.print(B + " ");
			}
			System.out.println("");
		}
	}
}
