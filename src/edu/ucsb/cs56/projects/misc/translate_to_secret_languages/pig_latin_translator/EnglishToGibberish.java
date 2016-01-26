package edu.ucsb.cs56.projects.misc.translate_to_secret_languages.pig_latin_translator;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;

/** englishToPigLatin
 @author Christian Rivera Cruz and Adam Kazberuk
 @author Alex Molina
 @version 05/15/2013 for lab05, cs56, S13
*/

public class EnglishToGibberish{
    /** The method that checks to see if the first character passed
     * to it is a vowel or a consonant
     * @param input the first letter of a word
     * @return result which is true when the first letter is a vowel
     */


    public static boolean isVowel(char input)
    {
	boolean result=false;
	    if(input=='a'||input=='A'||input=='e'||input=='E'
	       ||input=='i'||input=='I'||input=='o'
	       ||input=='O'||input=='u'||input=='U'){
		result=true;
	    }
	return result;
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
	public static String toGibberish(String input){
	String result="";
	String toAdd="";
	String words="";
	int i = 0;
	char chr;
	if(input.equals("")){
	return result;}
	StringTokenizer token = new StringTokenizer(input);
	while (token.hasMoreTokens()){
	    words = token.nextToken();	    
	    words.toLowerCase();
	    char[] chararray = words.toCharArray();
		for(int j=0; j<chararray.length; j++){
		    if(isVowel(chararray[j])){
			if(j+1 < chararray.length && isVowel(chararray[j+1])){
			    result+= "uvug";
			    result+= chararray[j];
			    result+= chararray[j+1];
			    j++;}
			else{
			    result+= "uvug";
			    result+= chararray[j];}}
		    else{
			result+= chararray[j];}
		}
		result+= " ";
       	}
		    
		result = result.toLowerCase();
		result = result.trim();
	if(Character.isUpperCase(input.charAt(0))){
	    return Character.toUpperCase(result.charAt(0))
		+ (result.length() > 1 ? result.substring(1) : "");
	}
	else
	    return result;	
	}
/**
 * The method that converts the string from Gibberish to English
 *
 * The method takes a string input, and removes all occurences of "uvug" and "Uvug"
 *
 * @param  input the input is the string typed into the box
 * @return String is returned, and it is reprinted into the text box below the input
 */
    public static String fromGibberish(String input){
	String newstr = input.replaceAll("uvug", "");
	String newerstr;
	char oldletter, newletter;
	if(newstr.charAt(0) == 'U')
	    newerstr = newstr.replaceAll("Uvug", "");
	else
	    return newstr;
	newstr = newerstr.substring(0, 1).toUpperCase() + newerstr.substring(1);
	return newstr;
    }
    /**
       This function makes our GUI for toPigLatin work, setup and other processes are handled in windowSetUp
     */
    public static void go(){
	JFrame f = new JFrame("English to Gibberish Translator");
	f.setSize(400, 200);
	Container content = f.getContentPane();
	content.setBackground(Color.white);
	content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS)); 
	content.add(new WindowSetUp());
	f.setBackground(new Color(0,255,0));
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
    }

    public static int posFirstVowel(String input){
	int count=0;
	int length=input.length();
	char [] chararray;
	chararray = new char[length];
	while(count<input.length()){
	    chararray[count]=input.charAt(count);
	    count++;
	}
	int i=0;
	char chr;
	for(i = 0; i < chararray.length; i++){
	    chr = chararray[i];
	    if(chr == 'a' || chr == 'e' || chr == 'i' 
	       || chr == 'o' || chr == 'u')
		break;
	}
	
	return i;
    }
    public static void main(String [] args){
	go();
    }
}
