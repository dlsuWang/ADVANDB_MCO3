import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Layout extends JFrame {
	
    public static void main(String[] args) {
    	Layout frame = new Layout();
    	frame.setSize(400,400);
        frame.GUI();
    } 
    

    void GUI() {
        Container c = getContentPane();
 
        JPanel p1 = new JPanel();
   	 	JButton btn_cs1 = new JButton("Case 1");
   	 	JButton btn_cs2 = new JButton("Case 2");
     	JButton btn_cs3 = new JButton("Case 3");
     	JTextArea queryArea = new JTextArea("Hello", 20, 50);
     
        p1.setLayout(new BorderLayout());
       
        p1.add(queryArea, BorderLayout.NORTH);
 
        JPanel p2 = new JPanel();
        
        p2.add(btn_cs1);
        p2.add(btn_cs2);
        p2.add(btn_cs3);
 
        c.setLayout(new BorderLayout());
        c.add(p1, BorderLayout.CENTER);
        c.add(p2, BorderLayout.SOUTH);
       
        pack();
        setVisible(true);
        
        btn_cs1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                queryArea.setText("Case 1");
            }
        });
        
        btn_cs2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                queryArea.setText("Case 2");
            }
        });
        
        btn_cs3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                queryArea.setText("Case 3");
            }
        });
  
    }
    
    
}

