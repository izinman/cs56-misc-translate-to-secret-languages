package src.edu.ucsb.cs56.projects.misc.translate_to_secret_languages.combined_translator;

import javax.swing.*;
import java.awt.*;
import java.util.StringTokenizer;

/** englishToPigLatin
 @author Christian Rivera Cruz and Adam Kazberuk
 @author Alex Molina
 @version 05/15/2013 for lab05, cs56, S13
 */

public class EnglishToGibberish {
	/** The method that checks to see if the first character passed
	 * to it is a vowel or a consonant
	 * @param input the first letter of a word
	 * @return result which is true when the first letter is a vowel
	 */


	public static boolean isVowel(char input) {
		return	(input=='a'||input=='A'||input=='e'||input=='E'
				||input=='i'||input=='I'||input=='o'
				||input=='O'||input=='u'||input=='U');
	}

	/**
	 * The method that converts the string from English to Gibberish
	 *
	 * The method takes a string input, and checks the first letter in the string
	 * If it is a vowel, then "uvug" is added in front of it
	 *
	 * @param  input the input is the string typed into the box
	 * @return String is returned, and it is reprinted into the text box below the input
	 */
	public static String toGibberish(String input) {
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
						result += "uvug";
						result += charArray[j];
						result += charArray[j+1];
						j++;
					}
					else {
						result += "uvug";
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
	 * The method that converts the string from Gibberish to English
	 *
	 * The method takes a string input, and removes all occurrences of "uvug" and "Uvug"
	 *
	 * @param  input the input is the string typed into the box
	 * @return String is returned, and it is reprinted into the text box below the input
	 */
	public static String fromGibberish(String input) {
		String newstr = input.replaceAll("uvug", "");
		String newerstr;
		if (newstr.charAt(0) == 'U')
			newerstr = newstr.replaceAll("Uvug", "");
		else
			return newstr;
		newstr = newerstr.substring(0, 1).toUpperCase() + newerstr.substring(1);
		return newstr;
	}
	
}
