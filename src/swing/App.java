package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import dict.Word;

import javax.swing.JCheckBox;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App {

	private JFrame frmDesktopDictionary;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmDesktopDictionary.setVisible(true);
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
		frmDesktopDictionary = new JFrame();
		frmDesktopDictionary.setTitle("Desktop Dictionary");
		frmDesktopDictionary.setBounds(100, 100, 1000, 500);
		frmDesktopDictionary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDesktopDictionary.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 250, 444);
		frmDesktopDictionary.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add a word!");
				// TODO add button action here
			}
		});
		btnAdd.setBounds(10, 11, 110, 45);
		panel.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Remove a word!!");
				// TODO remove button action here
			}
		});
		btnRemove.setBounds(130, 11, 110, 45);
		panel.add(btnRemove);
		
		txtSearch = new JTextField();
		// PromptSupport.setPrompt("Search", txtSearch);
		txtSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Doing stuff here...");
				// TODO remove button action here
			}
		});
		txtSearch.setBounds(10, 67, 230, 31);
		panel.add(txtSearch);
		txtSearch.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Ascending");
		chckbxNewCheckBox.setBounds(10, 105, 110, 39);
		panel.add(chckbxNewCheckBox);
		
		JCheckBox chckbxDec = new JCheckBox("Decending");
		chckbxDec.setBounds(130, 105, 110, 39);
		panel.add(chckbxDec);
		
		JList<String> list = new JList(Word.getAllWords());
		list.setBounds(10, 143, 230, 301);
		panel.add(list);
	}
}
