class Solution {
    public long solution(int w, int h) {
        Long width = Long.valueOf(w);
        Long height = Long.valueOf(h);

		long gcd = gcd(width, height);

		return width * height - (width + height - gcd);
	}

	public long gcd(long w, long h) {
		if (w % h == 0) {
			return h;
		}
		return gcd(h, w % h);
	}
}