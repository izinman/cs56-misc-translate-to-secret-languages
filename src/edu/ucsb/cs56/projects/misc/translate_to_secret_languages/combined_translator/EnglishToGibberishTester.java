import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * The test class englishToGibberish, to test the englishToGibberish class
 * @author Christian Rivera Cruz and Adam Kazberuk
 * @author Alex Molina
 * @version CS56, Spring 2013
 * @see EnglishToGibberish */

public class EnglishToGibberishTester
{
    /**
     test method that translates to English from Gibberish, using one word that starts with a consonant
     @see EnglishToGibberish
     */

    @Test public void testFromGibberish()
    {
        // should return stub. This method is from another issue
        assertEquals("dog",EnglishToGibberish.fromGibberish("duvugog"));
    }

    /**
     test toGibberish for one word that begins with a consonant
     @see EnglishToGibberish
     */

    @Test public void testToGibberishConsonant()
    {
        // should return dog with "uvug" inserted after the d
        assertEquals("duvugog",EnglishToGibberish.toGibberish("dog"));
    }

    /**
     test toGibberish for one word that begins with a vowel
     @see EnglishToGibberish
     */

    @Test public void testToGibberishVowel()
    {
        // should return dog with "uvug" inserted after the d
        assertEquals("uvugat",EnglishToGibberish.toGibberish("at"));
    }

    /**
     test toGibberish for a word that begins with a vowel then a word that begins with a consonant
     @see EnglishToGibberish
     */

    @Test public void testToGibberishVowelConsonant()
    {
        // should return dog with "uvug" inserted after the d
        assertEquals("uvugat duvugog",EnglishToGibberish.toGibberish("at dog"));
    }

}
