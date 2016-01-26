project history
===============
```
 NO | mastergberry | Make a program that takes an English word or small sentence and translate it into Pig Latin and Gibberish 
```

A simple GUI program to translate between pig latin/english, and also between gibberish/english. 

![Alt text](https://raw.githubusercontent.com/isaacstaugaard/cs56-misc-translate-to-secret-languages/master/ScreenshotsForReadme/anttargets.png?raw=true)
To run the combined translator: Use the command 'ant Run'
To run the pig latin/english translator: Use the command: 'ant PigLatin'
To run the gibberish/english translator: Use the command: 'ant Gibberish'

Once run, simply type the words you wish to be translated into the empty box under "Please enter a word or phrase of 8 words or less:" and perss the conversion you want. The result will be displayed in the box under "Result". 
You press the "Font Style" button or the "Font Color" button to change the font. 
To view the rules in the GUI, press the Help button.


The rules of pig latin (from wikipedia):

The usual rules for changing standard English into Pig Latin are as follows:
For words that begin with consonant sounds, the initial consonant or consonant cluster is moved to the end of the word, and "ay" is added, as in the following examples:
![Alt text](https://raw.githubusercontent.com/isaacstaugaard/cs56-misc-translate-to-secret-languages/master/ScreenshotsForReadme/piglatinex.png?raw=true)
    "happy" → "appyhay"
    "duck" → "uckday"
    "glove" → "oveglay"
For words that begin with vowel sounds or silent letter, "way" is added at the end of the word. Examples are
    "egg" → "eggway"
    "inbox" → "inboxway"
    "eight" → "eightway"
In some variants, though, just add an "ay" at the end.
   "egg" → "eggay"
Yet another acceptable variant is to add the ending "yay" to words that begin with a vowel sound.
    "egg" → "eggyay"



The rules of our gibberish program:

 The conversion for changing standard English into gibberish are as follows: 
 The string 'uvug' is randomly placed into the word to be translated, possibly many times. 
 For example:
 ![Alt text](https://raw.githubusercontent.com/isaacstaugaard/cs56-misc-translate-to-secret-languages/master/ScreenshotsForReadme/gibberishex.png?raw=true)
    "hello" -> "huvugelluvugo"
    "hi my name is conrad" -> "huvugi my nuvugamuvuge uvugis cuvugonruvugad"
 
 Some extra instructions: The combined translator contains both the Gibberish and PigLatin translators. It contains a help function detailing the procedure and rules of the languages. There are also new buttons for changing the font. To change the font, simply press the button you wish and select a font or color.

To run the code:

ant PigLatin: to only translate between Pig Latin and English

ant Gibberish: to only translate between Gibberish and English

ant Run: to run both translations in one menu
