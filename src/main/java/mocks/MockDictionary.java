package mocks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MockDictionary {
	
	Set<String> validatedWords;
	public boolean validateWord(String word) {  	
		List<String> dictionaryList = Arrays.asList("king", "ring", "grin", "gin", "know", "gown", "grow", "org", "row", "wok",
				"work", "rig", "irk", "kin", "ink", "wink");
		
		validatedWords = new HashSet<String>();
	    
		for (String aWord : dictionaryList) {
            validatedWords.add(aWord); 
	    }


		if (getMockDictionary().contains(word.toLowerCase())) {
			return true;
		} else {
			return false;
		}

	}

	public Set<String> getMockDictionary() {
		return validatedWords;
	}

}
