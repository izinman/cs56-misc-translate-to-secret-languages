package edu.ucsb.cs56.projects.misc.translate_to_secret_languages.pig_latin_translator;
	    //check to see if phrase length is less than or equal to number of boxes to fill with word options
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;

import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.WindowConstants;


import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.util.ArrayList;

import java.io.*;
/*
import java.io.PrintStream;
import java.io.File;
*/

/**
 * The class that sets up the GUI to use the EnglishToPigLatin class
 @author Christian Rivera Cruz                                                                                                                               
 @author Adam Kazberuk                                                                                                                                       
 @author Ian Vernon                                                                                                                                          
 @author Evan Moelter

 @author Nicholas Frey

 @author John Mangel                                                                                                                                        
 @version 02/XX/2016 for lab07, cs56, W16         
 */

public class WindowSetUp extends JApplet implements ActionListener{
    /* Declaration */
    private Container Panel;
    private JTextArea Output;
    private JPanel boxPanel;
    private JScrollPane Scroller;

    private JTextField welcomePhrase;
    private JTextField resultPhrase;
    private TextField t1 = new TextField(20);
    private JTextField wordBoxesPhrase;

    private JTextArea helpText;

    String[] types = {"English to Pig Latin", "Pig Latin to English"};
    public JComboBox<String> choose = new JComboBox<String>(types);
    int direction = 1;

      private JButton helpButton;
    private ArrayList<JComboBox<String>> wordBoxes;

		private ArrayList<Tuple> wordBoxSelections = new ArrayList<Tuple>();
    private boolean resettingBoxes=false;
    /**
     * windowSetUp creates the JPanels that we use for the GUI, which include JTextArea, JTextField, JButton, JComboBox
     */

    public WindowSetUp() {
	/* Instantiation */
	int opacity = (int)(255*.8);
  Color myOrange = new Color(255,116,0,opacity);
  Color myBlue = new Color(18,64,171,opacity);
  Color myYellow = new Color(255,211,0,opacity);
  Color myGray = new Color(60,59,56);

	Panel = getContentPane();
	Panel.setBackground(myBlue);	
	Output = new JTextArea (30, 10);
	Scroller = new JScrollPane(Output);
	Output.setLineWrap(true);
	Scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	Scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
	helpButton = new JButton("Help/Instructions");
	helpButton.setBackground(myYellow);
	welcomePhrase = new JTextField ("Please enter a word or phrase of 8 words or less:", 30);
	welcomePhrase.setBackground(myYellow);
	resultPhrase = new JTextField("Result:", 30);
	resultPhrase.setBackground(myYellow);
	wordBoxesPhrase = new JTextField("Select the correct English translation from each box when using Pig Latin To English;", 30);
	boxPanel = new JPanel();
	wordBoxes = new ArrayList<JComboBox<String>>();
	
	/* Location */
	Panel.setLayout(new BoxLayout(Panel, BoxLayout.Y_AXIS));
	JPanel crossPane = new JPanel();
	crossPane.setLayout(new BoxLayout(crossPane, BoxLayout.X_AXIS));
	crossPane.add(helpButton);
	Panel.add(crossPane);
	Panel.add(welcomePhrase);
	welcomePhrase.setEditable(false);
	Panel.add(t1);
  Panel.add(choose);

  choose.addActionListener(new ChooseListener());

	Panel.add(resultPhrase);
	resultPhrase.setEditable(false);
	Panel.add(Scroller);
	Panel.add(wordBoxesPhrase);
	wordBoxesPhrase.setEditable(false);
	Panel.add(boxPanel);
	for(int i = 0; i < 8; i++)
	    {
		wordBoxes.add(i, new JComboBox<String>());
		wordBoxes.get(i).setBackground(myYellow);
		boxPanel.add(wordBoxes.get(i));
		wordBoxes.get(i).addActionListener(new BoxListener());
	    }

  /* Read PigLatin to English Selection from file */
	try{
		FileInputStream fis = new FileInputStream(new File("src/edu/ucsb/cs56/projects/misc/translate_to_secret_languages/PigLatinSelections.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line = null;
		while ((line = br.readLine()) != null) {
			String[] tupleArgs = line.split(" ");
			wordBoxSelections.add(new Tuple(tupleArgs[0],Integer.parseInt(tupleArgs[1])));
		}
		br.close();
	} catch (Exception ex){
		System.err.println("Error reading from file. Ignore this warning if you haven't yet used PigLatin to English, because the file doesn't not yet exist.");
	}
	/* Configuration */
	
  t1.addActionListener(this);

	helpButton.addActionListener(new HelpListener());
	Output.setEditable (false);
    }

    /** actionPerformed is where the translation happens in our code, where the toPigLatin method is invoked
    */

  public void actionPerformed(ActionEvent e) {
    if (direction ==1) translateEngToPig();
    if (direction ==2) translatePigToEng();
    t1.selectAll();
  }

		/**
 				inner class for when choose box is changed
		*/

		public class ChooseListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				String type = (String)choose.getSelectedItem();
				if(type.equals("English to Pig Latin")) direction =1;
				if (type.equals("Pig Latin to English")) direction =2;
			}
		}

    /**
       inner class for when Help button is selected
    */
    
