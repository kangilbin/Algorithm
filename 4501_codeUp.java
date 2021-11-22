import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main{
   	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer arr[] = new Integer[7];
		for(int i=0; i<7; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr, Comparator.reverseOrder());
		
		int i = 0;
		for(int result : arr) {
			if(i < 2) System.out.println(result);
			
			i++;
		}
   	}
}

