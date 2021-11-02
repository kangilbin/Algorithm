import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
public class Main{

   	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int arr[] = new int[3];

		for (int i = 0; i < 3; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}

		Arrays.sort(arr);

		for (int i : arr) {
			System.out.print(i + " ");
		}
   	}
}
