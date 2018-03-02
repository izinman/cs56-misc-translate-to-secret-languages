import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
   The test class EnglishToPigLatinlTester, to test the EnglishToPigLatin class
   @author Christian Rivera Cruz                                                                                                                             
   @author Adam Kazberuk                                                                                                                                    
   @author Ian Vernon                                                                                                                                        
   @author Evan Moelter                                                                                                                                      
   @version 05/17/2013 for lab05, cs56, S13         
   @see EnglishToPigLatin
 */

public class EnglishToPigLatinTester
{
    /**
       @see EnglishToPigLatin
     */
   
    @Test public void testNullString()
    {
	// default conversion should be blank
        assertEquals("",EnglishToPigLatin.toPigLatin(""));
    }
    /** The method that tests one word that starts with a consonant
     *  @see EnglishToPigLatin#toPigLatin
     */
    @Test public void test1WordConsonant()
    {
	// "this" should come out to be "histay", using the consonant rules
        assertEquals("isthay",EnglishToPigLatin.toPigLatin("this"));
    }
        /** The method that tests one word that starts with a vowel
     *  @see EnglishToPigLatin#toPigLatin
     */
    @Test public void test1WordVowel()
    {
	// "this" should come out to be "histay", using the vowel rules
        assertEquals("endgameway",EnglishToPigLatin.toPigLatin("endgame"));
    }
    /** The method that tests two words that start with consonants
     *  @see EnglishToPigLatin#toPigLatin
     */
    @Test public void test2WordsConsonants()
    {
	//this will test two words being translated over
	assertEquals("isthay asephray", EnglishToPigLatin.toPigLatin("this phrase"));
    }
        /** The method that tests two words that start with vowels
     *  @see EnglishToPigLatin#toPigLatin
     */
    @Test public void test2WordsVowels()
    {
	//this will test two words being translated over
	assertEquals("endersway endgameway", EnglishToPigLatin.toPigLatin("enders endgame"));
    }
    /** The method that tests two words that start with a consonant then a vowel
     *  @see EnglishToPigLatin#toPigLatin
     */
    @Test public void test2WordsConsonantVowel()
    {
	//this will test a consonant word, followed by a vowel word
	assertEquals("oldcay iceway", EnglishToPigLatin.toPigLatin("cold ice"));
    }
    /** The method that tests two words that start with a vowel then a consonant
     *  @see EnglishToPigLatin#toPigLatin
     */
    @Test public void test2WordsVowelConsonant()
    {
	//this will test a consonant word, followed by a vowel word
	assertEquals("anyway ayway", EnglishToPigLatin.toPigLatin("any way"));
    }   
    /** The method that tests three words that start with a vowel, then consonant, then vowel
     *  @see EnglishToPigLatin#toPigLatin
     */
    @Test public void testVowelConsonantVowel()
    {
	//this will test a consonant word, followed by a vowel word
	assertEquals("iway ebay awesomeway", EnglishToPigLatin.toPigLatin("i be awesome"));
    }   
    /** The method that tests three words that start with a consonant, then vowel, then consonant
     *  @see EnglishToPigLatin#toPigLatin
     */
    @Test public void testConsonantVowelConsonant()
    {
	//this will test a consonant word, followed by a vowel word
	assertEquals("oldcay asway entuckykay", EnglishToPigLatin.toPigLatin("cold as kentucky"));
    }   
  /** The method that tests a vowel in the third letter of the word
     *  @see EnglishToPigLatin#posFirstVowel
     */
    @Test public void test_posFirstVowelThis()
    {
        assertEquals(2,EnglishToPigLatin.posFirstVowel("this"));
    }
     /** The method that tests a vowel in the fourth letter of the word
     *  @see EnglishToPigLatin#posFirstVowel
     */
    @Test public void test_posFirstVowelstreet()
    {
        assertEquals(3,EnglishToPigLatin.posFirstVowel("street"));
    }
     /** The method that tests a vowel in the first letter of the word
     *  @see EnglishToPigLatin#posFirstVowel
     */
    @Test public void test_posFirstVowelaway()
    {
        assertEquals(0,EnglishToPigLatin.posFirstVowel("away"));
    }
}
