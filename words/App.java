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
	private JList<String> list;

	private JPanel wordPanel;
	private JPanel addPanel;
	private JPanel removePanel;
	
	public enum Status { // public in case i go to other files?
		WORD, ADD, REMOVE
	}
	public Status status;

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
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add a word!");
				// TODO add button action here
			}
		});
		add.setBounds(10, 11, 110, 45);
		sideBar.add(add);

		JButton remove = new JButton("Remove");
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
		asc.setBounds(10, 105, 110, 39);
		sideBar.add(asc);

		JCheckBox dec = new JCheckBox("Decending");
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

		setWordPanel();
		setAddPanel();

		setMain(Status.ADD);
	}
	
	public void setMain(Status what) {
		if (status == Status.WORD) {
			main.remove(wordPanel);
		} else if (status == Status.ADD) {
			main.remove(addPanel);
		} else if (status == Status.REMOVE) {
			main.remove(removePanel);
		}
		if (what == Status.WORD) {
			main.add(wordPanel);
		} else if (what == Status.ADD) {
			main.add(addPanel);
		} else if (what == Status.REMOVE) {
			main.add(removePanel);
		}
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
		// wordL.setText(list.getSelectedValue()); // TODO uncomment for actual apps
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
	}

	public void setRemovePanel() {
		removePanel = new JPanel();
	}
}