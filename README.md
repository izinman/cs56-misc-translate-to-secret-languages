
**Translate to Secret Languages**
=================================

A simple GUI program to translate between pig latin/english, gibberish/english, and obish/english.  
**Main targets**:  
 **run**: run the combined PigLatin/Gibberish/Obish Translator program  
 **clean**: delete unnecessary files and directories  
 **compile**: compile the java files  
 **test**: test Translator classes  
Default target: compile

To run the combined translator: Use the command **ant run**. Once run, simply type the words you wish to be translated into the empty box under "Please enter a word or phrase of 8 words or less:" and press the conversion you want. The result will be displayed in the box under "Result".
You press the "Font Style" button or the "Font Color" button to change the font. 
To view the rules in the GUI, press the Help button.


The rules of pig latin ([from wikipedia](https://en.wikipedia.org/wiki/Pig_Latin)):

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



The rules of our gibberish program ([from wikipedia](https://en.wikipedia.org/wiki/Gibberish_(language_game))):

 The conversion for changing standard English into gibberish are as follows(in our program, not officially): 
 The string 'uvug' is placed into the word to be translated, before each vowel, not including 'y'. That could be added for future functionality for words that don't have another vowel like "my" → "muvugy"  
 For example:  
 ![Alt text](https://raw.githubusercontent.com/isaacstaugaard/cs56-misc-translate-to-secret-languages/master/ScreenshotsForReadme/gibberishex.png?raw=true)  
    "hello" → "huvugelluvugo"  
    "hi my name is conrad" → "huvugi my nuvugamuvuge uvugis cuvugonruvugad"
 
 Some extra instructions: The combined translator contains the Gibberish, PigLatin and Obish translators. It contains a help function detailing the procedure and rules of the languages. There are also new buttons for changing the font. To change the font, simply press the button you wish and select a font or color.

W16 Final Remarks - Nicholas Frey and John Mangel
The project at its current state has 3 GUI's, one for Pig Latin, one for Gibberish, and a combined translator. There arent really any bugs but there are a lot of features that we think could be added! See the issues tab on the github or in . One large issue we never got to was fixing the indentation across all files. We reccomend fixing this as you go through and try to understand the code. Enjoy!
Make sure you familiarize yourself with the code before you start working! 


W18 Final Remarks:  
-Isaac Zinman and Ty Still  
We made major behind the scenes changes to previous versions of this project, cleaning up much of the code to be more object-oriented and generally more logical in its structure, and as such didn't make many outward changes. We did add another language to the translator, and since we abstracted the insertion language class, future contributors can add more of those with less effort, or even let the user "make" their own insertion language.  The GUI needs updating and cleaning up as there are a few visual bugs in it and it is generally not very attractive, and there are a variety of other issues that could be fixed. 
Notes about code structure: The "translation logic" is handled by the Translator classes which are never instantiated but their static methods are called by the GUI class, WindowSetUp. WindowSetUp has a weird way of passing information between components and ActionListeners and should probably be split up into several smaller files.
Good luck with this project!