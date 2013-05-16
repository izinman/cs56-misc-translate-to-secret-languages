package edu.ucsb.cs56.S13.projects.translate_to_secret_languages;
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
/**
 * The class that sets up our GUI to use the englishToPigLatin class
 *
 * @author Christian Rivera Cruz and Adam Kazberuk
 * @author Alex Molina
 * @version CS56, Spring 2013
 * @see englishToPigLatin
 */

public class WindowSetUp extends JApplet implements ActionListener {
    /* Declaration */
    private Container Panel;
    private JTextArea Output;
    private JScrollPane Scroller;

    private JTextField welcomePhrase;
    private JTextField resultPhrase;
    public JTextField t1 = new JTextField(20);
    String[] types = {"English to Pig Latin", 
		      "Pig Latin to English", 
		      "English to Gibberish", 
		      "Gibberish to English"};
    public JComboBox<String> pickt = new JComboBox<String>(types);
    int ty = 1;
    JPopupMenu popup = new JPopupMenu();
    JPopupMenu popup2 = new JPopupMenu();
    /**
     * windowSetUp creates the JPanels that we use for the GUI, which include JTextArea, and JTextField
     */

    public WindowSetUp() {
	/* Instantiation */
	Panel = getContentPane ();
	Output = new JTextArea (30, 10);
	Scroller = new JScrollPane(Output);
	Output.setLineWrap(true);
	Scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	Scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
	welcomePhrase = new JTextField ("Please enter a word or phrase and then press enter:", 30);
	resultPhrase = new JTextField("Result:", 30);
	/* Location */
	Panel.setLayout(new BoxLayout(Panel, BoxLayout.Y_AXIS));
	Panel.add(welcomePhrase);
	welcomePhrase.setEditable(false);
	Panel.add(t1);
	Panel.add(pickt);
	Panel.add(resultPhrase);
	resultPhrase.setEditable(false);
	Panel.add(Scroller);
	// Adds action listener for combobox for choosing translation
    	pickt.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e){
	JComboBox cb = (JComboBox)e.getSource();
        String type = (String)cb.getSelectedItem();
	if(type.equals("English to Pig Latin"))ty = 1;
	if(type.equals("Pig Latin to English"))ty = 2;
	if(type.equals("English to Gibberish"))ty = 3;
	if(type.equals("Gibberish to English"))ty = 4; 
	}});
	// Add cut, copy, and paste to Output TextArea
	JMenuItem cut = new JMenuItem("Cut");
	JMenuItem copy = new JMenuItem("Copy");
	JMenuItem paste = new JMenuItem("Paste");
	popup.add(cut);
	popup.add(copy);
	popup.add(paste);
    	cut.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e){
	    Output.cut();}});
    	copy.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e){
	    Output.copy();}});
    	paste.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e){
	    Output.paste();}});
	Output.setComponentPopupMenu(popup);
	// Add cut, copy paste to t1 TextField
	JMenuItem cut2 = new JMenuItem("Cut");
	JMenuItem copy2 = new JMenuItem("Copy");
	JMenuItem paste2 = new JMenuItem("Paste");
	popup2.add(cut2);
	popup2.add(copy2);
	popup2.add(paste2);
    	cut2.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e){
	    t1.cut();}});
    	copy2.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e){
	    t1.copy();}});
    	paste2.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e){
	    t1.paste();}});
	t1.setComponentPopupMenu(popup2);
	/* Configuration */
	t1.addActionListener(this);
	Output.setEditable (true);
    }

    /**
       actionPerformed is where the translations happen in our code, where the toPigLatin method is invoked
     */

    public void actionPerformed(ActionEvent e) {
	String Action;
	EnglishToPigLatin word1= new EnglishToPigLatin();
	Action = e.getActionCommand ();
	if(ty == 1)
 	Output.setText(word1.toPigLatin(Action));
	if(ty == 2)
 	Output.setText(word1.fromPigLatin(Action));
	if(ty == 3)
 	Output.setText(word1.toGibberish(Action));
	if(ty == 4)
 	Output.setText(word1.fromGibberish(Action));	
	t1.selectAll();
    }     
}

