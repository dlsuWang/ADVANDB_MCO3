import javax.swing.*;
import java.awt.*;

public class Layout extends JFrame {
	 
    public static void main(String[] args) {
    	Layout frame = new Layout();
        frame.GUI();
    }
 
    void GUI() {
        Container c = getContentPane();
 
        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        JTextArea queryArea = new JTextArea(20, 50);
        p1.add(queryArea, BorderLayout.NORTH);
 
        
        JPanel p2 = new JPanel();
        p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
        
        JLabel label_rr = new JLabel("Read and Read");
        JLabel br = new JLabel(" ");
        JLabel lbl_iso = new JLabel("Central Isolation Levels");
        JButton btn_gr = new JButton("Global Read");
        JButton btn_lr = new JButton("Local Read");
        JButton btn_dr = new JButton("Double Read");
        JRadioButton readuncommitted1 = new JRadioButton("Read Uncommitted");
        JRadioButton readcommitted1 = new JRadioButton("Read Committed");
        JRadioButton repeatread1 = new JRadioButton("Repeatable Read");
        JRadioButton serial1 = new JRadioButton("Serializable");
        JRadioButton readuncommitted2 = new JRadioButton("Read Uncommitted");
        JRadioButton readcommitted2 = new JRadioButton("Read Committed");
        JRadioButton repeatread2 = new JRadioButton("Repeatable Read");
        JRadioButton serial2 = new JRadioButton("Serializable");
        
//        p2.add(label_rr);
        p2.add(br);
        p2.add(btn_dr);
        p2.add(br);
        p2.add(btn_gr);
        
        p2.add(lbl_iso);
        p2.add(readuncommitted1);
        p2.add(readcommitted1);
        p2.add(repeatread1);
        p2.add(serial1);
        
        p2.add(btn_lr);
        p2.add(lbl_iso);
        p2.add(readuncommitted2);
        p2.add(readcommitted2);
        p2.add(repeatread2);
        p2.add(serial2);
    
        c.setLayout(new BorderLayout());
        c.add(p1, BorderLayout.CENTER);
        c.add(p2, BorderLayout.SOUTH);
        
 
        pack();
        setVisible(true);
    }
}