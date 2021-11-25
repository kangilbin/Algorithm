import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main{
   	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int A = Integer.parseInt(br.readLine()); // 행
		int[][] arr = new int[A][A];
		int num = A; // 최초 값
		int B = A;
		boolean isTrue = true;
		for (int i = 0; i < B; i++) {
			if (!isTrue) {
				num = B * (i + 1);
				isTrue = true;
			}
			for (int j = 0; j < B; j++) {
				if (isTrue) {
					A = num;
				}
				arr[i][j] = A;
				A -= 1;
				isTrue = false;
			}
		}

		for (int[] result : arr) {
			for (int resultSub : result) {
				System.out.print(resultSub + " ");
			}
			System.out.println("");
		}

	}
}

	

