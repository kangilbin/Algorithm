import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main{
   	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int arr[] = new int[num];
		int arrClone[] = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			arrClone[i] = arr[i];	// 정렬 전에 값을 저장
		}
		Arrays.sort(arr);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i=0; i<num; i++) {
			map.put(arr[i],i);
		}
		for(int answer : arrClone) { 
		 System.out.print(map.get(answer)+" "); 
		}
   	}
}
