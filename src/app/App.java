package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dict.*;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import java.awt.Choice;
import java.awt.Component;

public class App {

	private JFrame frame;
	private JTextField search;

	private JPanel main;
	private JList<String> list;

	private JPanel addPanel;

	public enum Status { // public in case i go to other files?
		WORD, ADD, REMOVE
	}
	public Status status;

	String defDisplay = "<html>"; int defNum = 0;
	String synDisplay = "<html>"; int synNum = 0;
	String antDisplay = "<html>"; int antNum = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Desktop Dictionary");
		frame.setBounds(100, 100, 1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel sideBar = new JPanel();
		sideBar.setBounds(10, 11, 250, 444);
		frame.getContentPane().add(sideBar);
		sideBar.setLayout(null);

		JButton add = new JButton("Add");
		add.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add a word!");
				// TODO add button action here
			}
		});
		add.setBounds(10, 11, 110, 45);
		sideBar.add(add);

		JButton remove = new JButton("Remove");
		remove.setFont(new Font("Tahoma", Font.PLAIN, 15));
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Remove a word!!");
				// TODO remove button action here
			}
		});
		remove.setBounds(130, 11, 110, 45);
		sideBar.add(remove);

		search = new JTextField();
		// PromptSupport.setPrompt("Search", txtSearch);
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Doing stuff here...");
				// TODO remove button action here
			}
		});
		search.setBounds(10, 67, 230, 31);
		sideBar.add(search);
		search.setColumns(10);

		JCheckBox asc = new JCheckBox("Ascending");
		asc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		asc.setBounds(10, 105, 110, 39);
		sideBar.add(asc);

		JCheckBox dec = new JCheckBox("Decending");
		dec.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dec.setBounds(130, 105, 110, 39);
		sideBar.add(dec);

		list = new JList<>(Word.getWordMenu());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane sideBarScroll = new JScrollPane(list);
		sideBarScroll.setBounds(10, 143, 230, 301);
		sideBar.add(sideBarScroll);

		main = new JPanel();
		main.setBounds(270, 11, 708, 444);
		frame.getContentPane().add(main);
		main.setLayout(null);

		addPanel = new JPanel();

		// JScrollPane wordScroll = new JScrollPane(wordPanel);
		// wordScroll.setEnabled(false);
		// wordScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		// wordScroll.setBounds(0, 0, 708, 444);

		addPanel.setBounds(0, 0, 708, 444);
		main.add(addPanel); // TODO take this out in function

		// main.add(wordScroll);

		addPanel.setLayout(null);

		JLabel addL = new JLabel("Add Word");
		addL.setFont(new Font("Tahoma", Font.PLAIN, 30));
		addL.setBounds(10, 11, 686, 42);
		addPanel.add(addL);

		JLabel newWordHeader = new JLabel("New Word:");
		newWordHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newWordHeader.setBounds(10, 59, 100, 21);
		addPanel.add(newWordHeader);

		JLabel defHeader = new JLabel("Definitions (0)");
		defHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
		defHeader.setBounds(10, 91, 131, 21);
		addPanel.add(defHeader);

		JLabel defList = new JLabel();
		defList.setVerticalAlignment(SwingConstants.TOP);
		defList.setText("No definitions");
		defList.setHorizontalAlignment(SwingConstants.LEFT);
		defList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		defList.setBackground(SystemColor.menu);

		JScrollPane defLScroll = new JScrollPane(defList);
		defLScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		defLScroll.setBounds(10, 173, 686, 75);
		addPanel.add(defLScroll);

		JTextField newWord = new JTextField();
		newWord.setFont(new Font("Tahoma", Font.PLAIN, 15));
		newWord.setBounds(112, 60, 584, 21);
		addPanel.add(newWord);
		newWord.setColumns(10);

		JLabel posTxt = new JLabel();
		posTxt.setVerticalAlignment(SwingConstants.TOP);
		posTxt.setText("Part of speech:");
		posTxt.setHorizontalAlignment(SwingConstants.LEFT);
		posTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		posTxt.setBackground(SystemColor.menu);
		posTxt.setBounds(10, 121, 100, 21);
		addPanel.add(posTxt);

		Choice pos = new Choice();
		pos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pos.add("noun");
		pos.add("verb");
		pos.add("adjective");
		pos.setBounds(113, 123, 583, 16);
		addPanel.add(pos);

		JLabel defL = new JLabel();
		defL.setVerticalAlignment(SwingConstants.TOP);
		defL.setText("Definition:");
		defL.setHorizontalAlignment(SwingConstants.LEFT);
		defL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		defL.setBackground(SystemColor.menu);
		defL.setBounds(10, 146, 68, 21);
		addPanel.add(defL);

		JTextField definition = new JTextField();
		definition.setColumns(10);
		definition.setBounds(79, 149, 617, 16);
		addPanel.add(definition);

		JLabel synHeader = new JLabel("Synonyms:");
		synHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
		synHeader.setBounds(10, 259, 100, 21);
		addPanel.add(synHeader);

		JTextField synonym = new JTextField();
		synonym.setFont(new Font("Tahoma", Font.PLAIN, 15));
		synonym.setColumns(10);
		synonym.setBounds(112, 260, 230, 21);
		addPanel.add(synonym);

		JLabel synList = new JLabel();
		synList.setVerticalAlignment(SwingConstants.TOP);
		synList.setText("No synonyms");
		synList.setHorizontalAlignment(SwingConstants.LEFT);
		synList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		synList.setBackground(SystemColor.menu);

		JScrollPane synScroll = new JScrollPane(synList);
		synScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		synScroll.setBounds(10, 291, 332, 75);
		addPanel.add(synScroll);

		JTextField antonym = new JTextField();
		antonym.setFont(new Font("Tahoma", Font.PLAIN, 15));
		antonym.setColumns(10);
		antonym.setBounds(466, 260, 230, 21);
		addPanel.add(antonym);

		JLabel antHeader = new JLabel("Antonyms:");
		antHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
		antHeader.setBounds(364, 259, 100, 21);
		addPanel.add(antHeader);

		JLabel antList = new JLabel();
		antList.setVerticalAlignment(SwingConstants.TOP);
		antList.setText("No antonyms");
		antList.setHorizontalAlignment(SwingConstants.LEFT);
		antList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		antList.setBackground(SystemColor.menu);

		JScrollPane antScroll = new JScrollPane(antList);
		antScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		antScroll.setBounds(364, 291, 332, 75);
		addPanel.add(antScroll);

		JButton addWord = new JButton("Add New Word");
		addWord.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addWord.setBounds(10, 376, 686, 45);
		addPanel.add(addWord);

		// ACTIONS!

		ArrayList<Definition> definitions = new ArrayList<Definition>();
		ArrayList<String> synonyms = new ArrayList<String>();
		ArrayList<String> antonyms = new ArrayList<String>();

		// TODO display actions
		definition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO definition display
				definitions.add(new Definition(definition.getText(), pos.getSelectedItem()));
				update();
				definition.setText("");
				System.out.println("new definition!");
			}
			private void update() {
				defNum++;
				defDisplay += Integer.toString(defNum) + ". " + definition.getText() + "</br>";
				defList.setText(defDisplay.substring(0, defDisplay.length() - 5) + "</html>");
			}
		});

		synonym.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO synonym display
				synonyms.add(synonym.getText());
				System.out.println("new synonym");
			}
		});

		antonym.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO antonym display
				antonyms.add(antonym.getText());
				System.out.println("new antonym");
			}
		});

		addWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO add new word
				Word word = new Word(newWord.getText(), definitions, synonyms, antonyms);
				defDisplay = "<html>"; defNum = 0;
				synDisplay = "<html>"; synNum = 0;
				antDisplay = "<html>"; antNum = 0;
				Word.addWord(word);
				System.out.println("Added a new word!");
			}
		});
	}

	private void updateDisplay() {

	}
}