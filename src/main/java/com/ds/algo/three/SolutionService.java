package com.ds.algo.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionService {

//	private static String s = "catsanddog";
//	private static List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");

	private static String s = "a";
	private static List<String> wordDict = Arrays.asList("a");

	public static void main(String[] args) {
		SolutionService service = new SolutionService();
		List<String> result = service.wordBreak(s, wordDict);
		System.out.println("Result: " + result);

	}

	Map<Integer, List<Integer>> map = new HashMap<>();

	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> result = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if (wordDict.contains(s.substring(i, j + 1))) {
					List<Integer> list = map.getOrDefault(i, new ArrayList<>());
					list.add(j);
					map.put(i, list);
				}
			}
		}
		System.out.println("Map: " + map);
		List<Integer> list = map.get(0);
		if (list != null) {
			for (Integer end : list) {
				if (end == s.length() - 1) {
					String newStr1 = "";
					newStr1 = s.substring(0, end + 1);
					result.add(newStr1.trim());
				} else if (map.containsKey(end + 1)) {
					String newStr = "";
					newStr += s.substring(0, end + 1);
					formSentence(end + 1, map.get(end + 1), newStr, result, s);
				}
			}
		}
		return result;
	}

	private void formSentence(int start, List<Integer> list, String newStr, List<String> result, String s) {
		for (Integer end : list) {
			if (end == s.length() - 1) {
				String newStr1 = "";
				newStr1 = newStr + " " + s.substring(start, end + 1);
				result.add(newStr1.trim());
			} else if (map.containsKey(end + 1)) {
				String newStr1 = "";
				newStr1 = newStr + " " + s.substring(start, end + 1);
				formSentence(end + 1, map.get(end + 1), newStr1, result, s);
			}
		}
	}
}
