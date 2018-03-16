W18: Isaac Zinman and Ty Still  
##Issues and features:

1. Add scroller for windows(100 pts):  
When you hit font style and the change font style window pops up, there is no scrolling functionality so if you want to see all the fonts you need to enlarge the window. Add scrolling functionality so you can just scroll down if the window is too small to display all fonts. This should be done for all window pop ups.  
2. Improve PigLatin->English word limit(200 pts):  
Currently, PigLatin->English translation always shows 8 dropdown boxes for ambiguous translations, limited input to 8 words. Try to find ways to increase this limit, possibly by generating dropdown boxes dynamically based on the number of ambiguous words, up to a certain amount.  
3. Remove English -> Pig Latin word limit(150 pts):  
Currently, English->Pig Latin translation only allows 8 words maximum. This reflects the limited number of dropdown boxes for translating Pig Latin->English, but this limit should not be necessary in the English->Pig Latin direction. Remove it.  
4. Add a switch to toggle translation direction(50 pts):  
Add a button which switches the direction of translation. As the code stands now, if someone is translating from say English to Pig Latin wants to translate Pig Latin to English instead, they must select the option from the drop down menu. Add a button that would switch the translate direction with one click, similar to Google Translate.  
5. (extra, not yet okay'd) Pig Latin translation fails on all caps letters(50 pts possibly):  
The current method of translating a word to Pig Latin does not account for the fact that the first vowel in the word could be capitalized.  
