package com.rei.sdethomework;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.mockito.ArgumentCaptor;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@RunWith(Parameterized.class)
public class TestDictionary {

//	Dictionary mockedDictionary = Mockito.mock(Dictionary.class);	

	@Before
	public void setup() {

	}

	@Test
	public void testWord() {
		
		assertEquals(true, Dictionary.isEnglishWord("work"));

		try (MockedStatic<Dictionary> theMock = Mockito.mockStatic(Dictionary.class)) {
			theMock.when(() -> Dictionary.isEnglishWord("working")).thenReturn(true);

		}
		assertEquals(true, Dictionary.isEnglishWord("work"));

	}
	
	  @Parameterized.Parameters
	   public static Collection wordList() {
	      return Arrays.asList(new Object[][] {
	         { "king", true },
	         { "ring", true },
	         { "grin", true },
	         { "gin", true },
	         { "know", true },
	         { "gown", true },
	         { "grow", true },
	         { "org", true },
	         { "row", true },
	         { "wok", true },
	         { "work", true },
	         { "rig", true },
	         { "irk", true },
	         { "kin", true },
	         { "ink", true },
	         { "wink", true }
	                  
	      });
	   }
	


}
