package com.rei.sdethomework;

import java.util.Set;

public class App {
	public static void main(String[] args) {

		System.out.println("Is King a valid word? " + Dictionary.isEnglishWord("king"));
		System.out.println("Is 123 a valid word? " + Dictionary.isEnglishWord("123"));
		
		//i.e., permutations of the word, 'king"
		Set<String> validWords = Dictionary.getValidWords();
		//Sanity check
		for (String vWord : validWords) {
			System.out.print("Word:" + vWord + " | ");
		}
		// size of the hash set
		System.out.println("Hash Set Size: " + validWords.size());
	}

}
