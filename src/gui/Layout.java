package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import transaction.IsolationLevel;
import transaction.Transaction;
import transaction.TransactionRunnable;


public class Layout extends JFrame{
	
	private JRadioButton radioLocal;
    private JRadioButton radioGlobal;
    private JRadioButton radioReadUC;
    private JRadioButton radioReadC;
    private JRadioButton radioRepeatRead;
    private JRadioButton radioSerial;
    private JRadioButton radioCase1;
    private JRadioButton radioCase2;
    private JRadioButton radioCase3;
    
    private JTextField txt_id;
    private JComboBox txt_province;
    private JTextField txt_age;
	
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
	     
	     JTextArea resultsArea1 = new JTextArea("Local / Global", 10, 10);
	     JTextArea resultsArea2 = new JTextArea("Local 2", 10, 10);
	     JTextArea resultsArea3 = new JTextArea("Local 3", 10, 10);
	     
	     txt_id = new JTextField(5);
	     String[] options = { "palawan", "marinduque"};
	     txt_province = new JComboBox(options);
	     txt_age = new JTextField(3);
	     
	     radioLocal = new JRadioButton("Local");
	     radioGlobal = new JRadioButton("Global");
	     radioReadUC = new JRadioButton("Read Uncommitted");
	     radioReadC = new JRadioButton("Read Committed");
	     radioRepeatRead = new JRadioButton("Repeatable Read");
	     radioSerial = new JRadioButton("Serializable");
	     radioCase1 = new JRadioButton("Read - Read");
	     radioCase2 = new JRadioButton("Write - Read");
	     radioCase3 = new JRadioButton("Write - Write");
	     
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
	            	// DELETE AFTER FIXING
	            	resultsArea1.setText("Test 1");
	            	resultsArea2.setText("Test 2");
	            	resultsArea3.setText("Test 3");
	            	// DELETE AFTER FIXING
	            	
	            	if((!radioLocal.isSelected() && !radioGlobal.isSelected()) || 
	            		(!radioReadUC.isSelected() && !radioReadC.isSelected() && !radioRepeatRead.isSelected() && !radioSerial.isSelected()) ||
	            		(!radioCase1.isSelected() && !radioCase2.isSelected() && !radioCase3.isSelected())) {
	            		;
	            	}
	            	else {
	            		
	            	}
	            	
	            }
	        });
	    }
	 
	 public void localCase1() {
		 // Thread 1 and thread 2 read		 
		 Transaction read = new Transaction(getIsolationLevel(), getReadStatement());
		 TransactionRunnable thread1 = new TransactionRunnable(read);
		 TransactionRunnable thread2 = new TransactionRunnable(read);
		 thread1.run();
		 thread2.run();
	 }
	 
	 public void localCase2() {
		 // Thread 1 writes. Thread 2 reads.
		 String statement;
		 Transaction read = new Transaction(getIsolationLevel(), getReadStatement());
		 Transaction write = new Transaction(getIsolationLevel(), getWriteStatement());
		 TransactionRunnable thread1 = new TransactionRunnable(write);
		 TransactionRunnable thread2 = new TransactionRunnable(read);
		 thread1.run();
		 thread2.run();
	 }

	 public void localCase3() {
		 // Thread 1 writes. Thread 2 writes.
		 String statement;
		 
		 
	 }
	 
	 public void globalCase1() {
		 
	 }
	 
	 public void globalCase2() {
		 
	 }
	 
	 public void globalCase3() {
		 
	 }
	 
	 public String getReadStatement() {
		 return "SELECT id, province, age FROM hpq_mem WHERE id = " 
				 + txt_id.getText() + " AND " 
				 + "province = " + (String)txt_province.getSelectedItem() + ";";
	 }
	 
	 public String getWriteStatement() {
		 return "UPDATE hpq_mem SET age = " + txt_age.getText() 
		 	+ " WHERE id = " + txt_id.getText() + " AND " 
		 	+ "province = " + (String)txt_province.getSelectedItem() + "; " 
		 	+ "SELECT id, province, age FROM hpq_mem WHERE id = "
		 	+ txt_id.getText() + " AND "
		 	+ "province = " + (String)txt_province.getSelectedItem() + ";";
	 }
	 
	 public IsolationLevel getIsolationLevel() {
		 if (radioReadUC.isSelected()) {
			 return IsolationLevel.READ_UNCOMMITTED;
		 } else if (radioReadC.isSelected()) {
			 return IsolationLevel.READ_COMMITTED;
		 } else if (radioRepeatRead.isSelected()) {
			 return IsolationLevel.READ_REPEATABLE;
		 } else if (radioSerial.isSelected()) {
			 return IsolationLevel.SERIALIZABLE;
		 } else {
			 return IsolationLevel.NONE;
		 }
	 }
}
