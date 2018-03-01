import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.io.*;

/**
 * The class that sets up the GUI to use the EnglishToPigLatin class
 *
 * @author Christian Rivera Cruz
 * @author Adam Kazberuk
 * @author Ian Vernon
 * @author Evan Moelter
 *
 * @author Nicholas Frey
 *
 * @author John Mangel
 * @author Isaac Zinman
 * @version 02/22/18 for legacy project, cs56, W18 - fully refactored by IZ
 */

@SuppressWarnings("serial")
public class WindowSetUp extends JApplet implements ActionListener {
	/* Declaration */
	private Container contentPane;
	private JTextArea outputField;
	private JPanel boxPanel;
	private JScrollPane scroller;

	private JTextField welcomePhrase;
	private JTextField resultPhrase;
	private TextField inputTextField = new TextField(20);
	private JTextField translationSelectorInstruction;

	private JTextArea helpText;

	private JButton helpButton;
	private JButton fontButton;
	private JButton fontColorButton;
	private ArrayList<JComboBox<String>> wordBoxes;
	String[] types = { "English to Pig Latin", "Pig Latin to English", "English to Gibberish", "Gibberish to English" };
	public JComboBox<String> chooseTranslationDirection = new JComboBox<String>(types);

	translationDirection direction = translationDirection.ENG_TO_PIG;

	private ArrayList<Tuple> wordBoxSelections = new ArrayList<Tuple>();
	private boolean resettingBoxes = false;

	private JFrame helpFrame = new JFrame("Help/Instructions");
	private JFrame fontFrame = new JFrame("Change Font Style");
	private JFrame fontColorFrame = new JFrame("Change Font Color");

	/**
	 * windowSetUp creates the JPanels that we use for the GUI, which include
	 * JTextArea, JTextField, JButton, JComboBox
	 */

