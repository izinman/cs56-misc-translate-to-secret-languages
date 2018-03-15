package src.edu.ucsb.cs56.projects.misc.translate_to_secret_languages.combined_translator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
   The test class EnglishAndPigLatinTranslatorlTester, to test the EnglishAndPigLatinTranslator class
   @author Christian Rivera Cruz                                                                                                                             
   @author Adam Kazberuk                                                                                                                                    
   @author Ian Vernon                                                                                                                                        
   @author Evan Moelter                                                                                                                                      
   @version 05/17/2013 for lab05, cs56, S13         
   @see EnglishAndPigLatinTranslator
 */

public class EnglishToPigLatinTester
{
    /**
       @see EnglishAndPigLatinTranslator
     */
   
    @Test public void testNullString()
    {
	// default conversion should be blank
        assertEquals("",EnglishAndPigLatinTranslator.toPigLatin(""));
    }
    /** The method that tests one word that starts with a consonant
     *  @see EnglishAndPigLatinTranslator#toPigLatin
     */
    @Test public void test1WordConsonant()
    {
	// "this" should come out to be "histay", using the consonant rules
        assertEquals("isthay",EnglishAndPigLatinTranslator.toPigLatin("this"));
    }
        /** The method that tests one word that starts with a vowel
     *  @see EnglishAndPigLatinTranslator#toPigLatin
     */
    @Test public void test1WordVowel()
    {
	// "this" should come out to be "histay", using the vowel rules
        assertEquals("endgameway",EnglishAndPigLatinTranslator.toPigLatin("endgame"));
    }
    /** The method that tests two words that start with consonants
     *  @see EnglishAndPigLatinTranslator#toPigLatin
     */
    @Test public void test2WordsConsonants()
    {
	//this will test two words being translated over
	assertEquals("isthay asephray", EnglishAndPigLatinTranslator.toPigLatin("this phrase"));
    }
        /** The method that tests two words that start with vowels
     *  @see EnglishAndPigLatinTranslator#toPigLatin
     */
    @Test public void test2WordsVowels()
    {
	//this will test two words being translated over
	assertEquals("endersway endgameway", EnglishAndPigLatinTranslator.toPigLatin("enders endgame"));
    }
    /** The method that tests two words that start with a consonant then a vowel
     *  @see EnglishAndPigLatinTranslator#toPigLatin
     */
    @Test public void test2WordsConsonantVowel()
    {
	//this will test a consonant word, followed by a vowel word
	assertEquals("oldcay iceway", EnglishAndPigLatinTranslator.toPigLatin("cold ice"));
    }
    /** The method that tests two words that start with a vowel then a consonant
     *  @see EnglishAndPigLatinTranslator#toPigLatin
     */
    @Test public void test2WordsVowelConsonant()
    {
	//this will test a consonant word, followed by a vowel word
	assertEquals("anyway ayway", EnglishAndPigLatinTranslator.toPigLatin("any way"));
    }   
    /** The method that tests three words that start with a vowel, then consonant, then vowel
     *  @see EnglishAndPigLatinTranslator#toPigLatin
     */
    @Test public void testVowelConsonantVowel()
    {
	//this will test a consonant word, followed by a vowel word
	assertEquals("iway ebay awesomeway", EnglishAndPigLatinTranslator.toPigLatin("i be awesome"));
    }   
    /** The method that tests three words that start with a consonant, then vowel, then consonant
     *  @see EnglishAndPigLatinTranslator#toPigLatin
     */
    @Test public void testConsonantVowelConsonant()
    {
	//this will test a consonant word, followed by a vowel word
	assertEquals("oldcay asway entuckykay", EnglishAndPigLatinTranslator.toPigLatin("cold as kentucky"));
    }   
  /** The method that tests to see if the  vowel is in the third letter of the word
     *  @see EnglishAndPigLatinTranslator#posFirstVowel
     */
    @Test public void test_posFirstVowelThis()
    {
        assertEquals(2,EnglishAndPigLatinTranslator.posFirstVowel("this"));
    }
     /** The method that tests to see if a vowel is in the fourth letter of the word
     *  @see EnglishAndPigLatinTranslator#posFirstVowel
     */
    @Test public void test_posFirstVowelstreet()
    {
        assertEquals(3,EnglishAndPigLatinTranslator.posFirstVowel("street"));
    }
     /** The method that tests to see if a vowel is in the first letter of the word
     *  @see EnglishAndPigLatinTranslator#posFirstVowel
     */
    @Test public void test_posFirstVowelaway()
    {
        assertEquals(0,EnglishAndPigLatinTranslator.posFirstVowel("away"));
    }
}
