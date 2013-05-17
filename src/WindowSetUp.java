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
 *
 * @author Christian Rivera Cruz, Adam Kazberuk, Evan Moelter, Ian Vernon
 * @version CS56, Spring 2013
 * @see EnglishToPigLatin
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
	    String[] words = t1.getText().split(" ");
	    if(words.length <= 8)
		{
		    resultPhrase.setText("Result In English:");
		    for(int boxNum = 0; boxNum < 8 && boxNum < words.length; boxNum++)
			{
			    String currentWord = words[boxNum];
			    String[] pigLatinTrans = word1.toEnglish(currentWord);
			    wordBoxes.get(boxNum).removeAllItems();
			    for(int optionNum = 0; optionNum < pigLatinTrans.length && optionNum < 5; optionNum++)
				{
				    wordBoxes.get(boxNum).addItem(pigLatinTrans[optionNum]);
				}
			}
		    updateOutput();
		    /*   String pigLatinOutput = "";
			 for(int boxNum = 0; boxNum < 8 && boxNum < words.length; boxNum++)
			 {
			 pigLatinOutput += wordBoxes.get(boxNum).getSelectedItem() + " ";
			 }
			 Output.setText(pigLatinOutput);
		    */
		    t1.selectAll();
		}
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
	    String Action;
	    EnglishToPigLatin word1 = new EnglishToPigLatin();
	    Action = t1.getText();
	    if(Action.split(" ").length <= 8)
		{
		    resultPhrase.setText("Result In Pig Latin:");
		    Output.setText(word1.toPigLatin(Action));
		    t1.selectAll();
		}
	    else
		{
		    JOptionPane.showMessageDialog(null, "Amount of words greater than 8. Please try again.", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
    }
    
    public class BoxListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e)
	{
	    updateOutput();
	    /*
	    String pigLatinOutput = "";
	    for(int boxNum = 0; boxNum < 8; boxNum++)
			pigLatinOutput += wordBoxes.get(boxNum).getSelectedItem() + " ";
	    Output.setText(pigLatinOutput);
	    t1.selectAll();
	    */
	}
    }

    /**
       Updates the output box
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
	//t1.selectAll();
	//return pigLatinOutput;
    }

}