    public class HelpListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e){
	    JFrame f2 = new JFrame("Help/Instructions");
	    f2.setSize(600,400);
	    Container Panel2 = f2.getContentPane();

	    helpText = new JTextArea (20, 20);
	    helpText.setLineWrap(true);
	    helpText.setText("The usual rules for changing standard English into Pig Latin are as follows: \nFor words that begin with consonant sounds, the initial consonant or consonant cluster is\nmoved to the end of the word, and 'ay' is added \n    For example: 'glove' → 'oveglay' 'happy'→'appyhay'  \nFor words that begin with vowel sounds or silent letter, 'way' is added at the end of the word.\n    For example: 'egg' → 'eggway' 'inbox' → 'inboxway' \nIn some variants, though, just add an 'ay' at the end. 'egg' → 'eggay'\nAnother variant is to add the ending 'yay'. 'egg' → 'eggyay' \n\nType in the words you wish to translate, then click on the correct option.\nPlease only enter words or phrases of less than 8 words ");
	    Panel2.add(helpText);
	    helpText.setEditable(false);
      
	    f2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    f2.setVisible(true);
	}
    }

    /**
    	method to translate piglatin to english 
    */

		public void translatePigToEng(){
	    resettingBoxes=true;
			EnglishToPigLatin word1 = new EnglishToPigLatin();
	    //split words inputted by user into array of strings so each word can be analzyed / translated
	    String[] words = t1.getText().split(" ");
	    //check to see if phrase length is less than or equal to number of boxes to fill with word options
	    if(words.length <= 8)
			{
		    resultPhrase.setText("Result In English:");
		    //iterate through each JComboBox
		    for(int boxNum = 0; boxNum < 8 && boxNum < words.length; boxNum++)
				{
					String currentWord = words[boxNum];
			    /*convert each word to English and give options in a String array. done so since
			      impossible to tell when  English word starts and ends after translated into Pig Latin*/
			    String[] pigLatinTrans = word1.toEnglish(currentWord);
			    /*refresh each JComboBox with 5 options / selectable words  for word in English */
    			wordBoxes.get(boxNum).removeAllItems();
					wordBoxes.get(boxNum).addItem(""); //index=0?
			    for(int optionNum = 0; optionNum < pigLatinTrans.length && optionNum < 5; optionNum++)
					{
				    wordBoxes.get(boxNum).addItem(pigLatinTrans[optionNum]);
					}
					wordBoxes.get(boxNum).setSelectedIndex(0);
				}
				resettingBoxes=false;
		    // updates each JComboBox
		    updateOutput();
		    t1.selectAll();
		}
	    // if number of words is greater than 8
	    else
		{
		    JOptionPane.showMessageDialog(null, "Amount of words greater than 8. Please try again.", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	

    /** 
			method to translate english to piglatin
    */
		
		public void translateEngToPig(){
	    String phrase;
	    EnglishToPigLatin word1 = new EnglishToPigLatin();
	    phrase = t1.getText();
	    if(phrase.split(" ").length <= 8)
		{
		    resultPhrase.setText("Result In Pig Latin:");
		    //converts to Pig latin
		    Output.setText(word1.toPigLatin(phrase));
		    t1.selectAll();
		}
	    // output error if more than 8 words inputted
	    else
		{
		    JOptionPane.showMessageDialog(null, "Amount of words greater than 8. Please try again.", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
    
    /**
       inner class for when JComboBox is updated
    */
    
    public class BoxListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e)
	{
	    updateOutput();			
	}
    }
    
    /**
       Updates the output box with phrase in each text box
     */
		private void updateOutput() {
			if (resettingBoxes) return;
			String pigLatinOutput = "";
			boolean wordFound = false;
			boolean listChanged = false;
			String[] words = t1.getText().split(" ");
			for(int boxNum = 0; boxNum < 8 && boxNum < words.length; boxNum++){
				wordFound = false;
				for (Tuple tuple: wordBoxSelections){
					if (tuple.input.equals(words[boxNum])){ // && t!= null && t!="") {
						wordFound = true;
						if (wordBoxes.get(boxNum).getSelectedIndex()<=0 && wordBoxes.get(boxNum).getItemCount()>0){
							//they haven't chosen yet, set choice to tuple.translation
							wordBoxes.get(boxNum).setSelectedIndex(tuple.translation);
						}
						else if (wordBoxes.get(boxNum).getSelectedIndex()>0 && tuple.translation!=wordBoxes.get(boxNum).getSelectedIndex()) { //selection has been made, save it in ArrayList
							tuple.translation = wordBoxes.get(boxNum).getSelectedIndex();
							listChanged = true;
						//this is called when the dropdown is selected
						//so we want to save the choice when it's selected 
						}
					}
				}
				if (!wordFound && wordBoxes.get(boxNum).getSelectedIndex()>0) {
					int index = wordBoxes.get(boxNum).getSelectedIndex();
					Tuple newEntry = new Tuple(words[boxNum], index);
					wordBoxSelections.add(newEntry);
					listChanged = true;
				}
				String t = (String)wordBoxes.get(boxNum).getSelectedItem();
				if (t != null) pigLatinOutput += t + " ";
	  	}
			Output.setText(pigLatinOutput);
			
			if (listChanged){
				//write to file
				try{
					PrintStream writer = new PrintStream(new File("src/edu/ucsb/cs56/projects/misc/translate_to_secret_languages/PigLatinSelections.txt"));
					for (Tuple tuple: wordBoxSelections){
						writer.println(tuple.input + " " + tuple.translation);
					}
					writer.close();
					System.err.println("Wrote to file");
				} catch(Exception ex){
					System.err.println("Error in writing to file");
					ex.printStackTrace();
				}
			}
		}

	public class Tuple{ 
  	public final String input; 
  	public int translation; 
  	public Tuple(String input, int translation) { 
    	this.input = input; 
    	this.translation = translation; 
  	} 
	}        
}