	public WindowSetUp() {
		/* Instantiation */
		int opacity = (int) (255 * .8);
		Color myBlue = new Color(18, 64, 171, opacity);
		Color myYellow = new Color(255, 211, 0, opacity);
		contentPane = getContentPane();
		contentPane.setBackground(myBlue);
		outputField = new JTextArea(30, 10);
		scroller = new JScrollPane(outputField);
		outputField.setLineWrap(true);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		helpButton = new JButton("   Help   "); // spaces to make buttons the
		// same size
		fontButton = new JButton("Font Style");
		fontColorButton = new JButton("Font Color");
		helpButton.setBackground(myYellow);
		fontButton.setBackground(myYellow);
		fontColorButton.setBackground(myYellow);

		welcomePhrase = new JTextField("Please enter a word or phrase of 8 words or less:", 30);
		welcomePhrase.setBackground(myYellow);
		resultPhrase = new JTextField("Result:", 30);
		resultPhrase.setBackground(myYellow);
		translationSelectorInstruction = new JTextField(
				"Select the correct English translation from each box when using Pig Latin To English;", 30);
		boxPanel = new JPanel();
		wordBoxes = new ArrayList<JComboBox<String>>();

		/* Location */
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		JPanel crossPane = new JPanel();

		crossPane.setLayout(new BoxLayout(crossPane, BoxLayout.X_AXIS));
		crossPane.add(helpButton);
		crossPane.add(fontButton);
		crossPane.add(fontColorButton);
		contentPane.add(crossPane);
		contentPane.add(welcomePhrase);
		welcomePhrase.setEditable(false);
		contentPane.add(inputTextField);
		contentPane.add(chooseTranslationDirection);
		chooseTranslationDirection.addActionListener(new ChooseListener());
		contentPane.add(resultPhrase);
		resultPhrase.setEditable(false);
		contentPane.add(scroller);
		contentPane.add(translationSelectorInstruction);
		translationSelectorInstruction.setEditable(false);
		contentPane.add(boxPanel);
		for (int i = 0; i < 8; i++) {
			wordBoxes.add(i, new JComboBox<String>());
			wordBoxes.get(i).setBackground(myYellow);
			boxPanel.add(wordBoxes.get(i));
			wordBoxes.get(i).addActionListener(new BoxListener());
		}

		/* Read PigLatin to English Selections from file */
		try {
			FileInputStream fis = new FileInputStream(
					new File("src/edu/ucsb/cs56/projects/misc/translate_to_secret_languages/PigLatinSelections.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] tupleArgs = line.split(" ");
				wordBoxSelections.add(new Tuple(tupleArgs[0], Integer.parseInt(tupleArgs[1])));
			}
			br.close();
		} catch (Exception ex) {
			System.err.println(
					"Error reading from file. Ignore this warning if you haven't yet used PigLatin to English, because the file doesn't not yet exist.");
		}

		/* Configuration */
		helpButton.addActionListener(new HelpListener());
		fontButton.addActionListener(new FontButtonListener());
		fontColorButton.addActionListener(new FontColorListener());
		inputTextField.addActionListener(this); // WHAT???? what does this do?
		Font DefFont = new Font("Times New Roman", Font.PLAIN, 15);
		inputTextField.setFont(DefFont);
		outputField.setFont(DefFont);
		outputField.setEditable(false);

		/* instantiate color window */
		fontColorFrame.setSize(200, 200);
		Container fontColorPanel = fontColorFrame.getContentPane();
		fontColorPanel.setLayout(new BoxLayout(fontColorPanel, BoxLayout.Y_AXIS));

		// JPanel fontColorPanel = new JPanel(new GridLayout(4,1));
		JButton Red = new JButton("Red");
		JButton Green = new JButton("Green");
		JButton Blue = new JButton("Blue");
		JButton Black = new JButton("Black");
		// Red.setSize(new Dimension(100, 40));
		fontColorPanel.add(Red, BorderLayout.NORTH);
		fontColorPanel.add(Green);
		fontColorPanel.add(Blue);
		fontColorPanel.add(Black);
		Red.addActionListener(new ColorListener(Color.RED));
		Green.addActionListener(new ColorListener(Color.GREEN));
		Blue.addActionListener(new ColorListener(Color.BLUE));
		Black.addActionListener(new ColorListener(Color.BLACK));

		/* instantiate font window */
		fontFrame.setSize(200, 200);
		Container fontSelectPanel = fontFrame.getContentPane();
		fontSelectPanel.setLayout(new BoxLayout(fontSelectPanel, BoxLayout.Y_AXIS));

		JButton Default = new JButton("    Default    ");
		JButton Bold = new JButton("      Bold     ");
		JButton Italics = new JButton("    Italics    ");
		JButton Courier = new JButton("    Courier    ");
		JButton Serif = new JButton("     Serif     ");
		JButton Times = new JButton("Times New Roman");
		JButton Close = new JButton("     Apply     ");
		fontSelectPanel.add(Default);
		fontSelectPanel.add(Bold);
		fontSelectPanel.add(Italics);
		fontSelectPanel.add(Courier);
		fontSelectPanel.add(Serif);
		fontSelectPanel.add(Times);
		fontSelectPanel.add(Close); // TODO: move to a different panel than the others
		Bold.addActionListener(new FontStyleListener(true));
		Italics.addActionListener(new FontStyleListener(false));
		Default.addActionListener(new FontListener("Default"));
		Courier.addActionListener(new FontListener("Courier"));
		Serif.addActionListener(new FontListener("Serif"));
		Times.addActionListener(new FontListener("Times New Roman"));
		Close.addActionListener(new CloseListener());
	}

	public void actionPerformed(ActionEvent e) {
		if (direction == translationDirection.ENG_TO_PIG)
			translateEngToPig();
		if (direction == translationDirection.PIG_TO_ENG)
			translatePigToEng();
		if (direction == translationDirection.ENG_TO_GIB)
			translateEngToGib();
		if (direction == translationDirection.GIB_TO_ENG)
			translateGibToEng();
		inputTextField.selectAll();
	}

	/** inner class for when chooseTranslationDirection is selected */

	public class ChooseListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String type = (String) chooseTranslationDirection.getSelectedItem();
			if (type.equals("English to Pig Latin"))
				direction = translationDirection.ENG_TO_PIG;
			if (type.equals("Pig Latin to English"))
				direction = translationDirection.PIG_TO_ENG;
			if (type.equals("English to Gibberish"))
				direction = translationDirection.ENG_TO_GIB;
			if (type.equals("Gibberish to English"))
				direction = translationDirection.GIB_TO_ENG;
		}
	}

	/**
	 * inner class for when Help button is selected
	 */

	public class HelpListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			helpFrame.setSize(600, 400);
			Container helpContentPane = helpFrame.getContentPane();
			helpContentPane.setLayout(new BoxLayout(helpContentPane, BoxLayout.Y_AXIS));
			helpText = new JTextArea(20, 20);
			helpText.setLineWrap(true);
			helpText.setText(
					"The usual rules for changing standard English into Pig Latin are as follows: " +
							"\nFor words that begin with consonant sounds, the initial consonant or consonant cluster is" +
							"\nmoved to the end of the word, and 'ay' is added " +
							"\n    For example: 'glove' → 'oveglay' 'happy'→'appyhay'  " +
							"\nFor words that begin with vowel sounds or silent letter, 'way' is added at the end of the word." +
							"\n    For example: 'egg' → 'eggway' 'inbox' → 'inboxway' " +
							"\nIn some variants, though, just add an 'ay' at the end. 'egg' → 'eggay'" +
							"\nAnother variant is to add the ending 'yay'. 'egg' → 'eggyay' " +
							"\n\nThe rules used for changing English into Gibberish in this program:" +
							"\nThe string 'uvug' is randomly placed into the word to be translated, possibly many times." +
							"\n    For example: 'hi i am prof conrad' -> 'huvugi uvugi uvugam pruvugof cuvugonruvugad'" +
							"\n\nType in the words you wish to translate, then click on the correct option" +
							"\nPlease only enter words or phrases of less than 8 words ");
			helpContentPane.add(helpText);
			helpText.setEditable(false);

			JButton closeHelp = new JButton("Close");
			helpContentPane.add(closeHelp);
			closeHelp.addActionListener(new CloseHelpListener());

			helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			helpFrame.setVisible(true);
		}
	}

	/**
	 * inner class for when Font button is selected
	 */

	public class FontButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			fontFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			fontFrame.setVisible(true);
		}
	}

	/**
	 * inner class for when fColor button is selected
	 */

	public class FontColorListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			fontColorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			fontColorFrame.setVisible(true);
		}
	}

	/**
	 * inner class for when Pig Latin to English button is selected
	 */

	// TODO: Consolidate logic to EnglishToPigLatin class
	public void translatePigToEng() {
		resettingBoxes = true;
		// split words inputted by user into array of strings so each word can
		// be analyzed / translated
		String[] words = inputTextField.getText().split(" ");
		// check to see if phrase length is less than or equal to number of
		// boxes to fill with word options
		if (words.length <= 8) {
			resultPhrase.setText("Result In English:");
			// iterate through each JComboBox
			for (int boxNum = 0; boxNum < 8; boxNum++) {
				JComboBox<String> currentBox = wordBoxes.get(boxNum);
				// clear each JComboBox
				currentBox.removeAllItems();

				if (boxNum < words.length) {
					String currentWord = words[boxNum];
					/*
					 * convert each word to English and give options in a String
					 * array. done so since impossible to tell when English word
					 * starts and ends after translated into Pig Latin
					 */
					String[] pigLatinTrans = EnglishToPigLatin.toEnglish(currentWord);
					/*
					 * refresh each JComboBox with 5 options / selectable words
					 * for word in English
					 */
					currentBox.removeAllItems();
					currentBox.addItem("");
					for (int optionNum = 0; optionNum < pigLatinTrans.length && optionNum < 5; optionNum++) {
						currentBox.addItem(pigLatinTrans[optionNum]);
					}
					if (currentBox.getItemCount() == 2)
						currentBox.setSelectedIndex(1);
					else
						currentBox.setSelectedIndex(0);
				}
			}
			resettingBoxes = false;
			// updates each JComboBox
			updateOutput();
			inputTextField.selectAll();
		}
		// if number of words is greater than 8
		else {
			JOptionPane.showMessageDialog(null, "Amount of words greater than 8. Please try again.", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// }

	/**
	 * inner class for when English to Pig Latin is selected
	 */
	// public class EngToPigListener implements ActionListener
	// {
	public void translateEngToPig() {
		String phrase;
		phrase = inputTextField.getText();
		if (phrase.split(" ").length <= 8) {
			resultPhrase.setText("Result In Pig Latin:");
			// converts to Pig latin
			outputField.setText(EnglishToPigLatin.toPigLatin(phrase));
			inputTextField.selectAll();
		}
		// output error if more than 8 words inputted
		else {
			JOptionPane.showMessageDialog(null, "Amount of words greater than 8. Please try again.", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// }

	/**
	 * inner class for when Gibberish to English is selected
	 */


	public void translateGibToEng() {
		String phrase;
		phrase = inputTextField.getText();
		if (phrase.split(" ").length <= 8) {
			resultPhrase.setText("Result in English");
			// converts to English
			outputField.setText(EnglishToGibberish.fromGibberish(phrase));
			inputTextField.selectAll();
		}
	}


	/**
	 * inner class for when English to Gibberish is selected
	 */


	public void translateEngToGib() {
		String phrase;
		phrase = inputTextField.getText();
		if (phrase.split(" ").length <= 8) {
			resultPhrase.setText("Result in Gibberish");
			// converts to Gibberish
			outputField.setText(EnglishToGibberish.toGibberish(phrase));
			inputTextField.selectAll();
		}
	}


	/**
	 * inner class for when JComboBox is updated
	 */

	public class BoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			updateOutput();
		}
	}

	/**
	 * Updates the output box with phrase in each text box
	 */
	private void updateOutput() {
		if (resettingBoxes)
			return;
		String pigLatinOutput = "";
		boolean wordFound = false;
		boolean listChanged = false;
		String[] words = inputTextField.getText().split(" ");
		for (int boxNum = 0; boxNum < 8 && boxNum < words.length; boxNum++) {
			wordFound = false;
			JComboBox<String> currentBox = wordBoxes.get(boxNum);
			int selectedIndex = currentBox.getSelectedIndex();
			for (Tuple tuple : wordBoxSelections) {
				if (tuple.input.equals(words[boxNum])) {
					wordFound = true;
					if (selectedIndex <= 0 && currentBox.getItemCount() > 0) {
						currentBox.setSelectedIndex(tuple.translation);
					} else if (selectedIndex > 0 && tuple.translation != selectedIndex) {
						tuple.translation = selectedIndex;
						listChanged = true;
					}
				}
			}
			if (!wordFound && selectedIndex > 0) {
				Tuple newEntry = new Tuple(words[boxNum], selectedIndex);
				wordBoxSelections.add(newEntry);
				listChanged = true;
			}
			String translation = (String) wordBoxes.get(boxNum).getSelectedItem();
			if (translation != null)
				pigLatinOutput += translation + " ";
		}
		outputField.setText(pigLatinOutput);
		if (listChanged) {
			try {
				PrintStream writer = new PrintStream(new File(
						"src/edu/ucsb/cs56/projects/misc/translate_to_secret_languages/PigLatinSelections.txt"));
				for (Tuple tuple : wordBoxSelections) {
					writer.println(tuple.input + " " + tuple.translation);
				}
				writer.close();
				System.err.println("Wrote to file");
			} catch (Exception ex) {
				System.err.println("Error in writing to file");
				ex.printStackTrace();
			}
		}
	}

	public class DefListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Font DefFont = new Font("Times New Roman", Font.PLAIN, 15);
			inputTextField.setFont(DefFont);
			outputField.setFont(DefFont);
		}
	}
	// Either used for toggling bold, or toggling italics
	// Boolean passed in decides which it is, to reduce code duplication
	public class FontStyleListener implements ActionListener {
		boolean intendedForBold;
		public FontStyleListener(boolean intendedForBold) {
			this.intendedForBold = intendedForBold;
		}
		public void actionPerformed(ActionEvent e) {
			Font oldFont = inputTextField.getFont();
			if (intendedForBold) {
				// keep italic the same
				int italic = oldFont.isItalic() ? Font.ITALIC : Font.PLAIN;
				// flip bold from old font
				int bold = oldFont.isBold() ? Font.PLAIN : Font.BOLD;
				Font newFont = oldFont.deriveFont(italic + bold);
				inputTextField.setFont(newFont);
				outputField.setFont(newFont);
			}
			else {
				// flip italic from old font
				int italic = oldFont.isItalic() ?  Font.PLAIN : Font.ITALIC;
				// keep bold the same
				int bold = oldFont.isBold() ? Font.BOLD : Font.PLAIN;
				Font newFont = oldFont.deriveFont(italic + bold);
				inputTextField.setFont(newFont);
				outputField.setFont(newFont);
			}
		}
	}


	public class FontListener implements ActionListener {
		String fontName;

		public FontListener(String fontName) {
			this.fontName = fontName;
		}
		public void actionPerformed(ActionEvent e) {
			if (fontName.equals("Default")) {
				Font DefFont = new Font("Times New Roman", Font.PLAIN, 15);
				inputTextField.setFont(DefFont);
				outputField.setFont(DefFont);
				return;
			}
			int style = inputTextField.getFont().isItalic() ? Font.ITALIC : Font.PLAIN;
			style += inputTextField.getFont().isBold() ? Font.BOLD : Font.PLAIN;
			Font newFont = new Font(fontName, style, 15);
			inputTextField.setFont(newFont);
			outputField.setFont(newFont);
		}
	}

	public class CloseListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			fontFrame.dispose();
		}
	}

	public class CloseHelpListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			helpFrame.dispose();
		}
	}
	public class ColorListener implements ActionListener {
		Color color;
		public ColorListener(Color color) {
			this.color = color;
		}
		public void actionPerformed(ActionEvent e) {
			inputTextField.setForeground(color);
			outputField.setForeground(color);
		}
	}

	public class Tuple {
		public final String input;
		public int translation;

		public Tuple(String input, int translation) {
			this.input = input;
			this.translation = translation;
		}
	}
	public enum translationDirection {
		ENG_TO_PIG, PIG_TO_ENG, ENG_TO_GIB, GIB_TO_ENG
	}
}
