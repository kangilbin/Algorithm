package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main{
   	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String participant[] = {"mislav", "stanko", "mislav", "ana"};	// 참여 선수들 이름
		String completion[] = {"stanko", "ana", "mislav"};	// 완주한 선수들 이름
		solution(participant, completion);

   	}
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        for(String result : completion) {
        	System.out.println(result + " : "+Arrays.asList(participant).indexOf(result));
        }
        return answer;
    }
}

