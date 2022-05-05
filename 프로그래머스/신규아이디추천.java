package test;


public class Main {
	public static void main(String[] args) {
		String new_id = "=.=";
		
		System.out.println(solution(new_id));
	}
	
	public static String solution(String new_id) {
		 new_id = new_id.toLowerCase().replaceAll("[^\\w\\-.]", "")
				 .replaceAll("\\.{2,}", ".").replaceAll("^[.]|[.]$", "");
		 System.out.println(new_id);
		 if(new_id.length() >= 16) {
			 new_id = new_id.substring(0,15);
			 System.out.println(new_id);
		 } else if(new_id.length() <= 2) {
			 if(new_id.equals("")) {
				 new_id = "aaa";
			 } else {
				 String strAdd = new_id.substring(new_id.length() -1);
				 while(new_id.length() < 3) {
					 new_id += strAdd; 
				 }
			 }
		 }
		 System.out.println(new_id);
		 new_id = new_id.replaceAll("[.]$", "");
		 return new_id;
	}
}
