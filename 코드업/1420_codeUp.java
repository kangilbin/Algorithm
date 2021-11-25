import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.Comparator;

public class Main{
   	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			int score = Integer.parseInt(st.nextToken());
			
			map.put(name, score);
		}
		
		// Map.Entry 리스트 작성
		List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(map.entrySet());

		// 비교함수 Comparator를 사용하여 오름차순으로 정렬
		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
			// compare로 값을 비교
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				// 오름 차순 정렬
				 if (obj1.getValue() < obj2.getValue()) {
			            return 1;
			        } else if (obj1.getValue() > obj2.getValue()) {
			            return -1;
			        }
			        return 0;
			}
		});
		int i=0;
		for(Entry<String, Integer> entry : list_entries) {
			if(i==2) {
				System.out.println(entry.getKey());
			}
			i++;
		}
	}
}
