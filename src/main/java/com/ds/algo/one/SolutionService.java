package com.ds.algo.one;

public class SolutionService {

	//private static String input = "cdbcbbaaabab";
	//private static String input = "bcadb";
	//private static String input = "aabbaaxybbaabb";
	private static String input = "aabbrtababbabmaaaeaabeawmvaataabnaabbaaaybbbaabbabbbjpjaabbtabbxaaavsmmnblbbabaeuasvababjbbabbabbasxbbtgbrbbajeabbbfbarbagha";
			
	private static int x = 4; // ab
	private static int y = 5; // ba

	private static int max = 0;

	public static void main(String[] args) {
		SolutionService service = new SolutionService();
		int result = service.maximumGain_BadSolution(input, x, y);
		System.out.println("Result: " + result);
	}

	public int maximumGain_BadSolution(String s, int x, int y) {

		remove(s, "ab", 0, x, y);

		remove(s, "ba", 0, x, y);

		return max;
	}

	public void remove(String input, String subS, int earned, int x, int y) {
		
		if (!input.contains("ab") && !input.contains("ba")) {
			if (earned > max) {
				max = earned;
			}
			return;
		}

		String s = null;
		if (input.contains(subS)) {
			s = input.replaceFirst(subS, "");
			if ("ab".equals(subS)) {
				earned += x;
			} else {
				earned += y;
			}
		}
		if (s.contains("ab")) {
			remove(s, "ab", earned, x, y);
		}
		if (s.contains("ba")) {
			remove(s, "ba", earned, x, y);
		}
		
		if (!s.contains("ab") && !s.contains("ba")) {
			if (earned > max) {
				max = earned;
			}
			return;
		}
	}
}
