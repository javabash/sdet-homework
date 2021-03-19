package com.rei.sdethomework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import utils.math.combinatorics.PermutationIterable;
import utils.math.combinatorics.PowerSetIterable;
import mocks.MockDictionary;

public class Dictionary {
	private static HashSet<String> validWords;

	public static boolean isEnglishWord(String word) {
		
		//Set of generated words validated against our mockDictionary words
		validWords = new HashSet<String>();
		
		//Source of truth
		MockDictionary mockDictionary = new MockDictionary();
		
		PowerSetIterable<Character> powerSet = new PowerSetIterable<Character>(
				convertStringToCharList(word.toLowerCase()));

		for (List<Character> subset : powerSet) {
			PermutationIterable<Character> permutations = new PermutationIterable<Character>(subset);

			for (List<Character> permutation : permutations) {
				StringBuilder sb = new StringBuilder();

				for (Character ch : permutation) {
					sb.append(ch);
				}

				String perm = sb.toString();
				System.out.println(perm);
				if (mockDictionary.validateWord(perm) == true) {
					System.out.println(perm);
					validWords.add(perm);

				}

			}

		}
		//isEnglishWord() returns false if there are no validated permutations in our word store.
		if (validWords.size() == 0) {
			return false;
		}
		return true;

	}

	public static List<Character> convertStringToCharList(String str) {

		List<Character> chars = new ArrayList<>();

		// For each character in the String
		// add it to the List
		for (char ch : str.toCharArray()) {

			chars.add(ch);
		}

		return chars;
	}
	//Stored valid permutations / helper method to support testing
	public static HashSet<String> getValidWords() {
		return validWords;
	}
}
