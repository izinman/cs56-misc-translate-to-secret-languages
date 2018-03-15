package src.edu.ucsb.cs56.projects.misc.translate_to_secret_languages.combined_translator;

import javax.swing.*;
import java.awt.*;
import java.util.StringTokenizer;

/**
 * EnglishAndObishTranslator
 *  
 * 
 * @author Ty Still
 *
 * @version 3/14/18, for Proj02 CS56 W18
 */
public class EnglishAndObishTranslator extends EnglishToInsertionLang{

    
    public EnglishAndObishTranslator(){
	replacement="ob";
    }
    public static String toObish(String input) {
        return toLanguage(input);
    }
    
    
}
