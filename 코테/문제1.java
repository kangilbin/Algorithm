package test;

import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		String S = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
		String C = "Example";
		System.out.println(solution(S, C));
	}

	public static String solution(String S, String C) {
		HashSet<String> hashSet = new HashSet<String>();
		String answer = "";
		String email = "";
		C = C + ".com";
		String[] strArrNm = S.split(", ");
		for(String strNm : strArrNm) {
			String[] strFm = strNm.split(" ");
			strFm[0] = strFm[0].replaceAll("-", "");

		
			if(strFm.length > 2) {
				email = String.valueOf(strFm[0].charAt(0)).toLowerCase() 
						+ String.valueOf(strFm[1].charAt(0)).toLowerCase() + strFm[2].toLowerCase().replaceAll("-","");
				if(email.length()>8) {
					email = email.substring(0,10);
				}
				
				if(hashSet.contains(email)) {
					email = reEmail(email, hashSet, 2);
				}
				hashSet.add(email);
				
				answer += strNm + " <" + email +"@" + C.toLowerCase() + ">, ";
			} else {
				email = String.valueOf(strFm[0].charAt(0)).toLowerCase() + strFm[1].toLowerCase();
				if(email.length()>8) {
					email = email.substring(0,10);
				}
				if(hashSet.contains(email)) {
					email = reEmail(email, hashSet, 2);
				}
				hashSet.add(email);
				
				answer += strNm + " <" + email +"@" + C.toLowerCase() + ">, ";
			}
		}
        return answer.substring(0, answer.length()-2);
	}
	public static String reEmail(String email, HashSet<String> hash, int i) {
		String reEmail = "";
		if(hash.contains(email)) {
		   if (Character.isDigit(email.charAt(email.length() - 1))) {
			   reEmail = reEmail(email.substring(0, email.length() - 1) + i, hash, i+1);
            } else {
            	reEmail = reEmail(email + i, hash, i+1);
            }
		} else {
			reEmail = email;
		}
		return reEmail;
	}
}