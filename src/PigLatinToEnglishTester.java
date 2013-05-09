import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * The test class englishToPigLatinlTester, to test the englishToPigLatin class
 *
 * @author Christian Rivera Cruz, and Adam Kazberuk
 * @version CS56, Spring 2012
 * @see englishToPigLatin
 */

public class PigLatinToEnglishTester
{
    /**
       test empty string
       @see EnglishToPigLatin#toPigLatin()
     */
   
    @Test public void testNullString()
    {
	// default conversion should be blank
        assertEquals("",EnglishToPigLatin.toEnglish(""));
    }
    /** The method that tests one word that starts with a consonant
     *  @see EnglishToPigLatin#toEnglish
     */
    @Test public void test1WordConsonant()
    {
	// "this" should come out to be "histay", using the consonant rules
        assertEquals("this",EnglishToPigLatin.toEnglish("isthay"));
    }
        /** The method that tests one word that starts with a vowel
     *  @see EnglishToPigLatin#toEnglish
     */
    @Test public void test1WordVowel()
    {
	// "this" should come out to be "histay", using the vowel rules
        assertEquals("engame",EnglishToPigLatin.toEnglish("endgameway"));
    }
    /** The method that tests two words that start with consonants
     *  @see EnglishToPigLatin#toEnglish
     */
    @Test public void test2WordsConsonants()
    {
	//this will test two words being translated over
	assertEquals("this phrase", EnglishToPigLatin.toEnglish("isthay asephray"));
    }
        /** The method that tests two words that start with vowels
     *  @see EnglishToPigLatin#toEnglish
     */
    @Test public void test2WordsVowels()
    {
	//this will test two words being translated over
	assertEquals("enders endgame", EnglishToPigLatin.toEnglish("endersway endgameway"));
    }
    /** The method that tests two words that start with a consonant then a vowel
     *  @see EnglishToPigLatin#toEnglish
     */
    @Test public void test2WordsConsonantVowel()
    {
	//this will test a consonant word, followed by a vowel word
	assertEquals("cold ice", EnglishToPigLatin.toEnglish("oldcay iceway"));
    }
    /** The method that tests two words that start with a vowel then a consonant
     *  @see EnglishToPigLatin#toEnglish
     */
    @Test public void test2WordsVowelConsonant()
    {
	//this will test a consonant word, followed by a vowel word
	assertEquals("any way", EnglishToPigLatin.toEnglish("anyway ayway"));
    }   
    /** The method that tests three words that start with a vowel, then consonant, then vowel
     *  @see EnglishToPigLatin#toEnglish
     */
    @Test public void testVowelConsonantVowel()
    {
	//this will test a consonant word, followed by a vowel word
	assertEquals("i be awesome", EnglishToPigLatin.toEnglish("iway ebay awesomeway"));
    }   
    /** The method that tests three words that start with a consonant, then vowel, then consonant
     *  @see EnglishToPigLatin#toEnglish
     */
    @Test public void testConsonantVowelConsonant()
    {
	//this will test a consonant word, followed by a vowel word
	assertEquals("cold as kentucky", EnglishToPigLatin.toEnglish("oldcay asway entuckykay"));
    }   
}
