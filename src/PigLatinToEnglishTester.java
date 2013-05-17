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
        assertEquals(new String[]{""},EnglishToPigLatin.toEnglish(""));
    }
    /** The method that tests one word that starts with a consonant
     *  @see EnglishToPigLatin#toEnglish
     */
    @Test public void test1WordConsonant()
    {
        assertEquals(new String[]{"hist", "this", "sthi"}, EnglishToPigLatin.toEnglish("isthay"));
    }
        /** The method that tests one word that starts with a vowel
     *  @see EnglishToPigLatin#toEnglish
     */
    @Test public void test1WordVowel()
    {
        assertEquals(new String[]{"endgame", "wendgame"},EnglishToPigLatin.toEnglish("endgameway"));
    }
}
