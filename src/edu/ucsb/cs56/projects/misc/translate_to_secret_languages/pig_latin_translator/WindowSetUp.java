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

/**
 * The class that sets up the GUI to use the EnglishToPigLatin class
 @author Christian Rivera Cruz                                                                                                                               
 @author Adam Kazberuk                                                                                                                                       
 @author Ian Vernon                                                                                                                                          
 @author Evan Moelter                                                                                                                                        
 @version 05/17/2013 for lab05, cs56, S13         
 */

public class WindowSetUp extends JApplet{
    /* Declaration */
    private Container Panel;
    private JTextArea Output;
    private JPanel boxPanel;
    private JScrollPane Scroller;

    private JTextField welcomePhrase;
    private JTextField resultPhrase;
    private TextField t1 = new TextField(20);
    private JTextField wordBoxesPhrase;

    private  JButton engToPig;
    private  JButton pigToEng;
    private ArrayList<JComboBox<String>> wordBoxes;
    
    /**
     * windowSetUp creates the JPanels that we use for the GUI, which include JTextArea, JTextField, JButton, JComboBox
     */

    public WindowSetUp() {
	/* Instantiation */
	Panel = getContentPane ();

	Output = new JTextArea (30, 10);
	Scroller = new JScrollPane(Output);
	Output.setLineWrap(true);
	Scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	Scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
	welcomePhrase = new JTextField ("Please enter a word or phrase of 8 words or less:", 30);
	engToPig = new JButton("English To Pig Latin");
        pigToEng = new JButton("Pig Latin To English");
	resultPhrase = new JTextField("Result:", 30);
	wordBoxesPhrase = new JTextField("Select the correct English translation from each box when using Pig Latin To English;", 30);
	boxPanel = new JPanel();
	wordBoxes = new ArrayList<JComboBox<String>>();
	
	/* Location */
	Panel.setLayout(new BoxLayout(Panel, BoxLayout.Y_AXIS));
	Panel.add(welcomePhrase);
	welcomePhrase.setEditable(false);
	Panel.add(t1);
	Panel.add(engToPig);
	Panel.add(pigToEng);
	Panel.add(resultPhrase);
	resultPhrase.setEditable(false);
	Panel.add(Scroller);
	Panel.add(wordBoxesPhrase);
	wordBoxesPhrase.setEditable(false);
	Panel.add(boxPanel);
	for(int i = 0; i < 8; i++)
	    {
		wordBoxes.add(i, new JComboBox<String>());
		boxPanel.add(wordBoxes.get(i));
		wordBoxes.get(i).addActionListener(new BoxListener());
	    }

    
	/* Configuration */
	engToPig.addActionListener(new EngToPigListener());
	pigToEng.addActionListener(new PigToEngListener());
	Output.setEditable (false);
    }

    /**
       inner class for when Pig Latin to English button is selected
    */

    public class PigToEngListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e){
	    EnglishToPigLatin word1 = new EnglishToPigLatin();
	    //split wonrds inputted by user into array of strings so each word can be analzyed / translated
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
			    for(int optionNum = 0; optionNum < pigLatinTrans.length && optionNum < 5; optionNum++)
				{
				    wordBoxes.get(boxNum).addItem(pigLatinTrans[optionNum]);
				}
			}
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
    
    }

    /** 
	inner class for when English to Pig Latin is selected
    */
    public class EngToPigListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e){
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
	String pigLatinOutput = "";
	for(int boxNum = 0; boxNum < 8; boxNum++)
	    {
		String t = (String)wordBoxes.get(boxNum).getSelectedItem();
		if (t != null) 
		    pigLatinOutput += t + " ";
	    }
	Output.setText(pigLatinOutput);
    }

}

