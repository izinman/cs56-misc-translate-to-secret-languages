import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * The test class englishAndGibberish, to test the englishAndGibberishTranslator class
 * @author Christian Rivera Cruz and Adam Kazberuk
 * @author Alex Molina
 * @author Ty Still
 * @version 03/14/18, Proj02 CS56 W18
 * @see EnglishAndGibberishTranslator
 */

public class EnglishAndGibberishTester
{
    /**
     * test method that translates to English from Gibberish, using one word that starts with a consonant
     * @see EnglishAndGibberishTranslator
     */
    
    @Test public void testFromGibberish()
    {
        // should return stub. This method is from another issue
        assertEquals("dog",EnglishAndGibberishTranslator.toEnglish("duvugog","uvug"));
    }
    
    /**
     * test toLanguage for one word that begins with a consonant
     * @see EnglishAndGibberishTranslator
     */
    
    @Test public void testToGibberishConsonant()
    {
        // should return dog with "uvug" inserted after the d
        assertEquals("duvugog",EnglishAndGibberishTranslator.toLanguage("dog","uvug"));
    }
    
    /**
     * test toLanguage for one word that begins with a vowel
     * @see EnglishAndGibberishTranslator
     */
    
    @Test public void testToGibberishVowel()
    {
        // should return at with "uvug" inserted before the a
        assertEquals("uvugat",EnglishAndGibberishTranslator.toLanguage("at","uvug"));
    }
    
    /**
     * test toLanguage for a word that begins with a vowel then a word that begins with a consonant
     * @see EnglishAndGibberishTranslator
     */
    
    @Test public void testToGibberishVowelConsonant()
    {
        // should return at dog with "uvug" inserted before the a and after the d
        assertEquals("uvugat duvugog",EnglishAndGibberishTranslator.toLanguage("at dog","uvug"));
    }
    
}
