package com.rei.sdethomework;

import java.util.ArrayList;
import java.util.List;

import utils.math.combinatorics.PermutationIterable;
import utils.math.combinatorics.PowerSetIterable;

public class Dictionary {

	public static boolean isEnglishWord(String word) {

		PowerSetIterable<Character> powerSet = new PowerSetIterable<Character>(convertStringToCharList(word));

		for (List<Character> subset : powerSet) {
			PermutationIterable<Character> permutations = new PermutationIterable<Character>(subset);

			for (List<Character> permutation : permutations) {
				StringBuilder sb = new StringBuilder();

				for (Character ch : permutation) {
					sb.append(ch);
				}

				String perm = sb.toString();
				System.out.println(perm);
				if (perm.equals(word)) {
					return true;
				}

			}

		}

		return false;

	}

	public static List<Character> convertStringToCharList(String str) {

		// Create an empty List of character
		List<Character> chars = new ArrayList<>();

		// For each character in the String
		// add it to the List
		for (char ch : str.toCharArray()) {

			chars.add(ch);
		}

		// return the List
		return chars;
	}
}
