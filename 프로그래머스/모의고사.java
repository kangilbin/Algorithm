import java.util.ArrayList;
class Solution {
    public int[] solution(int[] answers) {
        int[] fir = {1, 2, 3, 4, 5};
    	int[] sec = {2, 1, 2, 3, 2, 4, 2, 5};
    	int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    	int firCnt = 0;
    	int secCnt = 0;
    	int threeCnt = 0;
    	
    	for(int i=0; i<answers.length; i++) {
    		if(fir[i%fir.length]==answers[i]) firCnt++;
    		if(sec[i%sec.length]==answers[i]) secCnt++;
    		if(three[i%three.length]==answers[i]) threeCnt++;
    	}
    	int max = Math.max(firCnt, Math.max(secCnt, threeCnt));
    	
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	if(max == firCnt) list.add(1);
    	if(max == secCnt) list.add(2);
    	if(max == threeCnt) list.add(3);
    	
    	
    	
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }
}