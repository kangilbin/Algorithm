class Solution {
    static int answer;
    public int solution(int n, String[] data) {
        answer = 0;
		String nams = "ACFJMNRT";
		dfs("", nams, data, nams.length());
		return answer;
	}

	public void dfs(String comb, String others, String[] data, int cnt) {
		if (!comb.equals("") && comb.length() == cnt) {
			if (check(comb, data, 0))
				answer++;
		}

		for (int i = 0; i < others.length(); i++)
			dfs(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1), data, cnt);
	}
	public boolean check(String comb, String[] data, int cnt) {
		boolean isTrue = true;
		for (int i = cnt; i < data.length; i++) {
			String[] cdt = data[i].split("");
			switch (cdt[3]) {
			case "=":
				if (Math.abs(comb.indexOf(cdt[0]) - comb.indexOf(cdt[2])) == Integer.parseInt(cdt[4]) + 1)
					return check(comb, data, i + 1);
				else
					return false;
			case ">":
				if (Math.abs(comb.indexOf(cdt[0]) - comb.indexOf(cdt[2])) > Integer.parseInt(cdt[4]) + 1)
					return check(comb, data, i + 1);
				else
					return false;
			default:
				if (Math.abs(comb.indexOf(cdt[0]) - comb.indexOf(cdt[2])) < Integer.parseInt(cdt[4]) + 1)
					return check(comb, data, i + 1);
				else
					return false;
			}
		}
		return isTrue;
    }
}