public class Test {
   public static void main(String[] args) {
      String[][] C = { { "PUSH", "www.domain1.com" }, { "PUSH", "www.domain2.com" }, { "PUSH", "www.domain3.com" }, { "BACK", "1" }, { "BACK", "1" }, { "PUSH", "www.domain4.com" } };

      for (String a : solution(C)) {
	         System.out.println(a);
      }
   }

   public static String[] solution(String[][] C) {
      ArrayList<String> urlLst = new ArrayList<>();
      int idx = -1;
      for (String[] act : C) {
         if (act[0].equals("BACK")) {
            if (urlLst.size() > 0) {
               if (Integer.parseInt(act[1]) - 1 > idx) {
                  idx = 0;
               } else {
                  idx -= Integer.parseInt(act[1]);
               }
            }
         } else if (act[0].equals("NEXT")) {
            if (Integer.parseInt(act[1]) > (urlLst.size() - idx - 1)) {
               idx = urlLst.size() - 1;
            } else {
               idx += Integer.parseInt(act[1]);
            }
         } else {
            if (urlLst.isEmpty()) {
               urlLst.add(act[1]);
            } else {
               urlLst.add(idx + 1, act[1]);
            }
            idx++;
         }
      }
      String[] result =  urlLst.subList(0, idx).stream().toArray(String[]::new);
      return result;
   }
}