import javax.swing.*;
import java.awt.*;
import java.util.StringTokenizer;

/** EnglishToInserionLang
 * generic abstraction that can be implemented in any insertion language
 * 
 * @author Ty Still
 * @version 03/14/2018 for lab05, cs56, S13
 */

public abstract class EnglishToInsertionLang {
    /** The method that checks to see if the first character passed
     * to it is a vowel or a consonant
     * @param input the first letter of a word
     * @return return true if input is a vowel, false otherwise
     */
    public static boolean isVowel(char input) {
	return	(input=='a'||input=='A'||input=='e'||input=='E'
		 ||input=='i'||input=='I'||input=='o'
		 ||input=='O'||input=='u'||input=='U');
    }
    
    /**
     * The method that converts the string from English to whichever InsertionLang you want
     *
     * The method takes a string input, and checks the first letter in the string
     * If it is a vowel, then replacement is added in front of it
     *
     * @param input the input is the string typed into the box
     * @param replacement is the string that is inserted into the word
     * @return result is returned, and it is reprinted into the text box below the input
     */
    public static String toLanguage(String input, String replacement) {
	String result = "";
	String words = "";
	if (input.equals(""))
	    return result;
	StringTokenizer token = new StringTokenizer(input);
	while (token.hasMoreTokens()) {
	    words = token.nextToken();
	    words.toLowerCase();
	    char[] charArray = words.toCharArray();
	    for (int j = 0; j < charArray.length; j++) {
		if (isVowel(charArray[j])) {
		    if (j + 1 < charArray.length && isVowel(charArray[j+1])) {
			result += replacement;
			result += charArray[j];
			result += charArray[j+1];
			j++;
		    }
		    else {
			result += replacement;
			result += charArray[j];}
		    
		}
		else {
		    result += charArray[j];
		}
	    }
	    result += " ";
	}
	
	result = result.toLowerCase();
	result = result.trim();
	if (Character.isUpperCase(input.charAt(0))) {
	    return Character.toUpperCase(result.charAt(0)) + (result.length() > 1 ? result.substring(1) : "");
	}
	else
	    return result;
    }
    /**
     * The method that converts the string from a replacement language to English
     *
     * The method takes a string input, and removes all occurences of the replacement string
     *
     * @param  input the input is the string typed into the box
     * @param replacement is the string that will be removed from words, depending on the language
     * @return newstr is returned, and it is reprinted into the text box below the input
     */
    public static String toEnglish(String input, String replacement) {
	String newstr = input.replaceAll(replacement, "");
	String newerstr, newReplacement;
	newReplacement = replacement.substring(0,1).toUpperCase() + replacement.substring(1);
	if (newstr.substring(0,1) == newReplacement.substring(0,1))
	    newerstr = newstr.replaceAll(newReplacement, "");
	else
	    return newstr;
	newstr = newerstr.substring(0,1).toUpperCase() + newerstr.substring(1);
	return newstr;
    }
}
