package advandb;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Layout extends JFrame{
	
	 public static void main(String[] args) {
		Layout frame = new Layout();
	    frame.setSize(400,600);
	    frame.setResizable(false);
	    frame.GUI();
	    } 
	 
	 void GUI() {
		 Container c = getContentPane();
		 
		 JPanel leftPanel = new JPanel();
		 JPanel rightPanel = new JPanel();
		 JPanel txtFieldPanel = new JPanel();
		 
		 JSplitPane pane = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT, 
                 leftPanel, rightPanel );
		 
		 JButton btn_exec = new JButton("EXECUTE");
	     
		 JLabel br = new JLabel(" ");
	     JLabel lbl_1 = new JLabel("Local 1 / Global");
	     JLabel lbl_2 = new JLabel("ID: ");
	     JLabel lbl_3 = new JLabel("Province: ");
	     JLabel lbl_4 = new JLabel("Age: ");
	     JLabel lbl_5 = new JLabel("Local 2");
	     JLabel lbl_6 = new JLabel("Local 3");
	     JLabel lbl_7 = new JLabel("Concurrency");
	     JLabel lbl_8 = new JLabel("Isolation Level");
	     JLabel lbl_9 = new JLabel("Case");
	     
	     JTextField txt_id = new JTextField(5);
	     JTextField txt_province = new JTextField(10);
	     JTextField txt_age = new JTextField(3);
	     
	     JTextArea resultsArea1 = new JTextArea("Local / Global", 10, 10);
	     JTextArea resultsArea2 = new JTextArea("Local 2", 10, 10);
	     JTextArea resultsArea3 = new JTextArea("Local 3", 10, 10);
	     
	     JRadioButton radioLocal = new JRadioButton("Local");
	     JRadioButton radioGlobal = new JRadioButton("Global");
	     JRadioButton radioReadUC = new JRadioButton("Read Uncommitted");
	     JRadioButton radioReadC = new JRadioButton("Read Committed");
	     JRadioButton radioRepeatRead = new JRadioButton("Repeatable Read");
	     JRadioButton radioSerial = new JRadioButton("Serializable");
	     JRadioButton radioCase1 = new JRadioButton("Read - Read");
	     JRadioButton radioCase2 = new JRadioButton("Write - Read");
	     JRadioButton radioCase3 = new JRadioButton("Write - Write");
	     
	     ButtonGroup concurrencyGroup = new ButtonGroup();
	     ButtonGroup isolationGroup = new ButtonGroup();
	     ButtonGroup caseGroup = new ButtonGroup();
	     
	     concurrencyGroup.add(radioLocal);
	     concurrencyGroup.add(radioGlobal);
	     isolationGroup.add(radioReadUC);
	     isolationGroup.add(radioReadC);
	     isolationGroup.add(radioRepeatRead);
	     isolationGroup.add(radioSerial);
	     caseGroup.add(radioCase1);
	     caseGroup.add(radioCase2);
	     caseGroup.add(radioCase3);
	   
	     leftPanel.add(br);
	     leftPanel.add(lbl_7);
	     leftPanel.add(radioLocal);
	     leftPanel.add(radioGlobal);
	     leftPanel.add(br);
	     leftPanel.add(lbl_8);
	     leftPanel.add(radioReadUC);
	     leftPanel.add(radioReadC);
	     leftPanel.add(radioRepeatRead);
	     leftPanel.add(radioSerial);
	     leftPanel.add(br);
	     leftPanel.add(lbl_9);
	     leftPanel.add(radioCase1);
	     leftPanel.add(radioCase2);
	     leftPanel.add(radioCase3);
	     leftPanel.add(br);
	     leftPanel.add(btn_exec);
	     
	     
	     rightPanel.add(lbl_1);
	     rightPanel.add(resultsArea1);
	 
	     
	     txtFieldPanel.add(lbl_2);
	     txtFieldPanel.add(txt_id);
	     txtFieldPanel.add(lbl_3);
	     txtFieldPanel.add(txt_province);
	     txtFieldPanel.add(lbl_4);
	     txtFieldPanel.add(txt_age);
	     
	     rightPanel.add(txtFieldPanel);
	     
	     rightPanel.add(lbl_5);
	     rightPanel.add(resultsArea2);
	     rightPanel.add(lbl_6);
	     rightPanel.add(resultsArea3);
	   
	     rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
	     leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
	     c.setLayout(new BorderLayout());
	     c.add(leftPanel, BorderLayout.WEST);
	     c.add(rightPanel, BorderLayout.EAST);
	  
		 
		 pack();
		 setVisible(true);
		 
		 btn_exec.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e) {
	            	resultsArea1.setText("Test 1");
	            	resultsArea2.setText("Test 2");
	            	resultsArea3.setText("Test 3");
	            }
	        });
	    }

}
