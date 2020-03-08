package app;

import java.awt.Choice;
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

public class App {

	private JFrame frame;
	private JTextField search;

	private JPanel main;
	private JPanel overlay;
	private JPanel sideBar;
	private JList<String> list;
	private JScrollPane sideBarScroll;

	private JPanel wordPanel;
	private JPanel addPanel;
	private JPanel removePanel;
	
	public enum Status { // public in case i go to other files?
		WORD, ADD, REMOVE
	}
	public Status status = Status.WORD;

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

		sideBar = new JPanel();
		sideBar.setBounds(10, 11, 250, 444);
		frame.getContentPane().add(sideBar);
		sideBar.setLayout(null);

		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add a word!");
				// TODO add button action here
				if (status == Status.ADD) setMain(Status.WORD);
				else setMain(Status.ADD);
			}
		});
		add.setBounds(10, 11, 110, 45);
		sideBar.add(add);

		JButton remove = new JButton("Remove");
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Remove a word!!");
				// TODO remove button action here
				setMain(Status.REMOVE);
			}
		});
		remove.setBounds(130, 11, 110, 45);
		sideBar.add(remove);

		search = new JTextField();
		// PromptSupport.setPrompt("Search", txtSearch);
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Doing stuff here...");
				// TODO search bar action here
			}
		});
		search.setBounds(10, 67, 230, 31);
		sideBar.add(search);
		search.setColumns(10);

		JCheckBox asc = new JCheckBox("Ascending");
		asc.setBounds(10, 105, 110, 39);
		sideBar.add(asc);

		JCheckBox dec = new JCheckBox("Decending");
		dec.setBounds(130, 105, 110, 39);
		sideBar.add(dec);

		list = new JList<>(Word.getWordMenu());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sideBarScroll = new JScrollPane(list);
		sideBarScroll.setBounds(10, 143, 230, 301);
		sideBar.add(sideBarScroll);

		main = new JPanel();
		main.setBounds(270, 11, 708, 444);
		frame.getContentPane().add(main);
		main.setLayout(null);

		// overlay = new JPanel();
		// overlay.setBounds(270, 11, 708, 444);
		// frame.getContentPane().add(overlay);
		// overlay.setLayout(null);

		setWordPanel();
		setAddPanel();
		setRemovePanel();

		setMain(Status.WORD);
	}
	
	public void setMain(Status what) {
		main.removeAll();
		main.updateUI();
		frame.remove(main);
		if (status == Status.WORD) {
			main.remove(wordPanel);
		} else if (status == Status.ADD) {
			main.remove(addPanel);
		} else if (status == Status.REMOVE) {
			main.remove(removePanel);
		}
		if (what == Status.WORD) {
			status = Status.WORD;
			main.add(wordPanel);
			wordPanel.updateUI();
		} else if (what == Status.ADD) {
			status = Status.ADD;
			main.add(addPanel);
			addPanel.updateUI();
		} else if (what == Status.REMOVE) {
			status = Status.REMOVE;
			main.add(removePanel);
			removePanel.updateUI();
		}
		frame.add(main);
		frame.revalidate();
	}

	public void setWordPanel() {
		wordPanel = new JPanel();

		// JScrollPane wordScroll = new JScrollPane(wordPanel);
		// wordScroll.setEnabled(false);
		// wordScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		// wordScroll.setBounds(0, 0, 708, 444);

		wordPanel.setBounds(0, 0, 708, 444);

		// main.add(wordScroll);

		wordPanel.setLayout(null);

		JLabel wordL = new JLabel("Welcome to the Desktop Dictionary");
		wordL.setFont(new Font("Tahoma", Font.PLAIN, 30));
		wordL.setBounds(10, 11, 686, 42);
		wordPanel.add(wordL);

		JLabel defHeader = new JLabel("Definitions");
		defHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
		defHeader.setBounds(10, 59, 100, 21);
		wordPanel.add(defHeader);

		JLabel defText = new JLabel();
		defText.setVerticalAlignment(SwingConstants.TOP);
		defText.setHorizontalAlignment(SwingConstants.LEFT);
		defText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		defText.setBackground(UIManager.getColor("Panel.background"));
		// defText.setEditable(false);
		defText.setText("No definitions");
		// defText.setBounds(10, 91, 686, 122);
		// wordPanel.add(defText);

		JScrollPane defScroll = new JScrollPane(defText);
		defScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		defScroll.setBounds(10, 91, 686, 75);
		wordPanel.add(defScroll);

		JLabel synHeader = new JLabel("Synonyms");
		synHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
		synHeader.setBounds(10, 177, 100, 21);
		wordPanel.add(synHeader);

		JLabel synText = new JLabel();
		synText.setVerticalAlignment(SwingConstants.TOP);
		synText.setHorizontalAlignment(SwingConstants.LEFT);
		synText.setBackground(UIManager.getColor("Panel.background"));
		synText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		synText.setBackground(UIManager.getColor("Panel.background"));
		// synText.setEditable(false);
		synText.setText("No synonyms");

		JScrollPane synScroll = new JScrollPane(synText);
		synScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		synScroll.setBounds(10, 209, 686, 75);
		wordPanel.add(synScroll);

		JLabel antHeader = new JLabel("Antonyms");
		antHeader.setBounds(10, 295, 100, 21);
		wordPanel.add(antHeader);
		antHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel antText = new JLabel();
		antText.setVerticalAlignment(SwingConstants.TOP);
		antText.setText("No antonyms");
		antText.setHorizontalAlignment(SwingConstants.LEFT);
		antText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		antText.setBackground(SystemColor.menu);

		JScrollPane antScroll = new JScrollPane(antText);
		antScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		antScroll.setBounds(10, 327, 686, 75);
		wordPanel.add(antScroll);


		list.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
				System.out.println("Oooooo, selectionss..");
				wordL.setText(list.getSelectedValue());
				defText.setText(Word.outputDefinitions(list.getSelectedValue()));
				synText.setText(Word.outputSynonyms(list.getSelectedValue()));
				antText.setText(Word.outputAntonyms(list.getSelectedValue()));
			}
		});
	}

	public void setAddPanel() {
		addPanel = new JPanel();
		addPanel.setBounds(0, 0, 708, 444);
		addPanel.setLayout(null);

		JLabel addL = new JLabel("Add Word");
		addL.setFont(new Font("Tahoma", Font.PLAIN, 30));
		addL.setBounds(10, 11, 686, 42);
		addPanel.add(addL);

		JLabel newWordHeader = new JLabel("New Word:");
		newWordHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newWordHeader.setBounds(10, 59, 100, 21);
		addPanel.add(newWordHeader);

		JLabel defHeader = new JLabel("Definitions");
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

		definition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				definitions.add(new Definition(definition.getText(), pos.getSelectedItem()));
				update();
				definition.setText("");
				System.out.println("new definition!");
			}
			private void update() {
				defNum++;
				defDisplay += Integer.toString(defNum) + ". (" + (pos.getSelectedItem().equals("adjective") ? "adj." : pos.getSelectedItem()) + ") " + definition.getText() + "<br/>";
				defList.setText(defDisplay.substring(0, defDisplay.length() - 5) + "</html>");
			}
		});

		synonym.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synonyms.add(synonym.getText());
				update();
				System.out.println("new synonym");
			}
			private void update() {
				synNum++;
				synDisplay += Integer.toString(synNum) + ". " + synonym.getText() + "<br/>";
				synList.setText(synDisplay.substring(0, synDisplay.length() - 5) + "</html>");
			}
		});

		antonym.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				antonyms.add(antonym.getText());
				update();
				System.out.println("new antonym");
			}
			private void update() {
				antNum++;
				antDisplay += Integer.toString(antNum) + ". " + antonym.getText() + "<br/>";
				antList.setText(antDisplay.substring(0, antDisplay.length() - 5) + "</html>");
			}
		});

		addWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (newWord.getText().isEmpty() || definitions.isEmpty()) return;
				Word word = new Word(newWord.getText(), definitions, synonyms, antonyms);
				defDisplay = "<html>"; defNum = 0;
				synDisplay = "<html>"; synNum = 0;
				antDisplay = "<html>"; antNum = 0;
				Word.addWord(word);
				newWord.setText("");
				defList.setText("");
				synList.setText("");
				antList.setText("");
				// change add view to word view
				setMain(Status.WORD);
				System.out.println("Added a new word!");
				// TODO UPDATE THE FREAKING SIDEBAR, GODDAMNIT
				list = new JList<>(Word.getWordMenu());
				list.updateUI();
				sideBarScroll = new JScrollPane(list);
				sideBarScroll.updateUI();
				sideBar.remove(sideBarScroll);
				sideBar.add(sideBarScroll);
				sideBar.updateUI();
			}
		});
	}

	public void setRemovePanel() {
		removePanel = new JPanel();
	}
}