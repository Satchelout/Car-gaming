
package cars;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class Over extends JFrame implements ActionListener{
    JButton b1;
    Over() {
        
        setLayout(null);
        
        JLabel t= new JLabel ("welcome to Game ");
        t.setFont(new Font("Osward",Font.BOLD,38));
        t.setBounds(200,30, 400 ,50);
        add(t);
        
         b1=new JButton("Start");
         b1.setBounds(200, 130, 200, 30);
        b1.setFont(new Font("Arial",Font.BOLD,20));
        b1.addActionListener(this);
        add(b1);       
        
        
       setSize(700, 400);
        setVisible(true);
        
        setLocation(350,200); 
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            setVisible(false);
           
        }
    }
    public static void main(String args[]) {
        new Over();
    }

}
