package test;


public class Main {
	public static void main(String[] args) {
		String s = "aabbaccc";
		
		System.out.println(solution(s));
	}
	
    public static int solution(String s) {
        int len = s.length();

		for (int i = 1; i < s.length(); i++) {
			len = Math.min(len, compress(s, i, 0, i).length());
			System.out.println(compress(s, i, 0, i));
		}
		
		return len;
    }
    public static String compress(String s, int end, int start, int i) {
		String pattern = s.substring(start, end);
		int count = 1;
        String req = "";
        
		for (int j = end; j < s.length(); j += i) {
			if (j + i <= s.length()) {
				if (pattern.equals(s.substring(j, j + i))) {
					count++;
				} else {
					if (count == 1) {
						return pattern + compress(s, j + i, j, i);
					} else {
						return count + pattern + compress(s, j + i, j, i);
					}
				}
			} else {
				if (count == 1) {
					return pattern + s.substring(j, s.length());
				} else {
					return count + pattern + s.substring(j, s.length());
				}
			}
		}
		if (count == 1) {
			return pattern ;
		} else {
			return count + pattern;
		}
	}
}
