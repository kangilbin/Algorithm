package test;

import java.util.ArrayList;
import java.util.Collections;

public class Main{
   	public static void main(String[] args)  {
   		 int[] numbers = {3, 30, 34, 5, 9};
	     System.out.println(solution(numbers));

   	}
    public static String solution(int[] numbers) {
        String answer = "";
        ArrayList<String> strNumbers = new ArrayList();
        for(Integer num : numbers){
            strNumbers.add(String.valueOf(num));
        }
        Collections.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));
        if(strNumbers.get(0).startsWith("0")) return "0";
        for(String s : strNumbers){
            answer += s;
        }
        return answer;
    }
} 