package src.edu.ucsb.cs56.projects.misc.translate_to_secret_languages.combined_translator;


import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
   The test class EnglishToPigLatinTester, to test the EnglishToPigLatin class
   @author Christian Rivera Cruz                                                                                                                            
   @author Adam Kazberuk                                                                                                                                    
   @author Ian Vernon                                                                                                                                        
   @author Evan Moelter                                                                                                                                      
   @version 05/17/2013 for project01, cs56, S13         
*/

public class PigLatinToEnglishTester
{
    /**
       test empty string
       @see EnglishToPigLatin
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
