project history
===============
```
 NO | mastergberry | Make a program that takes an English word or small sentence and translate it into Pig Latin and Gibberish 
```

A simple GUI program to translate between pig latin/english, and also between gibberish/english. 

To run the pig latin/english translator: Use the command: 'ant PigLatin'
To run the gibberish/english translator: Use the command: 'ant Gibberish'

Once run, simply type the words you wish to be translated into the empty box under "Please enter a word or phrase of 8 words or less:" and perss the conversion you want. The result will be displayed in the box under "Result". 


The rules of pig latin (from wikipedia):

The usual rules for changing standard English into Pig Latin are as follows:
For words that begin with consonant sounds, the initial consonant or consonant cluster is moved to the end of the word, and "ay" is added, as in the following examples:
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
    "hello" -> "huvugelluvugo"
    "hi my name is conrad" -> "huvugi my nuvugamuvuge uvugis cuvugonruvugad"
 
 JavaDoc: http://www.cs.ucsb.edu/~ianvernon/cs56/S12/issues/0000773/javadoc
