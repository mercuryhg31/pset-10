package app;

import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class App {

    public App() {
        JFrame frame = new JFrame("Desktop Dictionary");
        
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 0));
        panel.setLayout(new GridLayout());
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new App();
    }

    // private static void createAndShowGUI() {
    //     //Create and set up the window.
    //     JFrame frame = new JFrame("HelloWorldSwing");
    //     // frame.setSize(500, 500); // TODO why doesn't this work??
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //     //Add the ubiquitous "Hello World" label.
    //     JLabel label = new JLabel("Hello World");
    //     frame.getContentPane().add(label);

    //     //Display the window.
    //     frame.pack();
    //     frame.setVisible(true);
    // }

    // public static void main(String[] args) {
    //     //Schedule a job for the event-dispatching thread:
    //     //creating and showing this application's GUI.
    //     SwingUtilities.invokeLater(new Runnable() {
    //         public void run() {
    //             createAndShowGUI();
    //         }
    //     });
    // }
}