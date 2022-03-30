package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		int[] abilities = {7, 6, 8, 9, 10};
		int k = 1;
		System.out.println(Solution(abilities,k));
	}
	
	public static int Solution(int[] abilities, int k) {
		 int answer = 0;
		 Integer[] arr = Arrays.stream(abilities).boxed().toArray(Integer[]::new);
		 Arrays.sort(arr, Comparator.reverseOrder());
		 
		 ArrayList<Integer> list = new ArrayList<Integer>();
		 for(int i=0; i<arr.length-1; i++) {
			 if(arr.length/2 == 0) {  // 짝수
				 if(arr[i] != arr[i+1]) {
					 if(k > 0) {
						 list.add(arr[i]);
						 k--;
						 i++;
					 } else {
						 i++;
					 }
				 } else {
					 list.add(arr[i]);
					 i++;
				 }
			 } else { // 홀수
				 if(k>1) {
					 if(arr[i] != arr[i+1]) {
						 if(k > 0) {
							 list.add(arr[i]);
							 k--;
							 i++;
						 } else {
							 i++;
						 }
					 }
				 } else {
					 list.add(arr.length);
				 }
			 }
		 }
		 
		 int sum = list.stream().mapToInt(Integer::intValue).sum();
	     System.out.println(sum);

		 
		 return answer;
	 }
}
