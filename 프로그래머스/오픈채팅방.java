import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    public String[] solution(String[] record) {
		List<String> lst = new ArrayList<String>();
		Map<String, String> map = new HashMap<String, String>();

		for (String item : record) {
			String[] strArr = item.split(" ");

			if (strArr[0].equals("Enter")) {
				map.put(strArr[1], strArr[2]);
			} else if (strArr[0].equals("Change")) {
				map.put(strArr[1], strArr[2]);
			}
		}
		for (String item : record) {
			String[] strArr = item.split(" ");

			if (strArr[0].equals("Enter")) {
				lst.add(map.get(strArr[1]) + "님이 들어왔습니다.");
			} else if (strArr[0].equals("Leave")) {
				lst.add(map.get(strArr[1]) + "님이 나갔습니다.");
			}
		}

		return lst.stream().toArray(String[]::new);
    }
}