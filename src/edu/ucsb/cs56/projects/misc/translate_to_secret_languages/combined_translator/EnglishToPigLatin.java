package src.edu.ucsb.cs56.projects.misc.translate_to_secret_languages.combined_translator;


import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
 * this is a class that helps translate a phrase to / from English to /from
 * PigLatin
 *
 * @author Christian Rivera Cruz
 * @author Adam Kazberuk
 * @author Ian Vernon
 * @author Evan Moelter
 * @author Isaac Zinman
 * @version 2/22/18 for legacy project, cs56, W18 - fully refactored by IZ
 */

public class EnglishToPigLatin {

	/**
	 * The method that converts the string from english to pig latin
	 *
	 * The method takes a string input, and checks the first letter in the
	 * string If it is a vowel, then "way" is added to the end, and if it is a
	 * consonant the first consonant is moved to the end of the word, and "ay"
	 * is added TODO: fix it so that instead of just being the first character,
	 * the function moves every consonant until the first vowel
	 *
	 * @param input
	 *            the input is the string typed into the box
	 * @return String is returned, and it is reprinted into the text box below
	 *         the input
	 */

	public static String toPigLatin(String input) {

		String result = "";
		String words = "";
		int posFirstVowel = 0;
		if (input.equals(""))
			return result;

		StringTokenizer token = new StringTokenizer(input);
		while (token.hasMoreTokens()) {
			words = token.nextToken();
			words.toLowerCase();
			char[] charArray = words.toCharArray();
			// the part that enforces the rules of pig latin
			if (EnglishToGibberish.isVowel(charArray[0])) {
				result += words + "way ";
			}
			// else adapted from code found at
			// http://technotip.com/216/position-left-most-vowel-javascript/
			else {
				posFirstVowel = posFirstVowel(words);
				for (int j = posFirstVowel; j < charArray.length; j++) {
					result += charArray[j];
				}
				for (int j = 0; j < posFirstVowel; j++) {
					result += charArray[j];
				}
				result += "ay ";
			}
		}
		result = result.toLowerCase();
		result = result.trim();

		// The following was adapted from code found online at
		// http://stackoverflow.com/questions/3100526/changing-charsequence-first-letter-to-upper-case-in-android
		if (Character.isUpperCase(input.charAt(0))) {
			return Character.toUpperCase(result.charAt(0)) + (result.length() > 1 ? result.substring(1) : "");
		} else
			return result;
	}

	/**
	 * The method that converts the string from pig latin to english
	 *
	 * The method takes a string input, and checks the first letter in the
	 * string If it is a vowel, then "way" is added to the end, and if it is a
	 * consonant the first consonant is moved to the end of the word, and "ay"
	 * is added TODO: fix it so that instead of just being the first character,
	 * the function moves every consonant until the first vowel
	 *
	 * @param input
	 *            the input is the string typed into the box
	 * @return String is returned, and it is reprinted into the text box below
	 *         the input
	 */
	public static String[] toEnglish(String input) {
		if (input == "")
			return new String[] { "" };

		// 1) detect if first letter was vowel or consonant
		// a) if vowel, remove the -way or -yay and return
		// b) if consonant cluster, remove the -ay and move the consonant
		// cluster to the front, then return

		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Character> c = new ArrayList<Character>();
		// create an array list of characters to work with:
		for (char letter : input.toCharArray()) {
			c.add(letter);
		}
		int l = c.size(); // Usage: c[l-X] refers to the Xth to last char
		// Assume the input is already sanitized for spaces/newlines
		// Check that it's actually pig latin:
		if (c.get(l - 1) != 'y') {
			System.out.println("Not pig latin: " + input);
			list.add(input);
			return listToStringArray(list);
		}
		c.remove(l - 1);// remove 'y'
		c.remove(l - 2);// remove 'a'
		l = c.size(); // update size
		// check if the word could have started with a vowel
		if (c.get(l - 1) == 'w' || c.get(l - 1) == 'y') {
			char temp = c.remove(l - 1);
			// l = c.size();
			list.add(listToString(c));
			c.add(temp);
		}
		while (!EnglishToGibberish.isVowel(c.get(l - 1))) {
			// move consonant to front of string
			c.add(0, c.remove(l - 1));
			// add to the list
			list.add(listToString(c));
		}

		// return the list as an array
		return listToStringArray(list);

	}

	private static String listToString(ArrayList<Character> list) {
		String result = "";
		for (Character ch : list) {
			result += ch;
		}
		return result;
	}

	private static String[] listToStringArray(ArrayList<String> list) {
		return Arrays.copyOf(list.toArray(), list.size(), String[].class);
	}

	public static int posFirstVowel(String input) {
		char chr;
		int i = 0;
		for (; i < input.length(); i++) {
			chr = input.charAt(i);
			if (chr == 'a' || chr == 'e' || chr == 'i' || chr == 'o' || chr == 'u')
				break;
		}
		return i;
	}

}
