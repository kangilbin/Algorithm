package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		int k = 2;
		solution(id_list, report, k);
	}
	
	public static int[] solution(String[] id_list, String[] reports, int k) {
		int[] answer = new int[id_list.length];
		 Map<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
		 Map<String, Integer> idxMap = new HashMap<>();
	      for (int i = 0; i < id_list.length; i++) {
	            String name = id_list[i];
	            map.put(name, new HashSet<>());
	            System.out.println(name);
	            idxMap.put(name, i); // map으로 담길 때 순서대로 담기는게 아니라 무작위로 담기기 때문에 
	            					 // id의 인덱스를 담는다
	        }
		 
		 for(String report : reports) {
			 String[] str_rep = report.split(" ");
			 
			 map.get(str_rep[1]).add(str_rep[0]);
		 }
		 
		 for(String id : id_list) {
			 HashSet<String> send = map.get(id);
			 if(send.size() >= k) {
				 send.forEach(name -> {
					 answer[idxMap.get(name)]++; // 담아 두어던 인덱스를 이용하여 호출해 값을 하나씩 더한다
				 });
			 }
		 }

		 return answer;
	}
}
