package com.rei.sdethomework;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Set;


public class TestDictionary {
	public static List<String> validPermsForTheWordWorking;

	@Before
	public void setup() {
		validPermsForTheWordWorking = Arrays.asList("king", "ring", "grin", "gin", "know", "gown", "grow", "org", "row", "wok",
				"work", "rig", "irk", "kin", "ink", "wink");
	}
	
	@Test
	public void test7CharWord() {
		int knownPermutations = 16;
		Dictionary.isEnglishWord("working");
		Set<String> validWords = Dictionary.getValidWords();
		assertEquals(knownPermutations, validWords.size());
		
	}
	
	@Test
	public void test4CharWord() {
		System.out.println("This is the size of the hashset, which stores our valid permutations.");
		int knownPermutations = 4;
		Dictionary.isEnglishWord("ring");
		Set<String> generatedWords = Dictionary.getValidWords();
		System.out.println("Test: " + generatedWords.size());
		assertEquals(knownPermutations, generatedWords.size());
		
	}
	
	@Test
	public void testNonAlphaNumChars() {
		int knownPermutations = 0;
		Dictionary.isEnglishWord("*#&&");
		Set<String> generatedWords = Dictionary.getValidWords();
		assertEquals(knownPermutations, generatedWords.size());
		
	}
	
	@Test
	public void testNumbers() {
		System.out.println("This is the size of the hashset, which stores our valid permutations.");
		int knownPermutations = 0;
		Dictionary.isEnglishWord("333");
		Set<String> generatedWords = Dictionary.getValidWords();
		System.out.println("Test: " + generatedWords.size());
		assertEquals(knownPermutations, generatedWords.size());
		
	}
	
	
	@Test
	public void testValidWord() {
		System.out.println("Using Mockito");
		try (MockedStatic<Dictionary> theMock = Mockito.mockStatic(Dictionary.class)) {
			theMock.when(() -> Dictionary.isEnglishWord("working")).thenReturn(true);
		}
		
		assertEquals(true, Dictionary.isEnglishWord("working"));

	}




}
