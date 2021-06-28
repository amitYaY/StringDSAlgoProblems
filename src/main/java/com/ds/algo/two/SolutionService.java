package com.ds.algo.two;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionService {

	// private static String input = "WWEQERQWQWWRWWERQWEQ"; // 4

	private static String input = "QWER"; // 0

	public static void main(String[] args) {
		SolutionService service = new SolutionService();
		int result = service.balancedString(input);
		System.out.println("Result: " + result);
	}

	public int balancedString(String s) {
		int result = s.length();
		int len = s.length();
		int dCount = len / 4;
		Map<Character, Integer> map = new HashMap<>();

		List<Character> list = Arrays.asList('Q', 'W', 'E', 'R');

		Map<Character, Integer> dMap = new HashMap<>();

		char[] chars = s.toCharArray();
		for (char c : chars) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		for (Character c : list) {
			if (map.containsKey(c) && (dCount - map.get(c)) < 0) {
				dMap.put(c, map.get(c) - dCount);
			}
		}

		int diff = dMap.keySet().size();

		if (diff == 0) {
			return 0;
		}

		if (diff == 1) {
			if (dMap.containsValue(s.length() - dCount)) {
				return s.length() - dCount;
			}
		}

		Map<Character, Integer> tempMap = new HashMap<>(dMap);

		for (int i = 0, j = 0; j < s.length();) {

			if (tempMap.containsKey(s.charAt(j))) {
				tempMap.put(s.charAt(j), tempMap.get(s.charAt(j)) - 1);
				if (tempMap.get(s.charAt(j)) == 0) {
					diff--;
				}
			}
			if (diff == 0) {
				if (j + 1 - i < result) {
					result = j + 1 - i;
				}
				diff = dMap.keySet().size();
				tempMap = new HashMap<>(dMap);
				i++;
				j = i;
				continue;
			}
			j++;
		}

		return result;
	}

//	int min = S.length;
//    int tail = 0;
//    for (int i = 0; i < S.length; i += 1) {
//      counts[S[i]] -= 1;
//      
//      while (
//        tail < S.length
//        && counts['Q'] <= target
//        && counts['W'] <= target
//        && counts['E'] <= target
//        && counts['R'] <= target
//      ) {
//        min = Math.min(min, i - tail + 1);
//        counts[S[tail]] += 1;
//        tail += 1;
//      }
//    }
}
