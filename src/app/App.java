package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dict.Word;

import javax.swing.JCheckBox;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTree;
import javax.swing.JTextArea;

public class App {

	private JFrame frame;
	private JTextField search;

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

		JList<String> list = new JList<>(Word.getAllWords());
		JScrollPane sideBarScroll = new JScrollPane(list);
		sideBarScroll.setBounds(10, 143, 230, 301);
		list.setSelectedIndex(0);
		sideBar.add(sideBarScroll);

		JPanel main = new JPanel();
		main.setBounds(270, 11, 708, 444);
		frame.getContentPane().add(main);
		main.setLayout(null);

		JPanel wordPanel = new JPanel();

		JScrollPane wordScroll = new JScrollPane(wordPanel);
		wordScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		wordScroll.setBounds(0, 0, 708, 444);

		// wordPanel.setBounds(0, 0, 708, 444);
		// main.add(wordPanel);

		main.add(wordScroll);

		wordPanel.setLayout(null);

		JLabel wordL = new JLabel("Word");
		wordL.setFont(new Font("Tahoma", Font.PLAIN, 30));
		// wordL.setText(list.getSelectedValue()); // TODO uncomment for actual apps
		list.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
				System.out.println("Oooooo, selectionss..");
				wordL.setText(list.getSelectedValue());
			}
		});
		wordL.setBounds(10, 11, 500, 42);
		wordPanel.add(wordL);

		JLabel defHeader = new JLabel("Definitions");
		defHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
		defHeader.setBounds(10, 59, 100, 21);
		wordPanel.add(defHeader);

		JTextArea txtrHi = new JTextArea();
		txtrHi.setText("hi");
		txtrHi.setBounds(10, 91, 686, 101);
		wordPanel.add(txtrHi);
	}
}
