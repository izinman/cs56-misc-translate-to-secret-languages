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
 * The class that sets up our GUI to use the englishToPigLatin class
 *
 * @author Christian Rivera Cruz, and Adam Kazberuk
 * @version CS56, Spring 2012
 * @see englishToPigLatin
 */

public class WindowSetUp extends JApplet{
    /* Declaration */
    private Container Panel;
    private JTextArea Output;
    private JScrollPane Scroller;

    private JTextField welcomePhrase;
    private JTextField resultPhrase;
    public TextField t1 = new TextField(20);

    public JButton engToPig;
    public JButton pigToEng;
    public JPanel boxPanel;
    public ArrayList<JComboBox<String>> wordBoxes;
    
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
	Panel.add(boxPanel);
	for(int i = 0; i < 8; i++)
	    {
		wordBoxes.add(i, new JComboBox<String>());
		boxPanel.add(wordBoxes.get(i));
	    }

    
	/* Configuration */
	//t1.addActionListener(new TextListener);
	engToPig.addActionListener(new EngToPigListener());
	pigToEng.addActionListener(new PigToEngListener());
	//t1.setActionCommand ("text");
	Output.setEditable (false);
    }

    public class PigToEngListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e){
	    EnglishToPigLatin word1 = new EnglishToPigLatin();
	    String[] words = t1.getText().split(" ");
	    for(int boxNum = 0; boxNum < 8 && boxNum < words.length; boxNum++)
		{
		    String currentWord = words[boxNum];
		    String[] pigLatinTrans = word1.toEnglish(currentWord);
		    
		    for(int optionNum = 0; optionNum < pigLatinTrans.length && optionNum < 5; optionNum++)
			{
			    wordBoxes.get(boxNum).addItem(pigLatinTrans[optionNum]);
			}
		}
	    String pigLatinOutput = "";
	    for(int boxNum = 0; boxNum < 8 || boxNum < words.length; boxNum++)
		{
		    pigLatinOutput += wordBoxes.get(boxNum).getItemAt(0) + " ";
		}
	    Output.setText(pigLatinOutput);
	    t1.selectAll();
	}
    
    }
    public class EngToPigListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e){
	    String Action;
	    EnglishToPigLatin word1 = new EnglishToPigLatin();
	    Action = t1.getText();
	    Output.setText(word1.toPigLatin(Action));
	    t1.selectAll();
	}
	
    }
}

