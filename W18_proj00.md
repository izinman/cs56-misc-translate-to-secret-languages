Ty Still and Isaac Zinman

Proj00

7 February 2018

1. This project is a translator between english and pig latin and english and “gibberish”
2. User stories for current:
    * As a user, I can type a short sentence to have it translated to pig latin.
    * As a user, I can type a short sentence to have it translated to “gibberish”.
    * As a user, I can type a short sentence in pig latin and have it translated to english with options for possible translations.
    * As a user, I can type a short sentence in “gibberish” and have it translated to english.
3. It does run, there are 3 separate translators, english and pig latin, english and “gibberish”, and a combined translator that has the previous 2 together; however, all sentences are limited to 8 words if they are in the pig latin or combined translator.
4. User stories for future:
    * As a user, I want to be able to translate between pig latin and gibberish.
    * As a user, I want there to be one translator that works between all languages.
    * As a user, I want there to not be a word limit on my sentence.
    * As a user, I want the translator to auto-detect what language I am typing in and set to a translation from that language.
    * As a user, I want to be able to add my own language and temporarily translate to and from that language.
5. The readme has outdated pictures of the gui that need to be updated. Also, the images mess up the indentation making it ugly to look at. However, the readme does a competent job explaining the project's capabilities and how to build and run it.
6. The build.xml file works fine, and has its necessary targets.  It is in Ant, so it could be converted to maven or gradle. Also the code is in 3 separate translators in order to make the build.xml file easier to make, just telling it to compile everything in the folder rather than just compiling parts of the folder by specifying in the build.xml, so that is another issue.
7. Yes, there are enough issues to get to 1000 points and the issues are clear enough to understand what needs doing.
8. We added the full refactor issue: https://github.com/ucsb-cs56-projects/cs56-misc-translate-to-secret-languages/issues/45
9. The code, in general, is a pretty big mess. We will break down the issues with the code into separate sections:
    * **Code duplication.** Currently, there are 3 separate folders in the `src` directory. Supposedly, one of them is for the English and Pig Latin translator, one is for English and Gibberish, and the other one is the combined translator. Setting aside for a moment the question of why they have all 3 instead of just the combined translator, each folder contains copies of the same classes, which is just ridiculous and presumably done as a shortcut to make the build process brainlessly easy. Modifying the build file to conditionally compile some of the classes based on the build target would not only be easy but would make the project filesystem much simpler.
    * **Poor code styling, naming, and readability.** Almost all of the functions in the code have problems. Many are bloated (one is almost 150 lines long) and should be condensed into a much smaller function with several calls to helper functions. In general, readability is poor: although there are javadoc comments before each function, the descriptions are often outdated, and non-obvious blocks of code within a function are not commented. Indentation and style are all over the place. The code switches unpredictably between unnecessarily verbose:
    ```java
    // Note: condensed ‘condition’ from original code for readability
    boolean result = false;
    if (condition) result = true;
    return result;
    ```
    
    And confusingly terse:
    
    ```java
    if(Character.isUpperCase(input.charAt(0))){ 	 
    return Character.toUpperCase(result.charAt(0)) + (result.length() > 1 ? result.substring(1) : "");
    }
    ```
    
    (examples taken from EnglishToGibberish.java)
    
    * **Classes and encapsulation.** Furthermore, the classes do not represent logical units of code. The class WindowSetUp.java sounds like a helper class to instantiate the GUI, but is in fact a bloated class which contains the entire GUI and does most of the work for the actual translation, poorly encapsulating the different functionalities required to do the translation. Even the translator classes are poorly named; EnglishToGibberish.java actually handles both directions of translation for English and Gibberish. In summary, the code is in a deplorable state and is in major need of a full refactor.


10. The test coverage in EnglishToGibberishTester.java is minimal, having only four methods to test different possibilities of translations, when it is used for testing translations in both directions, as compared to EnglishToPigLatinTester.java, and the opposite, which separately each have more than double the number of tests.  The gibberish tester doesn’t even have a test for an empty string, as each of the others does.
