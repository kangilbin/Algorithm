package test;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		int[] A = {7,-5,-5,-5,7,-1,7};
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		int max = 1;
		ArrayList<Integer> chA = new ArrayList<Integer>();
		HashSet<Integer> hashSet = new HashSet<Integer>();
		
		for(int i=0; i<A.length; i++) {
			if(i+2 < A.length) {
				if(A[i] == A[i+2]) {
					//chA.add(A[i]);
					//chA.add(A[i+2]);
					hashSet.add(i);
					hashSet.add(i+1);
					hashSet.add(i+2);
				} else {
					//int val = chA.size() == 1 ?  chA.size() * 2 + 1 : chA.size()*2;
					max = Math.max(max, hashSet.size());
					//chA.clear();
					hashSet.clear();
				}
			}
		}
		max = Math.max(max, hashSet.size());
        return max;
	}
}