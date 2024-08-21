/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package cars;


import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Cars  extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        JFrame app=new JFrame("hello");
        JLabel t1= new JLabel ("You fuckIng fuck U sucks!!");
        t1.setFont(new Font("Osward",Font.BOLD,15));
        t1.setBounds(100,250, 300 ,50);
        app.add(t1);
        
        Work w=new Work();
        app.add(w);
        
        
        
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(500,720);
        app.setLocation(300,0);
        app.setVisible(true);
    }
    
}
