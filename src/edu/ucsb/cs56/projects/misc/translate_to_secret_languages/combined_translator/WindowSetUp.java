package edu.ucsb.cs56.projects.misc.translate_to_secret_languages.combined_translator;
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

 @author Nicholas Frey

 @author John Mangel                                                                                                                                        
 @version 05/17/2013 for lab05, cs56, S13         
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

    private JButton helpButton;
    private JButton fontButton;
    private JButton fColorButton;
    private ArrayList<JComboBox<String>> wordBoxes;
    String[] types = {"English to Pig Latin", "Pig Latin to English", "English to Gibberish", "Gibberish to English"};
    public JComboBox<String> choose = new JComboBox<String>(types);
    int direction = 1;

    private JFrame f3 = new JFrame("Change Font Style");
    private JFrame f4 = new JFrame("Change Font Color");
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

	Panel = getContentPane ();
	Panel.setBackground(myBlue);
	Output = new JTextArea (30, 10);
	Scroller = new JScrollPane(Output);
	Output.setLineWrap(true);
	Scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	Scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
	helpButton = new JButton("   Help   "); //spaces to make buttons the same size
	fontButton = new JButton("Font Style");
	fColorButton = new JButton("Font Color");
	helpButton.setBackground(myYellow);
	fontButton.setBackground(myYellow);
	fColorButton.setBackground(myYellow);

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
	crossPane.add(fontButton);
	crossPane.add(fColorButton);
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
    
	/* Configuration */
	helpButton.addActionListener(new HelpListener());
	fontButton.addActionListener(new FontListener());
	fColorButton.addActionListener(new fColorListener());
  t1.addActionListener(this);
	Font DefFont = new Font("Times New Roman",Font.PLAIN,15);
	t1.setFont(DefFont);
	Output.setFont(DefFont);

	Output.setEditable (false);

  /* instantiate color window */
  f4.setSize(200,200);
  Container Panel4 = f4.getContentPane();
  Panel4.setLayout(new BoxLayout(Panel4, BoxLayout.Y_AXIS));
  
  //JPanel Panel4 = new JPanel(new GridLayout(4,1));
  JButton Red = new JButton("Red");
  JButton Green = new JButton("Green");
  JButton Blue = new JButton("Blue");
  JButton Black = new JButton("Black");
  //Red.setSize(new Dimension(100, 40));
  Panel4.add(Red, BorderLayout.NORTH);
  Panel4.add(Green);
  Panel4.add(Blue);
  Panel4.add(Black);
  Red.addActionListener(new RedListener());
  Green.addActionListener(new GreenListener());
  Blue.addActionListener(new BlueListener());
  Black.addActionListener(new BlackListener());

  /* instantiate font window */
  f3.setSize(200,200);
  Container Panel3 = f3.getContentPane();
  Panel3.setLayout(new BoxLayout(Panel3, BoxLayout.Y_AXIS));

  JButton Default = new JButton("Default");
  JButton Bold = new JButton("Bold");
  JButton Italics = new JButton("Italics");
  JButton Courier = new JButton("Courier");
  JButton Serif = new JButton("Serif");
  Panel3.add(Default);
  Panel3.add(Bold);
  Panel3.add(Italics);
  Panel3.add(Courier);
  Panel3.add(Serif);
  Default.addActionListener(new DefListener());
  Bold.addActionListener(new BoldListener());
  Italics.addActionListener(new ItalListener());
  Courier.addActionListener(new CourListener());
  Serif.addActionListener(new SerifListener());  

    }

  public void actionPerformed(ActionEvent e) {
    if (direction ==1) translateEngToPig();
    if (direction ==2) translatePigToEng();
    if (direction ==3) translateEngToGib();
    if (direction ==4) translateGibToEng();
    t1.selectAll();
    }

  /** inner class for when choose is selected */

  public class ChooseListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
        String type = (String)choose.getSelectedItem();
        if(type.equals("English to Pig Latin")) direction =1;
        if (type.equals("Pig Latin to English")) direction =2;
        if (type.equals("English to Gibberish")) direction =3;
        if (type.equals("Gibberish to English")) direction = 4;
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
	    helpText.setText("The usual rules for changing standard English into Pig Latin are as follows: \nFor words that begin with consonant sounds, the initial consonant or consonant cluster is\nmoved to the end of the word, and 'ay' is added \n    For example: 'glove' → 'oveglay' 'happy'→'appyhay'  \nFor words that begin with vowel sounds or silent letter, 'way' is added at the end of the word.\n    For example: 'egg' → 'eggway' 'inbox' → 'inboxway' \nIn some variants, though, just add an 'ay' at the end. 'egg' → 'eggay'\nAnother variant is to add the ending 'yay'. 'egg' → 'eggyay' \n\nThe rules used for changing English into Gibberish in this program:\nThe string 'uvug' is randomly placed into the word to be translated, possibly many times.\n    For example: 'hi i am prof conrad' -> 'huvugi uvugi uvugam pruvugof cuvugonruvugad'\n\nType in the words you wish to translate, then click on the correct option\nPlease only enter words or phrases of less than 8 words ");
	    Panel2.add(helpText);
	    helpText.setEditable(false);
      
	    f2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    f2.setVisible(true);
	}
    }
    
    /**
       inner class for when Font button is selected
    */
    
    public class FontListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e){
	    f3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    f3.setVisible(true);
	}
    }

    /**
       inner class for when fColor button is selected
    */

  public class fColorListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e){
	    f4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    f4.setVisible(true);
	}
    }

    /**
       inner class for when Pig Latin to English button is selected
    */

    //public class PigToEngListener implements ActionListener
    //{
	public void translatePigToEng(){
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
	
    //}

    /** 
	inner class for when English to Pig Latin is selected
    */
    //public class EngToPigListener implements ActionListener
    //{
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
	
    //}
    
    /**
       inner class for when Gibberish to English is selected 
    */
    
    //public class GibToEngListener implements ActionListener
    //{
	public void translateGibToEng(){
	    String phrase;
	    EnglishToGibberish word1 = new EnglishToGibberish();
	    phrase = t1.getText();
	    if(phrase.split(" ").length <= 8)
		{
		    resultPhrase.setText("Result in English");
		    //converts to English
		    Output.setText(word1.fromGibberish(phrase));
		    t1.selectAll();
		}
	}
   // }
    

    /** 
	inner class for when English to Gibberish is selected
    */
    
     //public class EngToGibListener implements ActionListener
    //{
	public void translateEngToGib(){
	    String phrase;
	    EnglishToGibberish word1 = new EnglishToGibberish();
	    phrase = t1.getText();
	    if(phrase.split(" ").length <= 8)
		{
		    resultPhrase.setText("Result in Gibberish");
		    //converts to Gibberish
		    Output.setText(word1.toGibberish(phrase));
		    t1.selectAll();
		}
	}
    //}
    
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
    

    public class DefListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e){
	    Font DefFont = new Font("Times New Roman",Font.PLAIN,15);
	    t1.setFont(DefFont);
	    Output.setFont(DefFont);
      f3.dispose();
	}
    }

    public class BoldListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e){
	    if(t1.getFont().isBold() == false){
		t1.setFont(t1.getFont().deriveFont(Font.BOLD));
		Output.setFont(Output.getFont().deriveFont(Font.BOLD));
	    }
	    else{
		t1.setFont(t1.getFont().deriveFont(Font.PLAIN));
		Output.setFont(Output.getFont().deriveFont(Font.PLAIN));
		
	    }
    f3.dispose();
	}
	
    }
 public class ItalListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e){
	    if(t1.getFont().isItalic() == false){
		t1.setFont(t1.getFont().deriveFont(Font.ITALIC));
		Output.setFont(Output.getFont().deriveFont(Font.ITALIC));
	    }
	    else{
		t1.setFont(t1.getFont().deriveFont(Font.PLAIN));
		Output.setFont(Output.getFont().deriveFont(Font.PLAIN));
	    }
    f3.dispose();
	}
    }
	    
    public class CourListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e){
	    Font courierFont = new Font("Courier",Font.PLAIN,15);
	    t1.setFont(courierFont);
	    Output.setFont(courierFont);
      f3.dispose();
	}
    }
    
    public class SerifListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e){
	    Font SerifFont = new Font("Serif",Font.PLAIN,15);
	    t1.setFont(SerifFont);
	    Output.setFont(SerifFont);
      f3.dispose();
	}
    }

    public class RedListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e){
	    t1.setForeground(Color.RED);
	    Output.setForeground(Color.RED);
      f4.dispose();
	}
    }
    
    public class GreenListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e){
	    t1.setForeground(Color.GREEN);
	    Output.setForeground(Color.GREEN);
	    f4.dispose();
  }
    }

    public class BlueListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e){
	    t1.setForeground(Color.BLUE);
	    Output.setForeground(Color.BLUE);
	    f4.dispose();
  }
    }

    public class BlackListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e){
	    t1.setForeground(Color.BLACK);
	    Output.setForeground(Color.BLACK);
	    f4.dispose();
  }
    }
}
