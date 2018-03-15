package src.edu.ucsb.cs56.projects.misc.translate_to_secret_languages.combined_translator;

import javax.swing.*;
import java.awt.*;
import java.util.StringTokenizer;

/** englishToGibberish
 * @author Ty Still
 * @version 03/13/18, for proj02 CS56 W18
 */

public class EnglishAndGibberishTranslator extends EnglishToInsertionLang {
    
    
    public EnglishAndGibberishTranslator(){
	replacement="uvug";
    }
    public static String toGibberish(String input) {
        return toLanguage(input);
    }
}